<style scoped>
main {
  background: rgb(194, 255, 245);
  background: linear-gradient(
    90deg,
    rgba(194, 206, 247, 1) 0%,
    rgba(205, 216, 235, 1) 38%,
    rgba(215, 216, 215, 1) 63%
  );
  min-height: 100vh;
}
</style>

<template>
  <main
    class="d-flex flex-column align-items-center gap-4 justify-content-center"
  >
    <div class="container p-4 text-center">
      <h1 class="text-white fw-bold">❤️ 나만의 MBTI 궁합 저장소</h1>
      <RouterView />
    </div>
  </main>
</template>

<script setup></script>
