<style scoped>
h1 {
  margin-bottom: 2rem;
}
</style>

<template>
  <main>
    <router-link to="/studies/add" class="btn btn-primary mb-3">
      ➕ 스터디 등록
    </router-link>
    <h1>📚 스터디 목록</h1>
    <StudyList />
  </main>
</template>

<script setup>
import StudyList from '@/components/StudyList.vue';
</script>
