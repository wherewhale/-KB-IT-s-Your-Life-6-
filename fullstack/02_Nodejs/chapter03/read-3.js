fs = require('fs');

// 일반적으로는 잘못된 코드이다. (에러 처리에 대한 코드가 존재해야 한다. return이나 throw로 에러를 던져야 한다.)
fs.readFile('./example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  }
  console.log(data);
});
