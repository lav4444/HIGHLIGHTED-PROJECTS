const express = require('express');
const session = require('express-session');
const path = require('path');

const app = express();

// Create a map to store session records
const sessionPohrana = new Map();

app.use(express.static(path.join(__dirname, 'public'), {
  setHeaders: (res, filePath) => {
    if (filePath.endsWith('.js')) {
      res.setHeader('Content-Type', 'text/javascript');
    }
  }
}));

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

const sessionManager = require('./sessions/sessionAnony');
app.use(sessionManager(sessionPohrana)); // Pass sessionPohrana map to the sessionManager middleware

app.use(
    session({
      secret: 'anything',
      resave: false,
      saveUninitialized: true,

    })
  );

const introRouter = require('./routes/intro.routes');
const homeRouter = require('./routes/home.routes');
const cartRouter = require('./routes/cart.routes');

app.use('/', introRouter);
app.use('/home', homeRouter);
app.use('/cart', cartRouter);

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});

