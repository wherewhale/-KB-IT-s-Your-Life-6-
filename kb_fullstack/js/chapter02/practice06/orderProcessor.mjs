// calculateTotal 함수주문 배열을 받아 각 메뉴별로 총 주문 수량을 계산하세요.
// 결과는 객체 형태로 반환해야 합니다.
// isTopMenu 함수특정 메뉴가 가장 많이 주문된 메뉴인지 확인하세요.
// true 또는 false로 반환되어야 합니다.

export const calculateTotal = (orders) => {
  const result = {};
  orders.forEach((order) => {
    if (result[order.menu]) {
      result[order.menu] += order.quantity;
    } else {
      result[order.menu] = order.quantity;
    }
  });

  return result;
};

export const isTopMenu = (orders, topMenu) => {
  let topMenuName;

  const keys = Object.keys(orders); // ['name', 'weight', 'price', 'isFresh']

  for (let i = 0; i < keys.length; i++) {
    const key = keys[i]; // 각각의 키
    const value = orders[key]; // 각각의 키에 해당하는 각각의 값

    if (value > orders[topMenuName] || topMenuName === undefined) {
      topMenuName = key;
    }
  }

  return topMenu === topMenuName;
};
