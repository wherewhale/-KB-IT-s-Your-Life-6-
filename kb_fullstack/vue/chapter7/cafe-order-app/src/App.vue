<style>
.container {
  padding: 20px;
  width: fit-content;
}
.selected {
  margin-top: 20px;
  background-color: #e6ffe6;
  padding: 20px;
  border: 1px solid #8fbc8f;
}
.statisticsButton {
  background-color: #8fbc8f;
  color: white;
  padding: 10px 20px;
  border-radius: 6px;
}
.statisticsButton:hover {
  background-color: #78a678;
}
</style>

<template>
  <main class="container">
    <h1>카페 주문 앱</h1>
    <h2>메뉴 선택</h2>
    <MenuList
      v-for="menu in menuList"
      :key="menu.name"
      :menu="menu"
      @select-drink="onSelectDrink(menu)"
    ></MenuList>
    <div v-if="selectedDrink">
      <p class="selected">선택한 음료: {{ selectedDrink.name }}</p>
      <DrinkOptions
        :selectedDrink="selectedDrink.name"
        @options-changed="updateOptions"
      />
      <div class="selected">
        <h3>현재 선택 옵션</h3>
        <p>
          사이즈: {{ selectedOptions.size }} <br />
          추가샷: {{ selectedOptions.extraShot ? '추가함' : '없음' }} <br />
          얼음 양: {{ selectedOptions.ice }}
        </p>
      </div>
      <OrderSummary
        :drink="selectedDrink"
        :optionData="selectedOptions"
        @place-order="onPlaceOrder"
      />
    </div>
    <OrderHistory :orders="orders" />
    <button
      v-if="orders.length > 0"
      @click="toggleStats"
      class="statisticsButton"
    >
      {{ showStats ? '숨기기' : '통계 보기' }}
    </button>
    <Statistics v-if="showStats" :orders="orders" />
  </main>
</template>

<script>
import MenuList from '@/components/MenuList.vue';
import DrinkOptions from '@/components/DrinkOptions.vue';
import OrderSummary from '@/components/OrderSummary.vue';
import OrderHistory from '@/components/OrderHistory.vue';
import Statistics from '@/components/Statistics.vue';

export default {
  name: 'App',
  components: {
    MenuList,
    DrinkOptions,
    OrderSummary,
    OrderHistory,
    Statistics,
  },
  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: undefined,
      selectedOptions: {
        size: 'Small',
        extraShot: false,
        ice: '보통',
      },
      orders: [],
      showStats: false,
    };
  },
  methods: {
    onSelectDrink(drink) {
      this.selectedDrink = drink;
    },
    updateOptions(options) {
      this.selectedOptions = options;
    },
    onPlaceOrder(timestamp) {
      this.orders.push({
        drink: this.selectedDrink,
        options: this.selectedOptions,
        timestamp,
      });

      this.selectedDrink = undefined;
      this.selectedOptions = {
        size: 'Small',
        extraShot: false,
        ice: '보통',
      };
    },
    toggleStats() {
      this.showStats = !this.showStats;
    },
  },
};
</script>
