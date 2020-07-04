document.addEventListener("DOMContentLoaded", function(){
    $("#btn-addReport").click(function(){
        $("#viewContainer").load("report/add");
    });
    $("#btn-reports").click(function(){
        $("#viewContainer").load("report/all");
    });
    $("#btn-addFacility").click(function(){
        $("#viewContainer").load("facility/add");
    });
    $("#btn-facilities").click(function(){
        $("#viewContainer").load("facility/all");
    });
    $("#btn-calendar").click(function(){
        $("#viewContainer").load("/logout",null,function () {
            window.location="/";
        });
    });
});