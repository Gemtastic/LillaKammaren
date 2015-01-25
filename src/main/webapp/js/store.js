var cartUrl = "/LillaKammaren/cart";

function getProductId(productId){
    alert(productId);
    $.ajax(cartUrl, {
       "type": "POST",
       "data": {"productId" : productId},
       "success": addedToCart
    });
}

function addedToCart(data){
    if(data.success){
        console.log("Added to cart!");
    } else{
        console.log("Not added to cart.");
    }
    alert(data);
}