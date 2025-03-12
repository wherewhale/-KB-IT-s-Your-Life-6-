// order 객체를 받아 비동기적으로 처리하는 processOrder 함수를 작성하세요.
// setTimeout을 사용하여 1초 후에 주문이 완료되었다는 메시지를 출력하세요.
// 비동기 처리를 위해 **Promise*를 사용하세요.
// 외부에서 사용할 수 있도록 export 하세요.

export const processOrder = (order) => {
  // Promise를 return하세요.
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log(`${order.menu} ${order.quantity}인분 주문 처리 완료!`);
      resolve();
    }, 1000);
  });
};
