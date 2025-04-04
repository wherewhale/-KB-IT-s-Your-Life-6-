import axios from 'axios';

export const instance = axios.create({
  baseURL: '/api',
  timeout: 5000,
});

// response 확인을 통해 에러 코드에 따른 처리
instance.interceptors.response.use(
  (response) => {
    // 정상 응답일 경우 그대로 반환
    return response;
  },
  (error) => {
    // 에러 응답을 처리하는 로직
    if (error.response) {
      const { status, data } = error.response;

      console.error(
        `❌ [HTTP ${status}] 요청 실패:`,
        data?.message || '알 수 없는 오류'
      );

      switch (status) {
        case 400:
          alert('잘못된 요청입니다.');
          break;
        case 401:
          alert('인증이 필요합니다. 로그인 후 다시 시도해주세요.');
          break;
        case 403:
          alert('접근 권한이 없습니다.');
          break;
        case 404:
          alert('요청한 데이터를 찾을 수 없습니다.');
          break;
        case 500:
          alert('서버 내부 오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
          break;
        default:
          alert('예상치 못한 오류가 발생했습니다.');
      }
    } else {
      console.error('🚨 네트워크 오류:', error.message);
      alert('네트워크 연결을 확인해주세요.');
    }

    // 에러를 던져서 각 API 함수에서도 추가 처리가 가능하도록 함
    return Promise.reject(error);
  }
);
