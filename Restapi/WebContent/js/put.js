/**
 * js file for post.html
 * Please use modern web browser as this file will not attempt to be
 * compatible with older browsers. Use Chrome and open javascript console
 * or Firefox with developer console.
 * 
 * jquery is required
 */
$(document).ready(function() {
	
	var $put_example = $('#put_example')
		, $SET_FNAME = $('#SET_FNAME')
		, $SET_LNAME = $('#SET_LNAME');
	
	getInventory();
	
	$(document.body).on('click', ':button, .UPDATE_BTN', function(e) {
		//console.log(this);
		var $this = $(this)
			, SID = $this.val()
			, $tr = $this.closest('tr')
			, FNAME = $tr.find('.CL_FNAME').text()
			, LNAME = $tr.find('.CL_LNAME').text()
			, ADDRESS = $tr.find('.CL_ADDRESS').text()
			, COURCE = $tr.find('.CL_COURCE').text()
			, GRADE = $tr.find('.CL_GRADE').text();
		
		$('#SET_SID').val(SID);
		$SET_FNAME.text(FNAME);
		$SET_LNAME.text(LNAME);
		$('#SET_ADDRESS').text(ADDRESS);
		$('#SET_COURCE').val(COURCE);
		$('#SET_GRADE').text(GRADE);
		
		$('#update_response').text("");
	});
	
	$put_example.submit(function(e) {
		e.preventDefault(); //cancel form submit
		
		var obj = $put_example.serializeObject()
			, FNAME = $SET_FNAME.text()
			, LNAME = $SET_LNAME.text();
		
		updateInventory(obj, FNAME, LNAME);
	});
});

function updateInventory(obj, fname, lname) {
	
	ajaxObj = {  
			type: "PUT",
			url: "http://localhost:8001/Restapi/api/update/" + fname + "/" + lname,
			data: JSON.stringify(obj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) {
				//console.log(data);
				$('#update_response').text( data[0].MSG );
			},
			complete: function(XMLHttpRequest) {
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
				getInventory();
			}, 
			dataType: "json" //request JSON
		};
		
	return $.ajax(ajaxObj);
}

function getInventory() {
	
	var d = new Date()
		, n = d.getTime();
	
	ajaxObj = {  
			type: "GET",
			url: "http://localhost:8001/Restapi/api/search", 
			data: "ts="+n, 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) { 
				//console.log(data);
				var html_string = "";
				
				$.each(data, function(index1, val1) {
					//console.log(val1);
					html_string = html_string + templateGetInventory(val1);
				});
				
				$('#get_inventory').html("<table border='1'>" + html_string + "</table>");
			},
			complete: function(XMLHttpRequest) {
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
			}, 
			dataType: "json" //request JSON
		};
		
	return $.ajax(ajaxObj);
}

function templateGetInventory(param) {
	return '<tr>' +
				'<td class="CL_FNAME">' + param.FNAME + '</td>' +
				'<td class="CL_LNAME">' + param.LNAME + '</td>' +
				'<td class="CL_ADDRESS">' + param.ADDRESS + '</td>' +
				'<td class="CL_COURCE">' + param.COURCE + '</td>' +
				'<td class="CL_GRADE">' + param.GRADE + '</td>' +
				'<td class="CL_STUDENT_BTN"> <button class="UPDATE_BTN" value=" ' + param.SID + ' " type="button" bgcolor="#00FA00">Update</button> </td>' +
			'</tr>';
}