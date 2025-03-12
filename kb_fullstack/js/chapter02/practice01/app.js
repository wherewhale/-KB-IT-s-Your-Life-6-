const orderGogi = require('./order');

if (orderGogi[0] > 0) {
  console.log(`✅ 삼겹살 주문 수량: ${orderGogi[0]}인분`);
} else {
  console.log('❌ 삼겹살 주문 내역이 없습니다.');
}
