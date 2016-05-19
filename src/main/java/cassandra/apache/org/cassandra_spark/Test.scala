package cassandra.apache.org.cassandra_spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.datastax.spark.connector._

object Test {
  def main(args: Array[String]): Unit = {
   val sparkMasterHost = "127.0.0.1"
   val cassandraHost = "127.0.0.1"
   val keyspace = "test"
   val table = "words"

// Tell Spark the address of one Cassandra node:
val conf = new SparkConf(true)
   .setMaster("local[*]")
   .setAppName("Test")
   .set("spark.cassandra.connection.host", cassandraHost)

// Connect to the Spark cluster:
val sc = new SparkContext(conf)

   // Write two rows to the table:
 val rows=sc.parallelize(Seq(("good",10),("bad",10)))  
 rows.saveToCassandra(keyspace, table)
 
 
// Read the table and print its contents:
val rdd = sc.cassandraTable(keyspace, table)
rdd.toArray().foreach(println)
println("End...")
  }
}