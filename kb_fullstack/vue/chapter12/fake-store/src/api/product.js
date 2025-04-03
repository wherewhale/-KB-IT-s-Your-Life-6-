import axios from 'axios';

export const instance = axios.create({
  baseURL: '/api',
  timeout: 5000,
});

export const getProductList = async (target, params) => {
  try {
    const response = await instance.get(`/products/category/${target}`);
    return response.data;
  } catch (e) {
    console.log('getProductList 요청 실패', e);
  }
};

export const getProductDetail = async (id) => {
  try {
    const response = await instance.get(`/products/${id}`);
    return response.data;
  } catch (e) {
    console.log('getProductDetail 요청 실패', e);
  }
};

export const post = async (target, product) => {};
export const put = async (target, product) => {};
export const remove = async (target, params) => {};
