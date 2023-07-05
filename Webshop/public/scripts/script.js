console.log("U CARTU SMO!");

////
middleman();

function updatePage() {
  fetch('/cart/getCartData')
    .then(response => response.json())
    .then(cartData => {
      const cartProducts = new Map(cartData.cartProducts);
      const totalPrice = cartData.totalPrice;
      console.log("ADIAMOO");
      //console.log("UPDATEAM PODATKE IZ CART-a" + cartProducts);
      //const totalPriceElement = document.getElementById('total-item-' + productId);

      document.getElementById('total-price').textContent = totalPrice;

      for (const [product, quantity] of cartProducts.entries()) {
        const totalPriceElement = document.getElementById('total-item-' + product.id);
        const kolItemElement = document.getElementById('kol-item-' + product.id);

        if (totalPriceElement) {
          if (quantity == 0) {
            newRender();
            break;
          }
          const totalPItem = (quantity * product.price).toFixed(2) + ' €';
          totalPriceElement.textContent = 'Ukupno: ' + totalPItem;
        }
        if (kolItemElement) {
          kolItemElement.textContent = 'Količina: ' + quantity;
        }
        
        
      }
      

    })
    .catch(error => console.log('Error updating cart data:', error));
}

function middleman() {
  setTimeout(updatePage, 40);
}

// Add an event listener to call updateCartAmount on every click
document.addEventListener('click', middleman);

function newRender() {
  location.reload();
}
  

