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
    console.log(data);
    location.reload();
    $("#orderConfirmMsg").append("Din order har skickats!");
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
    }
    location.reload();
}

function emptyCart(empty){
    $.ajax({
       "type": "POST",
       "url": "/LillaKammaren/cart/empty",
       "data": {"empty" : empty},
       "success": emptiedCart
    });
}

function emptiedCart(){
    location.reload();
}