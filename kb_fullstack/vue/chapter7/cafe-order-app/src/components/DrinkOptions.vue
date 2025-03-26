<!-- DrinkOptions.vue
부모로부터 selectedDrink props(문자열)를 전달받습니다.
화면 상단에 {{ selectedDrink }} 옵션 선택 이라는 제목을 표시하세요.
세 가지 옵션 입력 UI를 만드세요:
사이즈 (라디오 버튼):Small, Medium, Large
기본 선택은 Medium
추가 샷 (체크박스):"샷 추가"
얼음 양 (셀렉트 박스):적게, 보통, 많이
기본 선택은 보통
옵션이 바뀔 때마다 객체 형태로 옵션 정보를 options-changed 이벤트로 emit 하세요.
{
  size: 'Medium',
  extraShot: true,
  ice: '적게'
} -->

<style>
.optionContainer {
  padding: 20px;
  border: 1px solid #ccc;
  background-color: lightblue;
}
.colFlex {
  display: flex;
  flex-direction: column;
  gap: 20px;
}
</style>

<template>
  <div class="optionContainer">
    <h2>{{ selectedDrink }} 옵션 선택</h2>
    <div class="colFlex">
      <div>
        <p>사이즈:</p>
        <label>
          <input
            type="radio"
            id="small"
            value="Small"
            v-model="options.size"
            @change="updateOptions"
          />
          <span>Small</span>
        </label>
        <label>
          <input
            type="radio"
            id="medium"
            value="Medium"
            v-model="options.size"
            @change="updateOptions"
          />
          <span>Medium</span>
        </label>
        <label>
          <input
            type="radio"
            id="large"
            value="Large"
            v-model="options.size"
            @change="updateOptions"
          />
          <span>Large</span>
        </label>
      </div>
      <div>
        <label>
          <input
            type="checkbox"
            id="extraShot"
            v-model="options.extraShot"
            @change="updateOptions"
          />
          <span>샷 추가</span>
        </label>
      </div>
      <div>
        <label>
          얼음 양:
          <select v-model="options.ice" @change="updateOptions">
            <option value="적게">적게</option>
            <option value="보통">보통</option>
            <option value="많이">많이</option>
          </select>
        </label>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: {
    selectedDrink: String,
  },
  emits: ['options-changed'],
  data() {
    return {
      options: {
        size: 'Medium',
        extraShot: false,
        ice: '보통',
      },
    };
  },
  methods: {
    updateOptions() {
      this.$emit('options-changed', this.options);
    },
  },
};
</script>
