$(function(){
    $("#contactMessage").on('submit', function(e){
        var messageForm = $("#contactMessage");
        e.preventDefault();
        
        $.ajax({
            "type": "POST",
            "url": "/LillaKammaren/contact/sendmessage",
            "data": messageForm.serialize(),
            "success": messageSent
        });
    });
});

function messageSent(data){
    location.reload();
    $("#msgSendingSuccess").append("Ditt meddelande har skickats!");
}