<!-- 버튼을 화면에 표시하고, 클릭할 때마다 다음을 수행하세요:
부모 컴포넌트에 ready라는 이름의 이벤트를 emit으로 전달
전달하는 메시지: 대사 준비 완료! (총 n회 눌림) (n = 클릭 횟수)
버튼 클릭 횟수를 화면에 버튼을 누른 횟수: n회 형식으로 표시
버튼 아래에는 slot을 사용해서 부모 컴포넌트가 작성하는 응원 멘트를 표시하세요.
slot 내용이 없으면 여기에 서윤이의 코멘트가 들어갑니다. 라는 기본 텍스트가 표시되도록 합니다.
버튼 디자인 요구:
배경색: #FF7675 (연분홍), 글자색: 흰색
마우스 오버 시 진한 분홍(#D63031)으로 변경
둥근 모서리 (border-radius: 12px)
가운데 정렬
slot으로 전달된 멘트는 연한 회색 카드 스타일로 표시하고, 카드 스타일은 아래와 같습니다:
배경색: #F1F2F6
테두리: 1px solid #DFE4EA
둥근 모서리, padding 14px, 최대 너비 400px -->

<style scoped>
button {
  background-color: #ff7675;
  color: white;
  border-radius: 12px;
  cursor: pointer;
  padding: 10px 20px;
  font-size: large;
  border: 0;
}

button:hover {
  background-color: #d63031;
}
.buttonContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
}
</style>

<template>
  <div class="buttonContainer">
    <button @click="handleClick" class="readyButton">🎥 대사 준비 완료!</button>
    <p>
      버튼을 누른 횟수 : <span>{{ clickCount }}회</span>
    </p>
    <slot class="slotCard">여기에 서윤이의 코멘트가 들어갑니다.</slot>
  </div>
</template>

<script>
export default {
  name: 'LineReadyButton',
  emits: ['ready'],
  data() {
    return {
      clickCount: 0,
    };
  },
  methods: {
    handleClick() {
      this.clickCount++;
      this.$emit('ready', `대사 준비 완료! (총 ${this.clickCount}회 눌림)`);
    },
  },
};
</script>
