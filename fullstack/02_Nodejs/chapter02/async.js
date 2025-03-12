// await를 사용하는 함수에는 async를 붙인다.

async function init() {
  try {
    // Promoise 객체를 반환하는 함수에는 await를 붙인다.
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    const users = response.json();
    console.log(users);
  } catch (err) {
    console.error(err);
  }
}

init();
