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

	var initDataRows = $('.data-rows');
	$.each(initDataRows, function(i, row){

		if($(row).find('.attendacechecck').is(':checked')){
			$(row).find('.homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#personalLeaveReason, #leaveType, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').attr("disabled", true);
		}

		if($(row).find('.homeOfficeChecck').is(':checked')){
			$(row).find('.attendacechecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck').prop('checked', false);
			$(row).find('#leaveType').val("");
			$(row).find('#leaveType, .attendacechecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck').attr("disabled", true);
		}

		if($(row).find('.publicHolidayChecck').is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#intime, #outtime').val("");
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').attr("disabled", true);
		}

		if($(row).find('.govtHolidayChecck').is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#intime, #outtime').val("");
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').attr("disabled", true);
		}

		if($(row).find('.personalLeaveChecck').is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck').prop('checked', false);
			$(row).find('#intime, #outtime').val("");
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, #intime, #outtime').attr("disabled", true);
		}
	})

	$('.attendacechecck').off('change').on('change', function(e){
		e.preventDefault();
		var row = $(this).parents('tr');
		if($(this).is(':checked')){
			$(row).find('.homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#personalLeaveReason, #leaveType, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').attr("disabled", true);
		} else {
			$(row).find('#personalLeaveReason, #leaveType, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').removeAttr("disabled");
		}
	})

	$('.homeOfficeChecck').off('change').on('change', function(e){
		e.preventDefault();
		var row = $(this).parents('tr');
		if($(this).is(':checked')){
			$(row).find('.attendacechecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck').prop('checked', false);
			$(row).find('#leaveType').val("");
			$(row).find('#leaveType, .attendacechecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck').attr("disabled", true);
		} else {
			$(row).find('#leaveType, .attendacechecck, .publicHolidayChecck, .govtHolidayChecck, .personalLeaveChecck').removeAttr("disabled");
		}
	})

	$('.publicHolidayChecck').off('change').on('change', function(e){
		e.preventDefault();
		var row = $(this).parents('tr');
		if($(this).is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#intime, #outtime').val("");
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').attr("disabled", true);
		} else {
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .govtHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').removeAttr("disabled");
		}
	})

	$('.govtHolidayChecck').off('change').on('change', function(e){
		e.preventDefault();
		var row = $(this).parents('tr');
		if($(this).is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .personalLeaveChecck, .approvedChecck').prop('checked', false);
			$(row).find('#leaveType, #personalLeaveReason').val("");
			$(row).find('#intime, #outtime').val("");
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').attr("disabled", true);
		} else {
			$(row).find('#personalLeaveReason, #leaveType, .attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .personalLeaveChecck, .approvedChecck, #intime, #outtime').removeAttr("disabled");
		}
	})

	$('.personalLeaveChecck').off('change').on('change', function(e){
		e.preventDefault();
		var row = $(this).parents('tr');
		if($(this).is(':checked')){
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck').prop('checked', false);
			$(row).find('#intime, #outtime').val("");
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, #intime, #outtime').attr("disabled", true);
		} else {
			$(row).find('.attendacechecck, .homeOfficeChecck, .publicHolidayChecck, .govtHolidayChecck, #intime, #outtime').removeAttr("disabled");
		}
	})

	$('.submit-present').off('click').on('click', function(e){
		e.preventDefault();

		var attendaces = [];

		var dataRows = $('.data-rows');
		$.each(dataRows, function(i, row){
			attendaces.push({
				id : $(row).find('.attendacechecck').data('id'),
				userId : $(row).find('.attendacechecck').data('userid'),
				present : $(row).find('.attendacechecck').is(':checked'),
				homeOffice : $(row).find('.homeOfficeChecck').is(':checked'),
				intime : $(row).find('#intime').val(),
				outtime : $(row).find('#outtime').val(),
				publicHoliday : $(row).find('.publicHolidayChecck').is(':checked'),
				govtHoliday : $(row).find('.govtHolidayChecck').is(':checked'),
				personalLeave : $(row).find('.personalLeaveChecck').is(':checked'),
				leaveType : $(row).find('#leaveType').val(),
				personalLeaveReason : $(row).find('#personalLeaveReason').val(),
				approved : $(row).find('.approvedChecck').is(':checked'),
			});
			
		})

		var fas = {
			"date" : $('#date').val(),
			"attendacnes" : attendaces
		}

		var obj = {
			"fas" : fas
		}

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