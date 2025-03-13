const fs = require('fs');
const path = require('path');

const rs = fs.createReadStream(path.join(__dirname, './example.txt'));
const ws = fs.createWriteStream(path.join(__dirname, './example_copy.txt'));

rs.pipe(ws);

console.log('File copied successfully');
