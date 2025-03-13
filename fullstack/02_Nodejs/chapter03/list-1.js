const fs = require('fs');
const path = require('path');

//부모의 워킹 디렉토리를 기반으로 하게 된다.
let files = fs.readdirSync('./');
console.log(files);

//현재 디렉토리를 기반으로 사용하기 위해서는 __dirname 사용
let curFiles = fs.readdirSync(__dirname);
console.log(curFiles);

//절대경로 표현법
console.log(path.join(__dirname, './'));
