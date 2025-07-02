<script setup>
import Header from './Header.vue';
import NavBar from './NavBar.vue';
// import Footer from './Footer.vue';
</script>

<template>
  <div class="container">
    <Header></Header>
    <NavBar />
    <div class="content my-5 px-3">
      <slot></slot>
    </div>
    <!-- <Footer></Footer> -->
  </div>
</template>
<style scoped></style>
