<!-- buttons 배열 props로 전달받아 버튼을 동적으로 렌더링
active prop을 통해 현재 선택된 버튼 id를 전달받아 해당 버튼 스타일 강조
각 버튼 클릭 시 $emit('button-clicked', button.id) 이벤트 전달
scoped slot으로 버튼 안의 표시 내용을 부모(App.vue)에서 커스터마이징 가능
선택된 버튼에 active 클래스 적용, 파란색 배경과 그림자 효과 적용 -->

<style scoped>
.container {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 30px;
}

button {
  background-color: #74b9ff;
  padding: 10px 20px;
  border-radius: 10px;
  border: 0;
  cursor: pointer;
  color: white;
}
button:hover {
  background-color: #0984e3;
}

.buttonActive {
  background-color: #0984e3;
  box-shadow: 0 5px 15px rgba(9, 132, 227, 0.2);
}
</style>

<template>
  <div class="container">
    <button
      :class="{ buttonActive: btn.id === active }"
      :key="btn.id"
      v-for="btn in buttonList"
      @click="handleClick(btn)"
    >
      {{ btn.defaultLabel }}
    </button>
  </div>
</template>

<script>
export default {
  name: 'ButtonBar',
  props: {
    buttonList: {
      type: Array,
      required: true,
    },
    active: {
      type: String,
      default: null,
    },
  },
  methods: {
    handleClick(button) {
      this.$emit('button-clicked', button.id);
    },
  },
};
</script>
