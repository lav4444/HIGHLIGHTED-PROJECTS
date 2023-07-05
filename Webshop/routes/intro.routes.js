const express = require('express');
const router = express.Router();
const data = require('../data/mydata');

router.get('/', function(req, res, next) {
    const products = data.categories[0].products.flatMap(product => product);
    const cartAmountNum = req.session.cartAmountNum || 0;
    const cartItems = req.session.cartItems;
    console.log("!!!!EVO ME!!!!!");
  
    return res.render('glup', { 
      categoryNameNavbar: undefined,
      categories: [],
      products: [],
      sessionID: req.sessionID,
      cartAmountNum: cartAmountNum,
      cartItems: cartItems
    });
});

module.exports = router;