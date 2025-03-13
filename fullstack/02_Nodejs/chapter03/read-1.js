fs = require('fs');

const data = fs.readFileSync(`${__dirname}/example.txt`);
console.log(data);
