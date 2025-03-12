// orderProcessor.js에서 processOrder 함수를 import 하세요.
// async 함수인 processOrders를 작성하고, await으로 주문을 순차적으로 처리하세요.
// 세 가지 주문을 순차적으로 처리하세요:
// '삼겹살' 2인분
// '목살' 3인분
// '갈비' 1인분
// 모든 주문 처리가 완료된 후, "🍽️ 모든 주문 처리 완료! 식사 시작!"을 출력하세요.

import { processOrder } from './orderProcessor.mjs';

async function processOrders() {
  try {
    await processOrder({ menu: '삼겹살', quantity: 2 });
    await processOrder({ menu: '목살', quantity: 3 });
    await processOrder({ menu: '갈비', quantity: 1 });
    console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
  } catch (error) {
    console.error(error);
  }
}

processOrders();
