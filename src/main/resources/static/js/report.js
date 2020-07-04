function addReport() {
    $.post({
        url: "report/add",
        data: JSON.stringify({

            facility: {id:$('select[name=facility]').val()},
            reportDate: $('input[name=reportDate]').val(),
            serviceDate: $('input[name=serviceDate]').val(),
            serviceman: {id:$('select[name=serviceman]').val()},
            description: $('input[name=description]').val()
        }),
        dataType: "json",
        contentType: "application/json",
        success: viewAll
    });
}

function editReportRedirect(reportId){
    $("#viewContainer").load("report/edit/"+reportId);
};
function editReport(reportId) {
    $.ajax({
        url: "report/edit/"+reportId,
        type:'PUT',
        data: JSON.stringify({

            facility: {id:$('select[name=facility]').val()},
            reportDate: $('input[name=reportDate]').val(),
            serviceDate: $('input[name=serviceDate]').val(),
            serviceman: {id:$('select[name=serviceman]').val()},
            description: $('input[name=description]').val()
        }),
        dataType: "json",
        contentType: "application/json",
        success: viewAll
    });
}

function deleteReportRedirect(reportId){
    $("#viewContainer").load("report/askForDelete/"+reportId);
};

function viewAll(){
    $("#viewContainer").load("report/all");
};
function deleteReport(reportId) {
    $.ajax({
        url: "report/delete/" + reportId,
        type: 'DELETE',
        success: viewAll
    })
};