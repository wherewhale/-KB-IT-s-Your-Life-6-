<style>
.quizContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
  padding: 24px;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  margin-top: 24px;
}
.buttonContainer {
  display: flex;
  align-items: center;
  gap: 12px;
}

button {
  border: 0;
  border-radius: 12px;
  color: white;
  padding: 10px 20px;
  cursor: pointer;
}

.selectButton {
  background-color: #5e8cff;
}

.nextButton {
  background-color: #24a34e;
}

.lineText {
  font-size: 24px;
  color: #333;
  word-break: keep-all;
}
</style>

<template>
  <div class="quizContainer">
    <slot name="title"></slot>
    <p class="lineText">{{ lines[selectedIndex].line }}</p>
    <slot name="hint"></slot>
    <slot v-if="isCorrect" name="correct"></slot>
    <slot v-if="isCorrect === false" name="wrong">
      아쉽네요! 정답은 {{ lines[selectedIndex].source }}입니다.
    </slot>
    <div v-if="!isSelected" class="buttonContainer">
      <button
        class="selectButton"
        v-for="(line, idx) in lines"
        :key="line.source"
        @click="handleSelect(idx)"
      >
        {{ line.source }}
      </button>
    </div>
    <div v-else>
      <p>
        당신의 선택: {{ selectedSource }}<br />
        결과: {{ isCorrect ? '정답!' : '오답' }}
      </p>
      <button class="nextButton" @click="getNewQuiz">다음 문제 풀기 ➡️</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'QuizCard',
  inject: ['lines'],
  data() {
    return {
      selectedIndex: 1,
      isCorrect: null,
      isSelected: false,
    };
  },
  methods: {
    getNewQuiz() {
      const randomIndex = Math.floor(Math.random() * this.lines.length);
      this.selectedIndex = randomIndex;
      this.isSelected = false;
      this.isCorrect = null;
    },
    handleSelect(index) {
      this.isSelected = true;
      if (this.selectedIndex === index) {
        this.isCorrect = true;
      } else {
        this.isCorrect = false;
      }
    },
  },
};
</script>
