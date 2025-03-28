<style scoped></style>

<template>
  <header>
    <TitleBanner
      :title="'Fake Store'"
      :subtitle="'Vue3 연습 사이트'"
    ></TitleBanner>
    <NavigationBar></NavigationBar>
  </header>

  <main class="container">
    <RouterView />
  </main>
  <footer class="text-center">
    <p>Copyright &copy; KB FULLSTACK</p>
    <p>All rights reserved</p>
  </footer>
</template>

<script setup>
import { RouterView } from 'vue-router';
import TitleBanner from './components/TitleBanner.vue';
import NavigationBar from './components/NavigationBar.vue';
</script>
