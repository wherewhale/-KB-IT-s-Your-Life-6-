import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const initState = {
  token: '', // 접근 토큰(JWT)
  user: {
    username: '', // 사용자 ID
    email: '', // Email
    roles: [], // 권한 목록
  },
};
export const useAuthStore = defineStore('auth', () => {
  const state = ref({ ...initState });
  const isLogin = computed(() => !!state.value.user.username);
  const username = computed(() => state.value.user.username);
  const email = computed(() => state.value.user.email); // 로그인 여부

  // 로그인 사용자 ID
  // 로그인 사용자 email
  const login = async (member) => {
    // state.value.token = 'test token';
    // state.value.user = {
    //   username: member.username,
    //   email: member.username + '@test.com',
    // };

    // api 호출
    const { data } = await axios.post('/api/auth/login', member);
    state.value = { ...data };
    localStorage.setItem('auth', JSON.stringify(state.value));
  };
  const logout = () => {
    localStorage.clear();
    state.value = { ...initState };
  };
  const getToken = () => state.value.token;
  const load = () => {
    const auth = localStorage.getItem('auth');
    if (auth != null) {
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  const changeProfile = (member) => {
    state.value.user.email = member.email;
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  load();
  //여기서 state를 그대로 내보내는 것은 비권장사항 -> 다른 곳에서 state를 직접 수정할 수 있기 때문
  return {
    state,
    username,
    email,
    isLogin,
    changeProfile,
    login,
    logout,
    getToken,
  };
});
