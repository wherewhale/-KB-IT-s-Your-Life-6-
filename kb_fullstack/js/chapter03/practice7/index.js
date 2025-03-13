// 시나리오
// 헬스장에서는 회원들의 운동 예약을 비동기적으로 처리하고, 결과를 파일로 저장하고 있습니다.
// 예약이 완료되면 해당 내용을 logs/reservations.txt 파일에 기록해 주세요.
// 예약이 중복되지 않도록 처리하는 것도 중요합니다.

// 요구사항
// logs/reservations.txt 파일이 미리 생성되어 있어야 합니다.
// 김종국: 벤치프레스
// 유재석: 스쿼트
// 회원 이름과 예약 종목을 입력받아, setTimeout과 Promise를 사용해 2초 후 비동기적으로 예약을 완료하세요.
// 예약 완료 메시지는 "이승기 회원님의 스피닝 예약이 완료되었습니다!"로 출력하세요.
// 예약을 진행하기 전에, fs.promises.readFile을 사용해 기존 예약 목록을 확인하세요.
// 이미 예약된 회원이면, "이승기 회원님은 이미 예약되어 있습니다."라고 출력하고 예약을 중단하세요.
// 예약이 중복되지 않는다면, fs.promises.appendFile*을 사용해 logs/reservations.txt 파일에 예약 정보를 추가하세요.
// 파일 추가가 완료되면 "예약 기록이 파일에 저장되었습니다."를 출력하세요.
// 파일이 존재하지 않으면 "예약 기록 파일이 없습니다."라고 출력하세요.
// async/await을 사용해 순차적으로 작업을 처리하세요.

// 출력 예제 (이미 예약되어 있지 않은 경우)
// 예약 처리 중...
// 이승기 회원님의 스피닝 예약이 완료되었습니다!
// 예약 기록이 파일에 저장되었습니다.
// logs/reservations.txt 최종 파일 내용
// 김종국: 벤치프레스
// 유재석: 스쿼트
// 이승기: 스피닝

import fs from 'fs';

function checkFileExists(filepath) {
  if (fs.existsSync(filepath)) {
    return true;
  } else {
    console.log('예약 파일이 없습니다.');
    return false;
  }
}

const reservationExercise = async (name, exercise) => {
  const filepath = './logs/reservations.txt';

  try {
    if (checkFileExists(filepath)) {
      const logs = await fs.promises.readFile(filepath, 'utf8');
      const message = `${name}: ${exercise}`;

      console.log('예약 처리 중...');

      const reservation = await new Promise((resolve, reject) => {
        setTimeout(() => {
          if (logs.includes(name)) {
            reject(`${name} 회원님은 이미 예약되어 있습니다!`);
          } else {
            fs.promises.appendFile(filepath, `${message}\n`, 'utf8', (err) => {
              if (err) {
                reject(`예약 파일에 저장 중 에러: ${err}`);
              }
            });
            resolve(
              `${name} 회원님의 ${exercise} 예약이 완료되었습니다!` +
                '\n예약 기록이 파일에 저장되었습니다.'
            );
          }
        }, 1000);
      });
      console.log(reservation);
    }
  } catch (error) {
    console.error(error);
    return;
  }
};

reservationExercise('이승기', '스피닝');
