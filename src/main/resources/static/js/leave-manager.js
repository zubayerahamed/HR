$(document).ready(function(){
	function getBasepath(){
		var basePath = $('a.basePath').attr('href');
		basePath = basePath.split('/')[1];
		var href = location.href.split('/');
		if(basePath != ''){
			return href[0] + '//' + href[2] + '/' + basePath;
		}
		return href[0] + '//' + href[2];
	}

	$('.submit-lm').off('click').on('click', function(e){
		e.preventDefault();

		var lmList = [];

		var dataRows = $('.data-rows');
		$.each(dataRows, function(i, row){
			lmList.push({
				id : $(row).find('.lmid').val(),
				userId : $(row).find('.userId').val(),
				totalAllocatedLeave : $(row).find('.totalAllocatedLeave').val(),
				totalUnpaidLeave : $(row).find('.totalUnpaidLeave').val(),
				carryFromPrevYear : $(row).find('.carryFromPrevYear').val(),
				alreadyTaken : $(row).find('.alreadyTaken').val(),
				annual : $(row).find('.annual').val(),
				casual : $(row).find('.casual').val(),
				sick : $(row).find('.sick').val(),
				approved : $(row).find('.approved').val(),
				notApproved : $(row).find('.notApproved').val()
			});
			
		})

		var fas = {
			"year" : $('#year').val(),
			"lmList" : lmList
		}

		var obj = {
			"fas" : fas
		}
		
		console.log(obj);

		$.ajax({
			url : $('.submitUrl').attr('href'),
			type : 'POST',
			contentType: "application/json",
			data: JSON.stringify(obj),
			dataType: 'json',
			success : function(d) {
				alert(d.message);
				setTimeout(() => {
					window.location.replace(getBasepath() + d.redirectUrl);
				}, 1000);
			}, 
			error : function(jqXHR, status, errorThrown){
			}
		});

	})

})