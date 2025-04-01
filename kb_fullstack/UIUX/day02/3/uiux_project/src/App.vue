<script setup>
import CommonHeader from './components/CommonHeader.vue'
import BaseButton from './components/BaseButton.vue'
import BaseAlert from './components/BaseAlert.vue'
</script>

<template>
  <CommonHeader />
  <main class="component-grid">
    <section class="component-card">
      <h2>버튼</h2>
      <BaseButton variant="primary">Primary</BaseButton>
      <BaseButton variant="outline">Outline</BaseButton>
      <BaseButton variant="pill">Pill</BaseButton>
    </section>
    <section class="component-card">
      <h2>알림창</h2>
      <BaseAlert variant="success">Success</BaseAlert>
      <BaseAlert variant="warning">Warning</BaseAlert>
      <BaseAlert variant="error">Error</BaseAlert>
    </section>
  </main>
</template>

<style scoped>
img {
  width: 100%;
}
</style>
