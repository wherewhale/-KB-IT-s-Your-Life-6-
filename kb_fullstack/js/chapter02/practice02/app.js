const orderManager = require('./orderManager');

// orderManager.addOrder('삼겹살', 3);
// orderManager.addOrder('목살', 2);

console.log('✅ 현재 주문 내역:');
if (orderManager.orders.length === 0) {
  console.log(`❌ 주문 내역이 없습니다.`);
}

orderManager.orders.forEach((order, idx) => {
  if (idx === 0) {
    console.log(`삼겹살: ${order}인분`);
  } else {
    console.log(`삼겹살: ${order}인분`);
  }
});
