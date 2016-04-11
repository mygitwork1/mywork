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
		, $SET_PC_PARTS_MAKER = $('#SET_PC_PARTS_MAKER')
		, $SET_PC_PARTS_CODE = $('#SET_PC_PARTS_CODE');
	
	get();
	
	$(document.body).on('click', ':button, .UPDATE_BTN', function(e) {
		//console.log(this);
		var $this = $(this)
			, SID = $this.val()
			, $tr = $this.closest('tr')
			, FNAME = $tr.find('.CL_FNAME').text()
			, LNAME = $tr.find('.CL_LNAME').text()
			, ADDRESS = $tr.find('.CL_ADDRESS').text()
			, PC_PARTS_AVAIL = $tr.find('.CL_PC_PARTS_AVAIL').text()
			, PC_PARTS_DESC = $tr.find('.CL_PC_PARTS_DESC').text();
		
		$('#SID').val(SID);
		$SET_PC_PARTS_MAKER.text(FNAME);
		$SET_PC_PARTS_CODE.text(LNAME);
		$('#ADDRESS').text(ADDRESS);
		$('#SET_PC_PARTS_AVAIL').val(PC_PARTS_AVAIL);
		$('#SET_PC_PARTS_DESC').text(PC_PARTS_DESC);
		
		$('#update_response').text("");
	});
	
	$put_example.submit(function(e) {
		e.preventDefault(); //cancel form submit
		
		var obj = $put_example.serializeObject()
			, PC_PARTS_MAKER = $SET_PC_PARTS_MAKER.text()
			, PC_PARTS_CODE = $SET_PC_PARTS_CODE.text();
		
		update(obj, PC_PARTS_MAKER, PC_PARTS_CODE);
	});
});

function update(obj, maker, code) {
	
	ajaxObj = {  
			type: "PUT",
			url: "http://localhost:8001/Restapi/api/put/submit" + maker + "/" + code,
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
				get();
			}, 
			dataType: "json" //request JSON
		};
		
	return $.ajax(ajaxObj);
}

function get() {
	
	var d = new Date()
		, n = d.getTime();
	
	ajaxObj = {  
			type: "GET",
			url: "http://localhost:8001/Restapi/api/put/submit", 
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
					html_string = html_string + getTemplate(val1);
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

function getTemplate(param) {
	return '<tr>' +
				'<td class="CL_PC_PARTS_MAKER">' + param.PC_PARTS_MAKER + '</td>' +
				'<td class="CL_PC_PARTS_CODE">' + param.PC_PARTS_CODE + '</td>' +
				'<td class="CL_PC_PARTS_TITLE">' + param.PC_PARTS_TITLE + '</td>' +
				'<td class="CL_PC_PARTS_AVAIL">' + param.PC_PARTS_AVAIL + '</td>' +
				'<td class="CL_PC_PARTS_DESC">' + param.PC_PARTS_DESC + '</td>' +
				'<td class="CL_PC_PARTS_BTN"> <button class="UPDATE_BTN" value=" ' + param.PC_PARTS_PK + ' " type="button">Update</button> </td>' +
			'</tr>';
}