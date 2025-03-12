// fetch 함수는 Promise를 반환
fetch('https://jsonplaceholder.typicode.com/users')
  //받아온 객체를 json 형태로 변환
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((err) => console.log(err));
