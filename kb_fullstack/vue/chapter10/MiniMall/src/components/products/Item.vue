<style scoped>
p {
  margin: 0;
}
.item {
  border: 1px solid gray;
  border-radius: 8px;
  padding: 20px 10px;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
}
.image-container {
  width: 180px;
  height: 180px;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
}
img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.detail-link {
  text-decoration: none;
  color: mediumaquamarine;
  margin-top: 8px;
}
</style>

<template>
  <li class="item">
    <div class="image-container">
      <img :src="item.image" alt="상품 이미지" />
    </div>
    <p>{{ item.name }}</p>
    <p>{{ item.price.toLocaleString() }}원</p>
    <RouterLink
      class="detail-link"
      :to="{ name: 'products/id', params: { id: item.id } }"
    >
      상세보기
    </RouterLink>
  </li>
</template>

<script setup>
import { RouterLink, useRouter } from 'vue-router';

const router = useRouter();

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
});

const goToProductDetail = () => {
  router.push({
    name: 'products/id',
    params: {
      id: props.item.id,
    },
    state: {
      productBasicInfo: {
        id: props.item.id,
        name: props.item.name,
        price: props.item.price,
        src: props.item.src,
      },
    },
  });
};
</script>
