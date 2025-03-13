// 헬스장에서는 회원들의 3대 운동 기록(벤치프레스, 스쿼트, 데드리프트)을 각각의 텍스트 파일로 기록하고 있습니다.
// 각 회원의 기록을 조회하여, 3대 운동의 합이 500kg, 200kg을 넘는지 분석하고 결과를 출력하세요.

// :글씨가_쓰여진_페이지: 요구사항
// logs/bench.txt 파일에는 회원들의 벤치프레스 기록이 다음과 같은 포맷으로 기록되어 있습니다.
// 이승기: 150
// 김종국: 200
// 유재석: 80
// 박보검: 100
// 이병헌: 30
// logs/squat.txt 파일에는 회원들의 스쿼트 기록이 다음과 같은 포맷으로 기록되어 있습니다.
// 이승기: 180
// 김종국: 300
// 유재석: 60
// 박보검: 180
// 이병헌: 10
// logs/deadlift.txt 파일에는 회원들의 데드리프트 기록이 다음과 같은 포맷으로 기록되어 있습니다.
// 이승기: 180
// 김종국: 300
// 유재석: 60
// 박보검: 180
// 이병헌: 90

// 프로그램은 회원 이름을 입력받아, 세 개의 파일에서 해당 회원의 기록을 조회하세요.
// 3대 운동 기록을 조회한 후, 다음과 같이 결과를 출력하세요.

// 총합이 500kg 이상인 경우
// "이승기 회원님! 3대 500 돌파! 강력한 힘의 소유자!"
// 총합이 200kg 이상 500kg 미만인 경우
// "이승기 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!"
// 총합이 200kg 미만인 경우
// "이승기 회원님, 아직 3대 200은 부족해요. 힘내세요!"
// 존재하지 않는 회원의 경우,
// "정우성 회원님의 기록이 없습니다!"라는 메시지를 출력하세요.
// 파일이 존재하지 않을 경우, "운동 기록 파일이 없습니다!"라고 출력하세요.

// fs.promises.readFile을 사용해 비동기적으로 파일을 읽고,
// async/await으로 순차적으로 처리하세요.

import fs from 'fs';

const bench = './logs/bench.txt';
const squat = './logs/squat.txt';
const deadlift = './logs/deadlift.txt';

const memberLog = {};

function checkFileExists(filepath) {
  if (fs.existsSync(filepath)) {
    return true;
  } else {
    console.log('운동 기록 파일이 없습니다!');
    return false;
  }
}

async function loadWeight(path) {
  try {
    const data = await fs.promises.readFile(path, 'utf8');
    return data.split('\n').map((line) => line.split(': '));
  } catch (error) {
    if (error.code === 'ENOENT') {
      console.log('운동 기록 파일이 없습니다!');
    } else {
      console.error(path, error);
    }
    return [];
  }
}

// const benchWeights = await loadWeight(bench);
// const squatWeights = await loadWeight(squat);
// const deadliftWeights = await loadWeight(deadlift);
if (
  checkFileExists(bench) &&
  checkFileExists(squat) &&
  checkFileExists(deadlift)
) {
  try {
    const benchWeights = await loadWeight(bench);
    const squatWeights = await loadWeight(squat);
    const deadliftWeights = await loadWeight(deadlift);

    if (!benchWeights) {
      throw new Error('benchWeights가 정상적으로 로드되지 않았습니다.');
    }

    benchWeights.forEach(([name, weight]) => {
      if (memberLog[name] === undefined) memberLog[name] = 0;
      memberLog[name] += parseInt(weight);
    });

    squatWeights.forEach(([name, weight]) => {
      if (memberLog[name] === undefined) memberLog[name] = 0;
      memberLog[name] += parseInt(weight);
    });

    deadliftWeights.forEach(([name, weight]) => {
      if (memberLog[name] === undefined) memberLog[name] = 0;
      memberLog[name] += parseInt(weight);
    });
  } catch (error) {
    console.error('🔴 오류 발생:', error);
  }

  const members = ['이승기', '김종국', '박보검', '유재석', '이병헌', '정우성'];

  members.forEach((name) => {
    if (memberLog[name] === undefined) {
      console.log(`${name} 회원님의 기록이 없습니다!`);
      return;
    }
    const totalWeight = memberLog[name];
    if (totalWeight >= 500) {
      console.log(`${name} 회원님! 3대 500 돌파! 강력한 힘의 소유자!`);
      return;
    } else if (200 <= totalWeight) {
      console.log(`${name} 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!`);
      return;
    } else {
      console.log(`${name} 회원님, 아직 3대 200은 부족해요. 힘내세요!`);
      return;
    }
  });
}
