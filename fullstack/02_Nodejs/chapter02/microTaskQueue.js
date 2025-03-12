console.log('1️⃣ 동기 코드 실행');

setTimeout(() => {
  console.log('3️⃣ setTimeout (태스크 큐)');
}, 0);

Promise.resolve().then(() => {
  console.log('2️⃣ Promise (마이크로태스크 큐)');
});

console.log('4️⃣ 동기 코드 끝');
