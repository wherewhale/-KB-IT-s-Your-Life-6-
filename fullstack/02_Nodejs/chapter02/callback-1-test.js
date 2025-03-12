const func = function (coffee, callback) {
  callback(coffee);
};

const order = (coffee, callback) => {
  console.log(`${coffee} 주문 접수`);
  setTimeout(func(coffee, callback), 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

order('아메리카노', display);
