fs = require('fs');
const path = require('path');

if (fs.existsSync(path.join(__dirname, './test2/test3/test4'))) {
  // 디렉터리가 있다면
  console.log('folder already exists');
} else {
  // 디렉터리가 없다면
  fs.mkdir(
    path.join(__dirname, './test2/test3/test4'),
    { recursive: true },
    (err) => {
      if (err) {
        return console.error(err);
      }
      console.log('folder created');
    }
  );
}
