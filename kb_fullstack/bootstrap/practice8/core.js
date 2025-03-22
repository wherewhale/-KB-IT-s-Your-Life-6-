import { questions as allQuestions } from './questions.js';
// questions 외부값 추가

let vm = Vue.createApp({
  name: 'App',
  data() {
    return {
      questions: [], // 문제 + 정답 포함
      answers: [], // 사용자 제출 정답 리스트
      currentQuestionIndex: 0,
      score: 0, // 사용자 점수
      loading: true,
      feedbackLoading: false, // 문제 피드백 로딩 1초
      isAnswer: true,
      quizCompleted: false,
    };
  },
  methods: {
    fetchQuestions() {
      this.loading = true;

      setTimeout(() => {
        const randomQuestions = allQuestions.sort(() => Math.random() - 0.5).slice(0, 5);
        this.questions = randomQuestions;
        this.loading = false;
        // 데이터 패칭 로딩 시간 1초로 가정
      }, 1000);
    },
    checkAnswer(answer) {
      this.answers.push(answer);
      if (this.questions[this.currentQuestionIndex].answer === answer) {
        this.isAnswer = true;
        this.score++;
        this.feedbackLoading = true;
      } else {
        this.isAnswer = false;
        this.feedbackLoading = true;
      }
      setTimeout(() => {
        this.feedbackLoading = false;
        this.currentQuestionIndex++;
        if (this.currentQuestionIndex === 5) {
          this.quizCompleted = true;
        }
      }, 1000);
    },
  },
  mounted() {
    this.fetchQuestions();
  },
}).mount('#app');
