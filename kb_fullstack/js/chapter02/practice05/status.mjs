// orderStatus 객체를 작성하여 초기 상태를 정의하세요.
// updateStatus 함수는 다음과 같은 동작을 해야 합니다:
// menu와 status를 매개변수로 받습니다.
// setTimeout을 사용해 1초 후에 상태를 업데이트하세요.
// 상태가 업데이트되면 "🔄 [menu] 상태가 '[status]'로 변경되었습니다."를 출력하세요.
// 비동기 처리를 위해 Promise와 resolve()를 사용하세요.

export const orderStatus = {
  samgyeopsal: '주문 대기',
  galbi: '주문 대기',
};

export const updateStatus = (menu, status) => {
  return new Promise((resolve) => {
    setTimeout(() => {
      orderStatus[menu] = status;
      console.log(`🔄 ${menu} 상태가 '${status}'로 변경되었습니다.`);
      resolve();
    }, 1000);
  });
};
