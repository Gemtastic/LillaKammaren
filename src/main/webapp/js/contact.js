$(function(){
    $("#contactMessage").on('Submit', function(e){
        alert("You clicked the button");
        var form = $("#contactMessage");
        e.preventDefault();
        
        $.ajax({
            "type": "POST",
            "url": "/LillaKammaren/contact",
            "data": form.serialize(),
            "success": messageSent
//            "success": function(data){
////                $("#msgSendingSuccess").append(data + "sent!");
//                alert("You posted a message!" + data);
//            }
        });
    });
});

function messageSent(data){
    alert(data);
}