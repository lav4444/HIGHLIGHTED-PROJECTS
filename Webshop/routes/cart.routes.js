var express = require('express');
var router = express.Router();
const data = require('../data/mydata');

router.post('/add/:id', function (req, res, next) {
    req.session.cartAmountNum++;
    //console.log("ADDING " + req.params.id + " TO CART");
    const productId = req.params.id;
    let cartItems = new Map(req.session.cartItems); // Create a copy of the map
  
  
    // Check if the product already exists in the cart
    if (cartItems.has(productId)) {
      // Increment the quantity of the existing product in the cart
      cartItems.set(productId, cartItems.get(productId) + 1);
    } else {
      // Add the product to the cart with a quantity of 1
      cartItems.set(productId, 1);
    }
    // Update the cartItems in req.session
    req.session.cartItems = cartItems;
    // Print all cart items to the console
    console.log(cartItems);
    console.log("cartAmountNum: " + req.session.cartAmountNum);

    // Send a response with the updated cartAmountNum
    
    return res.sendStatus(204); // Server doesn't render a new page, local JavaScript handles that
  });

  router.post('/remove/:id', function (req, res, next) {
    //console.log("REMOVING " + req.params.id + " FROM CART");
    const productId = req.params.id;
    let cartItems = new Map(req.session.cartItems); // Create a copy of the map
  
    // Check if the product already exists in the cart
    if (cartItems.has(productId)) {
        if (cartItems.get(productId) > 0) {
            req.session.cartAmountNum--;
            cartItems.set(productId, cartItems.get(productId) - 1);
        }
    } 
    // Update the cartItems in req.session
    req.session.cartItems = cartItems;
    // Print all cart items to the console
    console.log(cartItems);
    console.log("cartAmountNum: " + req.session.cartAmountNum);

    // Send a response with the updated cartAmountNum
    
    return res.sendStatus(204); // Server doesn't render a new page, local JavaScript handles that
  });
  
  router.get('/getAll', (req, res) => {
    const cartItems = Array.from(req.session.cartItems);
    const cartAmountNum = req.session.cartAmountNum || 0;
    let totalPrice = 0;
    
    // Create a new map {product, quantity}
    const cartProducts = new Map();
    for (let i = 0; i < cartItems.length; i++) {
        const [productId, quantity] = cartItems[i];

      
        let foundProduct = null;
        for (const category23 of data.categories) {
            for (const product of category23.products) {
                //console.log("ITERIRAMMMM " + product.id + " -- " + productId);
                if (product.id == productId) {
                    foundProduct = product;
                    break;
                }
            }            
            if (foundProduct) {
                break;
            }
        }
      
        if (foundProduct && quantity > 0) {
            totalPrice += foundProduct.price * quantity;
            cartProducts.set(foundProduct, quantity);
        }
    }    
      
    console.log();
    console.log(Array.from(cartProducts, ([product, quantity]) => `Product: ${product.name}, Quantity: ${quantity}`).join('\n'));
    console.log();

    return res.render('cart', { 
        sessionID: req.sessionID,
        cartAmountNum: cartAmountNum,
        cartProducts: cartProducts,
        totalPrice: totalPrice
      });
  });

  router.get('/getCartData', (req, res) => {
    const cartProducts = new Map();
    cartAmountNum = req.session.cartAmountNum || 0;
    const cartItems = Array.from(req.session.cartItems);
    let totalPrice = 0;

    for (let i = 0; i < cartItems.length; i++) {
        const [productId, quantity] = cartItems[i];

      
        let foundProduct = null;
        for (const category23 of data.categories) {
            for (const product of category23.products) {
                //console.log("ITERIRAMMMM " + product.id + " -- " + productId);
                if (product.id == productId) {
                    foundProduct = product;
                    break;
                }
            }            
            if (foundProduct) {
                break;
            }
        }
      
        if (foundProduct) {
            totalPrice += foundProduct.price * quantity;
            cartProducts.set(foundProduct, quantity);
        }
    } 
  
    const cartData = {
      cartAmountNum: cartAmountNum,
      cartItems: cartItems,
      cartProducts: Array.from(cartProducts),
      totalPrice: totalPrice
    };
  
    res.json(cartData);
  });

  router.post('/removeAll', (req, res) => {
    req.session.cartItems = new Map(); // Clear the cartItems map
    req.session.cartAmountNum = 0; // Reset the cartAmountNum
  
    // Render the cart.ejs view again with the updated cart data
    return res.redirect('/cart/getAll');
  });


module.exports = router;