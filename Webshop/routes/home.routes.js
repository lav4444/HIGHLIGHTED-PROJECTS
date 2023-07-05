const express = require('express');
const router = express.Router();
const data = require('../data/mydata');


router.get('/getCategories', function(req, res, next) {
  const products = data.categories[0].products.flatMap(product => product);
  const cartAmountNum = req.session.cartAmountNum || 0;
  const cartItems = req.session.cartItems;
  console.log("!!!!HOME-ROUTES-GET-CATEGORY!!!!!");

  return res.render('home', { 
    categoryNameNavbar: undefined,
    categories: data.categories,
    products: [],
    sessionID: req.sessionID,
    cartAmountNum: cartAmountNum,
    cartItems: cartItems
  });
});

router.get('/getProducts/:categoryName', function(req, res, next) {
  const categoryName = req.params.categoryName;
  const category = data.categories.find(category => category.name === categoryName);
  const cartItems = req.session.cartItems;
  const cartAmountNum = req.session.cartAmountNum || 0;

  if (category) {
    const products = category.products;
    return res.render('home', { 
      categoryNameNavbar: categoryName,
      categories: data.categories,
      products: products,
      sessionID: req.sessionID,
      cartAmountNum: cartAmountNum,
      cartItems: cartItems
    });
  } else {
    console.log("!!!!Category not found!!!!!");
    return res.render('home', { 
      categoryNameNavbar: categoryName,
      categories: data.categories,
      products: [],
      sessionID: req.sessionID,
      cartAmountNum: cartAmountNum,
      cartItems: cartItems
    });
  }
});

module.exports = router;