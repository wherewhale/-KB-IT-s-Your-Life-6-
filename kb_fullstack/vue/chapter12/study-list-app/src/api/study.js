import { instance } from './common';

// TODO: api 요청은 아래와 같은 형식을 따라주세요.
export const getStudyList = async (sorting) => {
  // ?_sort=id,-views
  let query = '';
  if (sorting === 'likes') {
    query = '?_sort=-likes';
  }

  try {
    const response = await instance.get('/studies' + query || '');
    // 데이터 정제가 필요한 경우 여기서 정제
    return response.data;
  } catch (e) {
    // 인터셉터에서 처리한 에러 외의 로깅 수행
    console.log('getStudyList 요청 실패', e);
  }
};

export const getStudyDetail = async (id) => {
  try {
    const response = await instance.get(`/studies/${id}`);
    return response.data;
  } catch (e) {
    console.log('getStudyDetail 요청 실패', e);
  }
};

export const postStudy = async (data) => {
  try {
    const response = await instance.post('/studies', data);
    return response.data;
  } catch (e) {
    console.log('postStudy 요청 실패', e);
  }
};
