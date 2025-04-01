<script setup>
import { defineAsyncComponent } from 'vue'

const TheWelcome = defineAsyncComponent(() => import('../components/TheWelcome.vue'))
//View Component lazy loading
</script>

<template>
  <main>
    <TheWelcome />
  </main>
</template>
