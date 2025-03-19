//  get 사용방법
const target = {};
const proxy = new Proxy(target, {
  get(target, prop, receiver) {
    console.log(target, prop, receiver);
  },
});

proxy.test = 5;
console.log(proxy.test); //출력: { test: 5 } test { test: 5 }
