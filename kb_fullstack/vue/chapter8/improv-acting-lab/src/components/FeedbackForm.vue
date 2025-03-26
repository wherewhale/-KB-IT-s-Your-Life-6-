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
.feedbackBox {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 12px;
  padding: 0 12px;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  background-color: white;
}
.buttonDelete {
  background-color: #ff4757;
  color: white;
}
</style>

<template>
  <div class="container">
    <p class="text-alert">📢 피드백은 솔직하게 작성해주세요!</p>
    <h2>💬 오늘의 피드백 기록</h2>
    <form class="feedbackForm" @submit.prevent="submitFeedback">
      >
      <input
        class="textInput"
        type="text"
        v-model="feedbackText"
        placeholder="피드백을 입력하세요"
      />
      <button type="submit" class="submitButton">추가</button>
    </form>
    <div>
      <div
        class="feedbackBox"
        v-for="(feedback, idx) in feedbackGuideMessage"
        :key="feedback[0] + idx"
      >
        <p>
          {{ feedback }}
        </p>
        <button class="buttonDelete" @click="deleteFeedback(idx)">삭제</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FeedbackForm',
  inject: ['feedbackGuideMessage'],
  data() {
    return {
      feedbackText: this.feedback,
    };
  },
  methods: {
    submitFeedback() {
      // Handle the feedback submission logic here
      console.log('Feedback submitted:', this.feedbackText);
      this.feedbackGuideMessage.push(this.feedbackText);
      this.feedbackText = ''; // Clear the input field after submission
    },
    deleteFeedback(index) {
      console.log(index);
      this.feedbackGuideMessage.splice(index, 1);
    },
  },
};
</script>
