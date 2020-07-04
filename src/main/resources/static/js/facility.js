function addFacility() {
    $.post({
        url: "facility/add",
        data: JSON.stringify({

            name: $('input[name=name]').val(),
            owner: {id:$('select[name=owner]').val()},
            cityAddress: $('input[name=cityAddress]').val(),
            streetAddress: $('input[name=streetAddress]').val(),
            numberAddress: $('input[name=numberAddress]').val(),
            phone: $('input[name=phone]').val(),
            email: $('input[name=email]').val(),
            description: $('input[name=description]').val()
        }),
        dataType: "json",
        contentType: "application/json",
        success: viewAll
    });
}

function editFacilityRedirect(facilityId){
    $("#viewContainer").load("facility/edit/"+facilityId);
};
function editFacility(facilityId) {
    $.ajax({
        url: "facility/edit/"+facilityId,
        type:'PUT',
        data: JSON.stringify({

            name: $('input[name=name]').val(),
            owner: {id:$('select[name=owner]').val()},
            cityAddress: $('input[name=cityAddress]').val(),
            streetAddress: $('input[name=streetAddress]').val(),
            numberAddress: $('input[name=numberAddress]').val(),
            phone: $('input[name=phone]').val(),
            email: $('input[name=email]').val(),
            description: $('input[name=description]').val()
        }),
        dataType: "json",
        contentType: "application/json",
        success: viewAll
    });
}

function deleteFacilityRedirect(facilityId){
    $("#viewContainer").load("facility/askForDelete/"+facilityId);
};

function viewAll(){
    $("#viewContainer").load("facility/all");
};
function deleteFacility(facilityId) {
    $.ajax({
        url: "facility/delete/" + facilityId,
        type: 'DELETE',
        success: viewAll
    })
};