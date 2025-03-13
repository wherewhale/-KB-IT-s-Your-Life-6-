fs = require('fs');

const data = fs.readFileSync(`${__dirname}/example.txt`, 'utf8');
console.log(data);
