// processOrder 함수를 작성해, 주문 수량이 3인분 이상일 때만 주문을 처리하세요.
// 조건에 맞지 않는 주문은 "주문 최소 수량 미달" 메시지를 반환하세요.

export const processOrder = (order) => {
  // Promise를 return하세요.
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (order.quantity < 3) {
        reject(
          `❌ ${order.menu} ${order.quantity}인분은 주문 최소 수량 미달입니다.`
        );
      } else {
        resolve(`✅ ${order.menu} ${order.quantity}인분 주문 처리 완료!`);
      }
    }, 1000);
  });
};
