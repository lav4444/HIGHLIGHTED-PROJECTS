const uuid = require('uuid');

function sessionManager(sessionPohrana) {
    const SESSION_TIMEOUT = 20 * 60 * 1000; // 20 minutes in milliseconds

    function destroyExpiredSessions() {
        const now = Date.now();
        sessionPohrana.forEach((session, sessionId) => {
          if (now - session.lastUsed >= SESSION_TIMEOUT) {
            // Create a new session
            const newSession = {
              id: uuid.v4(), // Generate a new session ID
              created: Date.now(),
              cartItems: new Map(),
              cartAmountNum: 0,
            };
      
            // Replace the expired session with the new session
            sessionPohrana.set(sessionId, newSession);
          }
        });
    }
    setInterval(destroyExpiredSessions, 30000); // Check for expired sessions 30sec

  return function (req, res, next) {
    const sessionID = req.sessionID;
    console.log("Received sessionID: " + sessionID);

    // Fetch session record from sessionPohrana if exists
    let session = sessionPohrana.get(sessionID);

    if (session) {
      console.log("Session record found: " + JSON.stringify(session));
    } else {
      console.log("Session record not found");
      // Create a new session
      session = {
        id: sessionID,
        created: Date.now(),
        cartItems: new Map(), // Initialize an empty Map for cart items
        cartAmountNum: 0, // Initialize cartAmountNum to 0
      };
      sessionPohrana.set(sessionID, session);
    }

    // Update last used timestamp
    session.lastUsed = Date.now();

    // Attach session record to the request object
    req.session = session;
    console.log("Session data attached to the request object: " + JSON.stringify(session));

    next();
  };
}

module.exports = sessionManager;
