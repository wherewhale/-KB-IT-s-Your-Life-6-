const fs = require('fs');
const path = require('path');

const data = fs.readFileSync(path.join(__dirname, './example.txt'), 'utf8');
fs.writeFileSync(path.join(__dirname, './example_copy.txt'), data);
