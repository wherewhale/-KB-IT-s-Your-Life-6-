<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark px-2">
    <span class="navbar-brand d-flex align-items-center gap-2"
      ><i class="fa-solid fa-house"></i>Fake Store</span
    >
    <button class="navbar-toggler" type="button" @click="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>
    <!-- 여기도 MenuGroup 등으로 컴포넌트화가 가능하다. -->
    <div :class="navClass">
      <ul class="navbar-nav">
        <!-- 여기도 MenuItem 이라고 컴포넌트화가 가능하다. -->
        <li class="nav-item" v-for="menu in MENUS" :key="menu.name">
          <router-link
            class="nav-link d-flex align-items-center"
            :to="menu.path"
            ><i class="nav-link fa-solid" :class="menu.icon"></i
            >{{ menu.name }}</router-link
          >
        </li>
      </ul>
    </div>
  </nav>
</template>

<script setup>
import { reactive, computed } from 'vue';
const state = reactive({ isNavShow: false });
// computed 함수를 사용하여 클래스 바인딩을 한다.
const navClass = computed(() =>
  state.isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
);
const changeIsNavShow = () => {
  state.isNavShow = !state.isNavShow;
};

const MENUS = [
  { name: '가전', icon: 'fa-question', path: '/electronics' },
  { name: '주얼리', icon: 'fa-gem', path: '/jewelery' },
  { name: '남성의류', icon: 'fa-user', path: '/mensclothing' },
  { name: '여성의류', icon: 'fa-bell', path: '/womensclothing' },
];
</script>
