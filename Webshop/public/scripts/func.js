console.log("Hiii!");

////
middleman();

function updateCartAmount() {
  fetch('/cart/getCartData')
    .then(response => response.json())
    .then(cartData => {
      const cartAmountNum = cartData.cartAmountNum;
      const cartItems = cartData.cartItems;
      console.log("UPDATEAM PODATKE IZ CART-a");

      document.getElementById('cartAmount').textContent = cartAmountNum;
      
      cartItems.forEach(item => {
        const productId = item[0];
        const quantity = item[1];
        const quantityElement = document.getElementById(`quantity_${productId}`);
        if (quantityElement) {
          quantityElement.textContent = quantity;
        }
      });

    })
    .catch(error => console.log('Error updating cart data:', error));
}

function middleman() {
  setTimeout(updateCartAmount, 40);
}

// Add an event listener to call updateCartAmount on every click
document.addEventListener('click', middleman);




  
  






