<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
  padding: 24px;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  margin-top: 24px;
  background-color: white;
}
.text-alert {
  color: lightskyblue;
  font-size: 20px;
  font-weight: bold;
}
.feedbackForm {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
}
.submitButton {
  background-color: #5e8cff;
  color: white;
  border: 0;
  border-radius: 12px;
  padding: 10px 20px;
  cursor: pointer;
}
.textInput {
  height: 28px;
  border-radius: 12px;
  border: 1px solid #dfe4ea;
  padding: 0 12px;
}
.feedbackContainer {
  display: flex;
  flex-direction: column;
  gap: 12px;
  margin-top: 24px;
}
</style>

<template>
  <div class="container">
    <p class="text-alert">{{ feedbackGuideMessage }}</p>
    <h2>💬 오늘의 피드백 기록</h2>
    <div class="feedbackForm">
      <input
        class="textInput"
        type="text"
        :value="feedbackText"
        @input="$emit('update:feedbackText', $event.target.value)"
        placeholder="피드백을 입력하세요"
      />
      <!-- 부모 객체에 데이터를 실시간 전달할 때에는 update를 넣어주어야 한다. -->
      <button class="submitButton" @click="$emit('add-feedback')">추가</button>
    </div>
    <div class="feedbackContainer">
      <slot>등록된 피드백이 없습니다.</slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FeedbackForm',
  inject: ['feedbackGuideMessage'],
  emits: ['update:feedbackText', 'add-feedback'],
  props: {
    feedbackText: {
      type: String,
      default: '',
    },
  },
  data() {
    return {};
  },
};
</script>
