var cartUrl = "/LillaKammaren/cart";
var tag;

function getProductId(productId, boughtMessage, cartcurrent){
    tag = boughtMessage;
    $.ajax(cartUrl, {
       "type": "POST",
       "data": {"productId" : productId},
       "success": addedToCart
    });
}

function addedToCart(data){
    $("#" + tag).empty();
    $("#" + tag).append("Lagt i varukorgen!");
    $("#carttab").empty();
    $("#carttab").append("Varukorg (" + data + ")");
    setTimeout(function(){$("#" + tag).empty();},1500);
}