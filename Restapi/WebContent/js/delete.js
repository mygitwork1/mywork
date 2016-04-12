/**
 * js file for post.html
 * Please use modern web browser as this file will not attempt to be
 * compatible with older browsers. Use Chrome and open javascript console
 * or Firefox with developer console.
 * 
 * jquery is required
 */
$(document).ready(function() {
	
	getInventory();
	
	$(document.body).on('click', ':button, .DELETE_BTN', function(e) {
		//console.log(this);
		var $this = $(this)
			, SID = $this.val()
			, obj = {SID : SID}
			, $tr = $this.closest('tr')
			, FNAME = $tr.find('.CL_FNAME').text()
			, LNAME = $tr.find('.CL_LNAME').text();
		
		deleteInventory(obj, FNAME, LNAME);
	});
});

function deleteInventory(obj, fname, lname) {
	
	ajaxObj = {  
			type: "DELETE",
			url: "http://localhost:8001/Restapi/api/delete/" + fname + "/" + lname,
			data: JSON.stringify(obj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR.responseText);
			},
			success: function(data) {
				//console.log(data);
				$('#delete_response').text( data[0].MSG );
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
				'<td class="CL_STUDENT_BTN"> <button class="UPDATE_BTN" value=" ' + param.SID + ' " type="button">Delete</button> </td>' +
			'</tr>';
}