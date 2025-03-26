<style>
.historyContainer {
  padding: 20px;
  margin-top: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: lightgray;
}
</style>

<template>
  <div class="historyContainer">
    <h2>주문 내역</h2>
    <div v-if="orders.length > 0">
      <div v-for="order in orders">
        <p>{{ order.timestamp }}</p>
        <p>음료: {{ order.drink.name }}</p>
        <p>사이즈: {{ order.options.size }}</p>
        <p>추가 샷: {{ order.options.extraShot ? '추가' : '없음' }}</p>
        <p>얼음 양: {{ order.options.ice }}</p>
        <p>금액: {{ order.drink.price }}</p>
        <hr />
      </div>
    </div>
    <div v-else>
      <p>주문 내역이 없습니다.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderHistory',
  props: {
    orders: {
      type: Array,
    },
  },
};
</script>
