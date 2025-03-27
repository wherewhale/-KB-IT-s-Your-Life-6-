<!-- slot으로 전달된 멘트는 연한 회색 카드 스타일로 표시하고, 카드 스타일은 아래와 같습니다:
배경색: #F1F2F6
테두리: 1px solid #DFE4EA
둥근 모서리, padding 14px, 최대 너비 400px
:흰색_확인_표시: 구현 결과 화면 예시
   요소 기능     버튼 클릭 시 콘솔에 메시지 출력 + 화면에 클릭 횟수 표시   클릭 횟수 표시 버튼을 누른 횟수: n회 로 실시간 업데이트   slot 카드 박스 부모 컴포넌트에서 전달한 응원 멘트 표시, 카드 스타일 적용
:흰색_확인_표시: 부모 컴포넌트(App.vue) 요구사항
LineReadyButton 컴포넌트를 가져와 사용하세요.
@ready 이벤트를 받아 콘솔에 메시지를 출력하도록 handleReady 메서드를 작성하세요.
slot으로 "오늘도 넌 멋질 거야! :마이크: 자신 있게 무대에 올라가!" 와 같은 응원 멘트를 전달하세요. -->

<style>
body {
  background: linear-gradient(135deg, #f1f2f6, #dfe4ea);
}
.container {
  max-width: 800px;
  margin: 0 auto;
  text-align: center;
}
.slotCard {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  padding: 14px;
  max-width: 400px;
}
.tipCard {
  padding: 10px;
  background-color: #d9f6f9;
  border-radius: 12px;
  display: flex;
  justify-content: center;
}
.warningText {
  color: #888;
  font-size: 18px;
  margin-top: 10px;
}
.quizButton {
  background-color: orange;
  color: white;
  border-radius: 12px;
  cursor: pointer;
  padding: 10px 20px;
  font-size: large;
  border: 0;
  margin-top: 20px;
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
    <h1>Improv-Acting-Lab 🎭</h1>
    <ButtonBar
      :buttonList="buttonList"
      :active="activeId"
      @button-clicked="handleActive"
    ></ButtonBar>
    <!-- <LineReadyButton @ready="handleReady">
      <div class="slotCard">가서 찢어버려. Siuuuuuu~</div>
    </LineReadyButton> -->
    <LineCard v-if="activeId === '1'">
      <template v-slot:tip>
        <div class="tipCard">🎯 연기 팁: 대사를 숨쉬듯이 내뱉으세요!</div>
      </template>
      <template v-slot:length="length">
        <p class="warningText" v-if="length.length >= 40">
          대사가 길어요! 천천히 연기해보세요!
        </p>
      </template>
    </LineCard>
    <!-- <button class="quizButton" @click="handleQuizReady">
      📝 퀴즈 시작하기
    </button> -->
    <QuizCard v-if="activeId === '2'">
      <template #title>
        <h2>📝 즉흥 대사 출처 퀴즈</h2>
        <h3>Q. 이 대사는 어디에서 나온 걸까요?</h3>
      </template>
      <template #hint>
        <p>힌트: 모두 유명 드라마 속 대사에요!</p>
      </template>
      <template #correct>
        <p>정답입니다! 🎉</p>
      </template>
      <template #wrong></template>
    </QuizCard>

    <!-- TODO: v-model, event 수신해서 값을 바꾸는 형식으로 수정해야 함 -->
    <FeedbackForm
      v-if="activeId === '3'"
      v-model:feedbackText="feedbackText"
      @add-feedback="addFeedback"
    >
      <div
        class="feedbackBox"
        v-for="(feedback, idx) in feedbackList"
        :key="feedback[0] + idx"
      >
        <p>
          {{ feedback }}
        </p>
        <button class="buttonDelete" @click="deleteFeedback(idx)">삭제</button>
      </div>
    </FeedbackForm>
  </div>
</template>

<script>
// import LineReadyButton from './components/LineReadyButton.vue';
import LineCard from './components/LineCard.vue';
import QuizCard from './components/QuizCard.vue';
import ButtonBar from './components/ButtonBar.vue';
import FeedbackForm from './components/FeedbackForm.vue';

export default {
  name: 'App',
  components: {
    // LineReadyButton,
    LineCard,
    QuizCard,
    ButtonBar,
    FeedbackForm,
  },

  provide() {
    return {
      lines: [
        {
          line: '조금은 친절해도 되잖아. 다들 니들처럼 익숙한 게 아니니까.',
          source: '청춘시대',
          imgSrc: 'https://fs.jtbc.co.kr/prog/img/mig/TITLE/PR10010422.jpg',
        },
        {
          line: '너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다.',
          source: '도깨비',
          imgSrc:
            'https://www.chosun.com/resizer/v2/QXJOA4UE56AN5ZEOSZ7HGB5DWY.jpg?auth=eb54c39137830bf544cb83b0b1d0ba3c018d5fba479033ba5ddf7df9200269d4&width=464',
        },
        {
          line: '당신이 좋은 이유? 그저 그 사람이라서. 바로 너라서.',
          source: '응답하라 1997',
          imgSrc:
            'https://m.media-amazon.com/images/S/pv-target-images/fb5c286fa49dd8ca05c79b8ffb3c47cf5cde0b3cbb8bb8da13ac903ab457725a.jpg',
        },
        {
          line: '잊지 말자. 나는 어머니의 자부심이다. 모자라고 부족한 자식이 아니다.',
          source: '미생',
          imgSrc:
            'https://cdn.lecturernews.com/news/photo/202111/81282_287409_3646.png',
        },
      ],
      feedbackGuideMessage: '📢 피드백은 솔직하게 작성해주세요!',
    };
  },
  data() {
    return {
      isReady: false,
      isQuiz: false,
      activeId: null,
      buttonList: [
        { id: '1', defaultLabel: '🎲 랜덤 대사 뽑기' },
        { id: '2', defaultLabel: '📝 퀴즈 시작' },
        { id: '3', defaultLabel: '💬 피드백 작성' },
      ],
      feedbackList: [
        '너무 잘했어요!',
        '조금 더 자신감을 가져보세요!',
        '대사가 길어요! 천천히 연기해보세요!',
      ],
      feedbackText: '',
    };
  },
  methods: {
    handleReady(message) {
      this.isReady = true;
      console.log(message);
    },
    handleQuizReady() {
      this.isQuiz = true;
    },
    handleActive(buttonId) {
      if (this.activeId === buttonId) {
        this.activeId = null; // 클릭한 버튼이 이미 활성화된 경우 비활성화
      } else {
        this.activeId = buttonId;
      }
    },
    deleteFeedback(index) {
      console.log(index);
      this.feedbackList.splice(index, 1);
    },
    addFeedback() {
      if (this.feedbackText.trim().length > 2) {
        this.feedbackList.push(this.feedbackText);
        this.feedbackText = ''; // 입력 필드 초기화
      }
    },
  },
};
</script>
