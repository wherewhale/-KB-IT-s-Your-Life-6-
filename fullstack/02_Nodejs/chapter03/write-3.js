fs = require('fs');
fs.readFile('./example.txt', 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  }

  //fs.writeFileSync : 넣어준 내용으로 새로운 파일을 쓴다. (동기)
  fs.writeFile('./text-2.txt', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('text-2.txt is saved!');
  });
});
