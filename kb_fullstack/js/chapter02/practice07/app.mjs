// 다양한 고기 메뉴와 수량을 담은 orders 배열을 작성하세요.
// async 함수 processAllOrders를 작성하고, for...of 반복문과 await을 사용해 주문을 하나씩 처리하세요.
// 결과 메시지는 console.log로 출력하세요.

import { processOrder } from './orderProcessor.mjs';

async function processAllOrders() {
  const orders = [
    { menu: '삼겹살', quantity: 2 },
    { menu: '목살', quantity: 3 },
    { menu: '갈비', quantity: 1 },
    { menu: '항정살', quantity: 4 },
    //... more orders...
  ];

  for (const order of orders) {
    try {
      const result = await processOrder(order);
      console.log(result);
    } catch (error) {
      console.log(error);
    }
  }
}

processAllOrders();
