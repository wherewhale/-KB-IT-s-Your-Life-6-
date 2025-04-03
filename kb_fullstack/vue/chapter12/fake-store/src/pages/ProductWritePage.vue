<template>
  <main>
    <h2 class="fs-2 d-flex my-5 align-items-center gap-2">상품 등록</h2>
    <p>카테고리 :</p>
    <p>{{ route.query.category }}</p>
    <p>상품명 * :</p>
    <input type="text" v-model="title" />
    <p>이미지 경로 :</p>
    <input type="text" v-model="srcUrl" />
    <p>설명 :</p>
    <textarea type="text" v-model="description"></textarea>
    <div class="d-flex justify-content-center gap-2">
      <router-link class="btn btn-primary" :class="{ disabled: isChecked }"
        >확인</router-link
      >
      <router-link class="btn btn-primary">취소</router-link>
    </div>
  </main>
</template>

<script setup>
import { computed, ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();

const isChecked = computed(() => (title.value.length > 4 ? false : true));

const title = ref('');
const srcUrl = ref(null);
const description = ref(null);
</script>
