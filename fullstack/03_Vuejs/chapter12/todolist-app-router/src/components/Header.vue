<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <span class="navbar-brand ps-2">TodoList App</span>
    <button
      class="navbar-toggler"
      type="button"
      @click="isNavShow = !isNavShow"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div
      :class="
        isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
      "
    >
      <ul class="navbar-nav">
        <!-- 메뉴 항목으로, a태그 대신 router-link 사용 -->
        <!-- 현재 메뉴는 양식이 거의 비슷한 것을 볼 수 있음, 이를 일반화 하여 로직 처리하는 것이 유지보수에 유리하다. -->
        <!-- /config/index.js 등에 const MENUS로 저장해서 v-for로 활용 -->
        <li class="nav-item">
          <!-- path는 to 이후에 작성하며, 동적 데이터를 이용하는 경우에는 :to로 바인딩에서 활용 -->

          <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">About</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/todos">TodoList</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script setup>
import { ref } from 'vue';
const isNavShow = ref(false);
</script>
