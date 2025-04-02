import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:3000',
  timeout: 2500,
});

export const getMovieList = async () => {
  try {
    const response = await instance.get('/movies');
    return response.data;
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

export const getMovieDetail = async (id) => {
  try {
    const response = await instance.get(`/movies/${id}`);

    return {
      ...response.data,
      poster: response.data.poster.replace(/^<|>$/g, ''), // 이미지 URL 정리
    };
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

export const postMovie = async (input) => {
  console.log(input);
  try {
    await instance.post(`/movies`, {
      title: input.title,
      year: input.year,
      director: input.director,
      description: input.description,
      poster: input.poster,
    });
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};
