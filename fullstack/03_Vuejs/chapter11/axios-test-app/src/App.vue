<template>
  <div><h2>콘솔을 확인합니다.</h2></div>
</template>

<script setup>
import axios from 'axios'
const requestAPI = () => {
  const url = 'http://localhost:3000/todos/1'
  // 비동기 호출로 promise가 리턴된다. 이를 then으로 처리한 것
  // 에러 처리는 catch로 실행
  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response)
  })
}
requestAPI()

//전체 목록을 조회한 후 한 건씩 순차적으로 순회하며 조회하기
// const requestAPI = async () => {
//   let todoList

//   let response = await axios.get(listUrl) // 목록 얻기
//   todoList = response.data
//   console.log('# TodoList : ', todoList)
//   for (let i = 0; i < todoList.length; i++) {
//     response = await axios.get(todoUrlPrefix + todoList[i].id) // 상세 내용을 가져옴
//     console.log(`# ${i + 1}번째 Todo : `, response.data) //response.data를 반환하면 const {data} = ... 형태로 사용 가능
//   }
// }
// requestAPI()

// const requestAPI = async () => {
//   const url = '/api/todos'
//   let data = { todo: '윗몸일으키기 3세트', desc: '너무 빠르지 않게...' }
//   const resp1 = await axios.post(url, data)
//   console.log(resp1.data)
// }
// requestAPI()

// const requestAPI = async () => {
//   const url = '/api/todos'
//   try {
//     const response = await axios.get(url, { timeout: 900 })
//     console.log('# 응답객체 : ', response)
//   } catch (e) {
//     console.log('## 다음 오류가 발생했습니다.')
//     if (e instanceof Error) console.log(e.message)
//     else console.log(e)
//   }
// }
</script>
