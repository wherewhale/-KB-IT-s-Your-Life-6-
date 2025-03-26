<!-- 부모 컴포넌트(App.vue)로부터 다음 두 가지 props를 전달받습니다:
drink: 음료 객체 (속성: name, price)
optionData: 옵션 정보 객체 (size, extraShot, ice)
화면 상단에 🧾 주문 내역서라는 제목을 표시합니다.
현재 시각(날짜와 시간)을 주문 시간 항목으로 표시합니다.
→ computed 속성을 활용해 currentTime으로 계산해서 사용하세요.
주문 요약에는 다음 항목을 표기합니다:
음료 이름
사이즈
추가샷 여부 (추가함 또는 없음)
얼음 양
결제 금액: drink.price 값을 사용하여 표기하며, 금액은 toLocaleString()을 사용해서 천 단위 구분 쉼표를 포함하세요.
가장 하단에 "주문 확정하기" 버튼을 배치하고, 버튼 클릭 시 place-order 이벤트를 emit 하세요.
컴포넌트 디자인은 영수증 느낌의 카드 형태로,
배경은 연한 베이지색(#FFFAF0), 테두리는 #D2B48C 색상을 사용합니다.
hr 요소는 점선(dashed)으로 표현합니다. -->

<style>
.orderContainer {
  background-color: #fffaf0;
  border: 1px solid #d2b48c;
  padding: 20px;
  border-radius: 10px;
  margin-top: 20px;
}
hr {
  border: 0;
  border-top: 1px dashed #808080;
  margin: 20px 0;
}

.orderButton {
  padding: 10px 20px;
  background-color: burlywood;
  color: #fff;
  border-radius: 4px;
  border: 0px;
  cursor: pointer;
}
</style>

<template>
  <div class="orderContainer">
    <h2>주문 내역서</h2>
    <p>주문 시간: {{ currentTime }}</p>
    <hr />
    <p>음료: {{ drink.name }}</p>
    <p>사이즈: {{ optionData.size }}</p>
    <p>추가 샷: {{ optionData.extraShot ? '추가' : '없음' }}</p>
    <p>얼음 양: {{ optionData.ice }}</p>
    <hr />
    <p>결제 금액: {{ drink.price.toLocaleString() }}원</p>
    <button class="orderButton" @click="$emit('place-order', currentTime)">
      주문 확정하기
    </button>
  </div>
</template>

<script>
export default {
  name: 'OrderSummary',
  props: {
    drink: {
      type: Object,
      required: true,
    },
    optionData: {
      type: Object,
      required: true,
    },
  },
  emits: ['place-order'],
  data() {
    return {};
  },
  computed: {
    currentTime() {
      return new Date().toLocaleString();
    },
  },
};
</script>
