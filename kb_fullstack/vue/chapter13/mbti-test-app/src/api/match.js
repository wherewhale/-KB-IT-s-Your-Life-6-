import { instance } from './common';

// TODO: api 요청은 아래와 같은 형식을 따라주세요.
export const getMatchResult = async (myMBTI, friendMBTI) => {
  try {
    const response = await instance.get(
      `/matches?myMBTI=${myMBTI}&friendMBTI=${friendMBTI}`
    );
    // 데이터 정제가 필요한 경우 여기서 정제
    return response.data;
  } catch (e) {
    // 인터셉터에서 처리한 에러 외의 로깅 수행
    console.log('getStudyList 요청 실패', e);
  }
};

export const postMatchResult = async (result) => {
  console.log(result);
  try {
    const response = await instance.post('/savedResults', { ...result });

    return response.data;
  } catch (e) {
    // 인터셉터에서 처리한 에러 외의 로깅 수행
    console.log('postMatchResult 요청 실패', e);
  }
};

export const getMatchResultList = async () => {
  try {
    const response = await instance.get('/savedResults');
    return response.data;
  } catch (e) {
    // 인터셉터에서 처리한 에러 외의 로깅 수행
    console.log('getMatchResultList 요청 실패', e);
  }
};

export const deleteMatchResult = async (id) => {
  try {
    const response = await instance.delete(`/savedResults/${id}`);
    return response.data;
  } catch (e) {
    // 인터셉터에서 처리한 에러 외의 로깅 수행
    console.log('deleteMatchResult 요청 실패', e);
  }
};
