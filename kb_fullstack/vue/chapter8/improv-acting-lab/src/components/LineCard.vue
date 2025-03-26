<!-- inject RandomLineProvider에서 제공한 대사 배열(lines)을 inject로 가져옵니다.
대사 표시 currentLine 상태에 랜덤으로 대사를 저장해 화면에 표시합니다. (처음에는
'대사가 아직 없습니다.'로 시작) 버튼 클릭 버튼을 누르면 새로운 랜덤 대사가 카드
안에 나타나고, 콘솔에 출력됩니다. 기본 slot 카드 아래에 부모가 전달하는 기본
설명 멘트가 표시됩니다. named slot (tip) 카드 안의 tip-box에 부모가 전달하는
연기 팁을 표시할 수 있습니다. named slot (image) 이미지 박스에 부모가 전달하는
이미지가 삽입됩니다. scoped slot 대사의 길이(lineLength)를 부모에게 전달하여,
부모가 조건부로 안내 문구를 추가할 수 있습니다. (예: 30자 이상일 때 안내문 표시) -->

<style scoped>
.line {
  word-break: keep-all;
}

img {
  width: 400px;
  height: auto;
  border-radius: 12px;
  margin-top: 10px;
  object-fit: contain;
}

button {
  background-color: #5c88f6;
  color: white;
  border: 0;
  border-radius: 12px;
  padding: 10px 20px;
  cursor: pointer;
}

p {
  font-size: 18px;
  color: #333;
}

.sourceBox {
  font-size: 14px;
  color: #888;
  margin-top: 10px;
}

.lineCard {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  padding: 24px;
  max-width: 400px;
  margin: 24px auto;
}
</style>

<template>
  <div class="lineCard">
    <h2 class="line">"{{ currentLine }}"</h2>

    <button @click="handleClick">🎲 랜덤 대사 뽑기</button>
    <p class="source">출처 : {{ currentSource }}</p>
    <p>✨ 오늘의 즉흥 대사입니다.</p>

    <slot name="tip" class="tipBox"></slot>
    <img v-if="currentImgSrc !== ''" :src="currentImgSrc" alt="대사 이미지" />
    <slot name="length" :length="currentLine.length"></slot>
  </div>
</template>

<script>
export default {
  name: 'LineCard',
  inject: ['lines'],
  data() {
    return {
      currentLine: '🎭 아직 대사가 없습니다. 버튼을 눌러주세요.',
      currentImgSrc: '',
      currentSource: '',
    };
  },
  methods: {
    handleClick() {
      const randomIndex = Math.floor(Math.random() * this.lines.length);
      this.currentLine = this.lines[randomIndex].line;
      this.currentImgSrc = this.lines[randomIndex].imgSrc;
      this.currentSource = this.lines[randomIndex].source;
    },
  },
};
</script>
