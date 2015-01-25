var removeRow;

$(function(){
    $("#sendOrder").on('submit', function(e){
        var form = $("#sendOrder");
        e.preventDefault();
        
        $.ajax({
            "type": "POST",
            "url": "/LillaKammaren/cart/sendorder",
            "data": form.serialize(),
            "success": orderSent
        });
    });
});

function orderSent(data){
    alert(data);
}

function removeItemById(itemId, toRemove){
    removeRow = toRemove;
    $.ajax({
       "type": "POST",
       "url": "/LillaKammaren/cart/remove",
       "data": {"itemId" : itemId},
       "success": itemRemoved
    });
}

function itemRemoved(data){
    if(data === "0"){
        alert("Alla produkter av den här typen är borttagna!");
	$("#" + removeRow).remove();
    }else{
        location.reload();
    }
}