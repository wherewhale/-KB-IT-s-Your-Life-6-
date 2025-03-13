// 스토리
// 헬스장에서는 회원들의 운동 기록을 비동기적으로 관리하고 있습니다.
// 각 회원의 운동 완료 메시지를 Promise와 setTimeout을 사용해 비동기적으로 처리하고, 순서에 맞게 출력해 주세요.

// 요구사항
// setTimeout과 Promise를 사용하여 다음 작업을 순차적으로 처리하세요.
// 각 운동은 비동기적으로 처리되어야 하며, resolve를 직접 호출하여 완료 메시지를 출력하세요.
// 아래의 조건에 맞게 코드를 작성해 보세요.

// 처리해야 할 작업
// "운동 기록 처리 시작"을 동기적으로 바로 출력하세요.
// runStretching 함수에서 1초 후 "스트레칭 완료"가 출력되도록 Promise를 사용해 작성하세요.
// runTreadmill 함수에서 0.5초 후 "러닝머신 완료"가 출력되도록 Promise를 사용해 작성하세요.
// runProtein 함수에서 0초 후 "단백질 보충 완료"가 출력되도록 Promise를 사용해 작성하세요.
// 모든 작업이 완료된 후 "운동 기록 처리 종료"를 출력하세요.
// async/await을 사용하여 순서대로 작업이 처리되도록 작성하세요.

// 출력 예제
// 운동 기록 처리 시작
// 스트레칭 완료
// 러닝머신 완료
// 단백질 보충 완료
// 운동 기록 처리 종료

// 힌트
// 각 함수는 Promise와 setTimeout을 사용하여 비동기적으로 작성하세요.
// async/await을 사용하여 함수 호출이 순차적으로 진행되도록 작성하세요.

function runStretching() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('스트레칭 완료');
    }, 1000);
  });
}

function runTreadmill() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('러닝머신 완료');
    }, 500);
  });
}

function runProtein() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('단백질 보충 완료');
    }, 0);
  });
}

async function main() {
  console.log('운동 기록 처리 시작');
  console.log(await runStretching());
  console.log(await runTreadmill());
  console.log(await runProtein());
  console.log('운동 기록 처리 완료');
}

main();
