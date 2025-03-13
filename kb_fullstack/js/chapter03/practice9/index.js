// 시나리오
// 헬스장에서는 회원마다 미리 지정된 운동 부위(상체/하체)가 존재하며, 해당 정보를 바탕으로 매일 맞춤형 운동 루틴을 추천하고 있습니다.
// logs/memberRoutine.txt 파일에 회원과 운동 부위가 미리 기록되어 있으며, 이를 기반으로 logs/routine.txt 파일에 추천된 루틴을 기록하세요.
// 하루에 한 번만 추천되도록 시스템을 설계하세요.

// 요구사항
// logs/memberRoutine.txt 파일에는 회원 이름과 운동 부위가 다음과 같은 포맷으로 기록되어 있습니다.
// 이승기: 상체
// 김종국: 하체
// 유재석: 상체
// 이승기: 하체
// logs/routine.txt 파일에 추천 결과를 기록하세요.
// 이승기 (상체): 어깨프레스 3세트
// 김종국 (하체): 레그프레스 4세트
// 유재석 (상체): 어깨프레스 3세트
// 회원의 운동 부위에 따라 랜덤으로 운동 루틴을 추천하세요.
// 상체 루틴
// "벤치프레스 3세트"
// "어깨프레스 3세트"
// "팔굽혀펴기 50개"
// 하체 루틴
// "스쿼트 5세트"
// "런지 3세트"
// "레그프레스 4세트"
// 추천 메시지는 setTimeout과 Promise를 사용해 1초 후 비동기적으로 처리하세요.
// 이미 추천된 회원이면 "이승기 회원님은 이미 추천을 받으셨습니다!"라고 출력하고 추천을 중단하세요.
// 추천이 완료되면 fs.promises.appendFile을 사용해 logs/routine.txt*에 기록하세요.
// 정상적으로 기록되면 "이승기 회원님의 추천 루틴이 기록되었습니다!"라고 출력하세요.
// 파일이 존재하지 않으면 "회원 루틴 파일이 없습니다!" 또는 "운동 루틴 기록 파일이 없습니다!"라고 출력하세요.
// async/await을 사용해 순차적으로 작업을 처리하세요.

import fs from 'fs';

// 로그 파일 경로
const memberRoutineLog = './logs/memberRoutine.txt';
const routineLog = './logs/routine.txt';

async function loadMemberRoutine() {
  try {
    const data = await fs.promises.readFile(memberRoutineLog, 'utf8');
    return data.split('\n').map((line) => line.split(': '));
  } catch (error) {
    if (error.code === 'ENOENT') {
      console.log('회원 루틴 파일이 없습니다!');
    } else {
      console.error('loadMemberRoutine:', error);
    }
    return [];
  }
}

const getRandomExercise = (upDown) => {
  const random = Math.floor(Math.random() * 3);

  const up = ['벤치프레스 3세트', '숄더프레스 3세트', '팔굽혀펴기 50개'];
  const down = ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트'];

  return upDown === '상체' ? up[random] : down[random];
};

/** memberRoutine : 멤버 루틴 객체 (멤버 : 루틴) */
async function addExerciseRoutine(name, updown) {
  console.log(`운동 루틴 추천 중... (${name})`);

  const logs = await fs.promises.readFile(routineLog, 'utf8');

  try {
    const recommend = await new Promise((resolve, reject) => {
      setTimeout(() => {
        if (logs.includes(name)) {
          reject(`${name}님은 이미 추천을 받으셨습니다!`);
        } else {
          let recommendExercise;
          if (updown === '상체') {
            recommendExercise = `${getRandomExercise('상체')}`;
          } else {
            recommendExercise = `${getRandomExercise('하체')}`;
          }
          console.log(
            `${name} 회원님, 오늘의 ${updown} 추천 루틴은 '${recommendExercise}'입니다! 화이팅!`
          );
          fs.promises.appendFile(
            routineLog,
            `[${name}] (${updown}): ${recommendExercise}\n`,
            'utf8',
            (err) => {
              if (err) {
                reject(`운동 파일에 저장 중 에러: ${err}`);
              }
            }
          );
          resolve(`${name} 회원님의 추천 루틴이 기록되었습니다.`);
        }
      }, 1000);
    });

    console.log(recommend);
  } catch (error) {
    console.error(error);
  }
}

const memberRoutine = await loadMemberRoutine();
// [ [ '이승기', '상체' ], [ '김종국', '하체' ], [ '유재석', '상체' ], [ '이승기', '하체' ] ]

for (const member of memberRoutine) {
  await addExerciseRoutine(member[0], member[1]);
}
