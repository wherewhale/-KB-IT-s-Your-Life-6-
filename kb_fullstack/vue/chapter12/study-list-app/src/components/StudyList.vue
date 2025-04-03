<style scoped>
.grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;
}

.filter-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 2rem;
}
</style>

<template>
  <div>
    <div class="filter-container">
      <label>
        <input
          type="checkbox"
          :value="isRecruiting"
          @change="onChangeFilter(!isRecruiting)"
        />
        모집 중만 보기
      </label>
      <select :value="sorting" @change="onChangeSortValue($event)">
        <option value="due">마감일 임박순</option>
        <option value="created">최신 등록일순</option>
        <option value="likes">좋아요순</option>
      </select>
    </div>

    <ul class="grid">
      <StudyCard v-for="study in studies" :study="study" :key="study.id" />
    </ul>
  </div>
</template>

<script setup>
import { inject, computed } from 'vue';
import StudyCard from './StudyCard.vue';
const studies = inject('studies');
const isRecruiting = inject('isRecruiting');
const sorting = inject('sorting');
const onChangeFilter = inject('onChangeFilter');
const onChangeSort = inject('onChangeSort');

const onChangeSortValue = (event) => {
  console.log(event.target.value);
  onChangeSort(event.target.value);
};
</script>
