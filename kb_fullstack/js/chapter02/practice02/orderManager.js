// 고기 주문을 추가하는 함수와 주문 목록을 관리하는 배열

module.exports = {
  orders: [],
  addOrder: function (menu, quantity) {
    if (this.orders.length === 0) {
      this.orders = [0, 0];
    }
    if (menu === '삼겹살') {
      this.orders[0] += quantity;
    } else {
      this.orders[1] += quantity;
    }
  },
};
