//grill.js: 고기를 비동기적으로 굽는 grillMeat 함수를 작성하고, 외부로 내보내세요.
// grillMeat 함수 동작 흐름
// 고기 이름(menu)을 매개변수로 전달받습니다.
// setTimeout을 사용해 2초 후에 "🔥 [고기 이름]가 다 구워졌습니다!"라는 메시지를 출력합니다.
// resolve()를 호출하여 비동기 처리가 완료되었음을 알립니다.

export const grillMeat = (menu) => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(`${menu}가 다 구워졌습니다!`);
    }, 2000);
  });
};
