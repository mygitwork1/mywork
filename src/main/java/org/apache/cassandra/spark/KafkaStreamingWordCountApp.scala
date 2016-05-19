package org.apache.cassandra.spark

import kafka.serializer.StringDecoder
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.{Logging, SparkConf, SparkContext}

import com.datastax.spark.connector.cql.CassandraConnector
import com.datastax.spark.connector.embedded.Event.WordCount
import com.datastax.spark.connector.embedded._
import com.datastax.spark.connector.streaming._


object KafkaStreamingWordCountApp {
  def main(args: Array[String]): Unit = {
    
    val path ="/home/hduser/Documents/data/words"
    
    println("Cassandra spark connection demo!!!")
    val topic = "streaming.wordcount.topic"
    val group = "streaming.wordcount.group"
    
    case class wordcount(word:String,count:Int)extends Serializable
    
    /** Starts the Kafka broker. */
    lazy val kafka_broker = new EmbeddedKafka()
    
    val conf = new SparkConf(true).
               setMaster("local[*]")
               .setAppName(getClass.getSimpleName)
               //.set("spark.cassandra.connection.host","127.0.0.1")
               .set("spark.executor.memory", "1g")
               .set("spark.cores.max", "1")
               .set("spark.cassandra.connection.host", "127.0.0.1")
               
    /** First time Creates the keyspace and table in Cassandra. *//*
    CassandraConnector(conf).withSessionDo{session =>
      session.execute(s"CREATE KEYSPACE IF NOT EXISTS kafka_streaming WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1 }")
      session.execute(s"CREATE TABLE IF NOT EXISTS kafka_streaming.wordcount (word TEXT PRIMARY KEY, count COUNTER)")
      session.execute(s"TRUNCATE kafka_streaming.wordcount")
      }*/
      
      kafka_broker.createTopic(topic)
      
      val kafka_producer = new KafkaProducer[String,String](kafka_broker.kafkaConfig)
      val toKafka =(line:String)=>kafka_producer.send(topic,group,line.toLowerCase())
      
      val sc = new SparkContext(conf)
      
      /* The write to kafka from spark, read from kafka in the stream and write to cassandra would happen
  from separate components in a production env. This is a simple demo to show the code for integration. */
      
      sc.textFile(path).flatMap(_.split("\\s+")).toLocalIterator.foreach(toKafka)      
      kafka_producer.close()
      
      /** Creates the Spark Streaming context. */
      val ssc = new StreamingContext(sc,Seconds(15))
      
      /** Creates an input stream that pulls messages from a Kafka Broker. */
      val stream = KafkaUtils.createStream[String,String,StringDecoder,StringDecoder](ssc, kafka_broker.kafkaParams, Map(topic -> 1),StorageLevel.MEMORY_ONLY)
      
      stream.map(_._2).countByValue().saveToCassandra("kafka_streaming", "wordcount")
      ssc.start()
   //validate()
  shutdown()

  def shutdown(): Unit = {
   // log.info("Shutting down.")
    ssc.stop(stopSparkContext = true, stopGracefully = false)
    kafka_broker.shutdown()
  }

  /*def validate(): Unit = {
    val rdd = ssc.cassandraTable[wordcount]("kafka_streaming", "wordcount")
    import scala.concurrent.duration._
    awaitCond(rdd.toLocalIterator.size > 100, 5.seconds)
    rdd.collect foreach println
  }*/
    
   
    
  }
}