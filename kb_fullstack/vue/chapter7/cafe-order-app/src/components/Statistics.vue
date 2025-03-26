<style>
.statisticsContainer {
  background-color: #e6ffe6;
  padding: 20px;
  border-radius: 5px;
  border: 1px solid #8fbc8f;
}
</style>

<template>
  <div class="statisticsContainer">
    <h2>주문 통계</h2>
    <p>총 주문 횟수: {{ total }}회</p>
    <p>총 매출: {{ sumPrice.toLocaleString() }}원</p>
    <p>
      가장 인기 있는 음료: {{ popularDrink.name }} ({{ popularDrink.count }}회)
    </p>
    <p>가장 많이 선택된 사이즈: {{ popularSize }}</p>
    <p>추가샷 비율: {{ extraShotRatio }}%</p>
  </div>
</template>

<script>
export default {
  name: 'Statistics',
  data() {
    return {};
  },
  props: {
    orders: {
      type: Array,
    },
  },
  computed: {
    total() {
      return this.orders.length;
    },
    sumPrice() {
      return this.orders.reduce((sum, order) => sum + order.drink.price, 0);
    },
    popularDrink() {
      const orderObject = {};
      this.orders.forEach((order) => {
        if (orderObject[order.drink.name]) {
          orderObject[order.drink.name]++;
        } else {
          orderObject[order.drink.name] = 1;
        }
      });
      const maxValue = Math.max(...Object.values(orderObject));
      const maxKey = Object.keys(orderObject).find(
        (key) => orderObject[key] === maxValue
      );
      return { count: maxValue, name: maxKey };
    },
    popularSize() {
      const orderObject = {};
      this.orders.forEach((order) => {
        if (orderObject[order.options.size]) {
          orderObject[order.options.size]++;
        } else {
          orderObject[order.options.size] = 1;
        }
      });
      const maxValue = Math.max(...Object.values(orderObject));
      const maxKey = Object.keys(orderObject).find(
        (key) => orderObject[key] === maxValue
      );
      return maxKey;
    },
    extraShotRatio() {
      const extraShotCount = this.orders.reduce((sum, order) => {
        return sum + (order.options.extraShot ? 1 : 0);
      }, 0);
      return ((extraShotCount / this.orders.length) * 100).toFixed(0);
    },
  },
};
</script>
