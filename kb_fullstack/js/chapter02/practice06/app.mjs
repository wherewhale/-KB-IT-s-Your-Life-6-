// orderList.js에서 orders 배열을 가져오세요.
// orderProcessor.js에서 calculateTotal과 isTopMenu를 as를 사용해 다른 이름으로 가져오세요.
// calculateTotal → calc
// isTopMenu → isTop
// 결과를 다음과 같은 형식으로 출력하세요.
// :흰색_확인_표시: 최종 예상 출력
// ✅ 총 주문 수량: { 삼겹살: 5, 목살: 7, 갈비: 4 }
// 🥩 삼겹살이 가장 인기 메뉴인가요? 아니오!

import {
  calculateTotal as calc,
  isTopMenu as isTop,
} from './orderProcessor.mjs';
import orders from './orderList.mjs';

const result = calc(orders);

console.log(`✅ 총 주문 수량 : ${JSON.stringify(result)}`);
console.log(
  `🥩 삼겹살이 가장 인기 메뉴인가요? ${
    isTop('삼겹살', result) ? '네' : '아니오'
  }!`
);
