<script setup>
import { computed, defineProps } from 'vue'

const props = defineProps({
  variant: {
    type: String,
    default: 'primary',
  },
})

const alertClass = computed(() => {
  return {
    'alert-success': props.variant === 'success',
    'alert-warning': props.variant === 'warning',
    'alert-error': props.variant === 'error',
  }
})
</script>

<template>
  <button :class="alertClass">
    <slot>Button</slot>
  </button>
</template>

<style scoped>
/* 알림창 */
.alert-success {
  background-color: #dbecb6;
  color: #15803d;
  border-left: 4px solid #22c55e;
  padding: 0.75rem;
  margin-bottom: 0.5rem;
}

.alert-warning {
  background-color: #fef3c7;
  color: #92400e;
  border-left: 4px solid #facc15;
  padding: 0.75rem;
  margin-bottom: 0.5rem;
}

.alert-error {
  background-color: #fee2e2;
  color: #b91c1c;
  border-left: 4px solid red;
  padding: 0.75rem;
  margin-bottom: 0.5rem;
}
</style>
