<template>
  <h1>✅ 스터디 신청</h1>
  <form class="mt-4" @submit.prevent="onSubmit">
    <label class="w-100">
      이름
      <input type="text" class="w-100 form-control" placeholder="이름을 입력하세요" v-model="name" />
    </label>
    <label class="w-100 mt-2">
      연락처
      <input type="text" class="form-control" placeholder="010-0000-0000" v-model="phone" />
    </label>
    <div class="d-flex gap-2 mt-4">
      <button type="submit" class="btn btn-success">신청하기</button>
      <router-link class="btn btn-outline-secondary" :to="{ name: 'studyDetail', params: { id: studyId } }"
        >돌아가기</router-link
      >
    </div>
  </form>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { postStudyApply } from '@/api/study';

const route = useRoute();
const router = useRouter();
const studyId = route.params.id;
const name = ref('');
const phone = ref('');

const validatePhone = (phone) => {
  const phoneRegex = /^\d{3}-\d{4}-\d{4}$/;
  return phoneRegex.test(phone);
};
const validateName = (name) => {
  return name.length > 0;
};

const onSubmit = async () => {
  if (!validateName(name.value)) {
    alert('이름을 입력하세요.');
    return;
  }
  if (!validatePhone(phone.value)) {
    alert('전화번호 형식이 올바르지 않습니다.');
    return;
  }

  try {
    await postStudyApply({ studyId, name: name.value, contact: phone.value });
    alert('신청이 완료되었습니다.');
    router.push({ name: 'studyDetail', params: { id: studyId } });
  } catch (error) {
    console.error(error);
    alert('신청에 실패했습니다.');
  }
};
</script>
