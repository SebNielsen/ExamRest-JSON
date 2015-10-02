$('document').ready(function(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/ExamRest-Json/api/adresses/11/fname,lname,street,city",
        success: function (data) {
            fillTableWithData(data);
        }
    });

});

function fillTableWithData(data) {
    $("#tableBody > tr").remove();
    data.forEach(function (person) {
        $('#tableBody').append("<tr><td>" + person.fname + "</td>" +
                "<td>" + person.lname + "</td>" +
                "<td>" + person.street + "</td>" +
                "<td>" + person.city + "</td>" +
                "</tr>");
    });
}
;