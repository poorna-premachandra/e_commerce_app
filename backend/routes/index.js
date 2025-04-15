var express = require("express");
var router = express.Router();

/* GET home page. */
router.get("/", function (req, res, next) {
  // res.render('index', { title: 'Express' });
  res.json({
    message: "Demo E-Commerce API",
    status: "Active",
  });
});

module.exports = router;
