<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
    <span class="navbar-brand">이날치(LeeNalChi)</span>
    <button class="navbar-toggler" type="button" @click="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>
    <!-- 여기도 MenuGroup 등으로 컴포넌트화가 가능하다. -->
    <div :class="navClass">
      <ul class="navbar-nav">
        <!-- 여기도 MenuItem 이라고 컴포넌트화가 가능하다. -->
        <li class="nav-item">
          <router-link class="nav-link" to="/">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">소개</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/members">멤버</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/videos">영상</router-link>
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
</script>
