// 시나리오
// 헬스장에서는 회원들의 출석 기록을 날짜와 시간까지 정확하게 관리하고 있습니다.
// 회원이 출석하면, 1초 후에 출석 완료 메시지를 출력하고, 출석 결과와 함께 현재 시간을 logs/checkin.txt에 기록해 주세요.
// 하루에 한 번만 출석이 가능하도록 시스템을 구성하세요.

// 요구사항
// logs/checkin.txt 파일이 미리 생성되어 있어야 합니다.
// 김종국: 출석 완료 (2025-03-14 09:00)
// 유재석: 출석 완료 (2025-03-14 09:30)
// 회원 이름을 입력받아 출석을 기록하세요.
// 출석은 1초 후에 "이승기: 출석 완료 (2025-03-14 10:30)"라는 메시지로 출력됩니다.
// 이미 출석한 회원은 "이승기 회원님은 이미 출석하셨습니다!"라는 메시지를 출력하고 중단하세요.
// 출석이 완료되면 fs.promises.appendFile을 사용해 출석 기록을 logs/checkin.txt에 추가하세요.
// 기록 포맷은 "이승기: 출석 완료 (2025-03-14 10:30)"입니다.
// 기록이 완료되면 "출석 기록이 파일에 저장되었습니다!"를 출력하세요.
// 파일이 존재하지 않을 경우 "출석 기록 파일이 없습니다!"를 출력하세요.
// Promise와 setTimeout을 사용해 비동기적으로 처리하세요.
// async/await을 사용해 순차적으로 처리하세요.

// 출력 예제 (첫 출석 시)
// 출석 중...
// 이승기: 출석 완료 (2025-03-14 10:30)
// 출석 기록이 파일에 저장되었습니다!
// logs/checkin.txt 최종 파일 내용
// 김종국: 출석 완료 (2025-03-14 09:00)
// 유재석: 출석 완료 (2025-03-14 09:30)
// 이승기: 출석 완료 (2025-03-14 10:30)

// 출력 예제 (이미 출석한 경우)
// 출석 중...
// 이승기 회원님은 이미 출석하셨습니다!

// 힌트
// fs.promises.readFile로 파일을 읽어 중복 출석을 검사하세요.
// fs.promises.appendFile로 파일에 출석 기록을 추가하세요.
// Promise와 setTimeout으로 1초 후에 출석 메시지를 출력하세요.
// 현재 시간은 new Date()를 사용하여 포맷팅하세요.

import fs from 'fs';

/** filepath: 파일 경로 */
function checkFileExists(filepath) {
  if (fs.existsSync(filepath)) {
    return true;
  } else {
    console.log('회원 정보 파일이 없습니다.');
    return false;
  }
}

function getFormattedDate() {
  const now = new Date();

  const year = now.getFullYear();
  const month = String(now.getMonth() + 1).padStart(2, '0'); // 월(0~11)이므로 +1 필요
  const day = String(now.getDate()).padStart(2, '0');
  const hours = String(now.getHours()).padStart(2, '0');
  const minutes = String(now.getMinutes()).padStart(2, '0');

  return `${year}-${month}-${day} ${hours}:${minutes}`;
}

async function checkIn(name) {
  const filepath = './logs/checkin.txt';

  try {
    if (checkFileExists(filepath)) {
      const logs = await fs.promises.readFile(filepath, 'utf8');
      const message = `\n${name}: 출석 완료 (${getFormattedDate()})`;

      console.log('출석 중...');

      const checkin = await new Promise((resolve, reject) => {
        setTimeout(() => {
          if (logs.includes(name)) {
            reject(`${name} 회원님은 이미 출석하셨습니다!`);
          } else {
            fs.promises.appendFile(filepath, `${message}\n`, 'utf8', (err) => {
              if (err) {
                reject(`출석 기록 파일에 저장 중 에러: ${err}`);
              }
            });
            resolve(message, '\n출석 기록이 파일에 저장되었습니다!');
          }
        }, 1000);
      });
      console.log(checkin);
    }
  } catch (error) {
    console.error(error);
    return;
  }
}

checkIn('이승기');
