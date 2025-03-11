// 함수를 매개변수로 취한다.
function callTenTimes(callback) {
  for (let i = 0; i < 10; i++) {
    callback();
  }
}

let fun = function () {
  console.log('함수 호출');
};

callTenTimes(fun);
