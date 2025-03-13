// 시나리오
// 헬스장에서는 회원들의 식단을 유쾌하게 관리하고 있습니다. 매일 회원들이 섭취한 칼로리를 기록하고, 500kcal가 넘으면 재치있는 메시지로 경고하도록 시스템을 구축해 주세요. :웃음:

// 요구사항
// logs/diet.txt 파일이 미리 생성되어 있어야 합니다.
// 김종국: 400kcal, 괜찮아요 아직 여유 있어요!
// 유재석: 350kcal, 좋습니다! 건강하게 가요!
// 회원 이름과 칼로리를 입력받아, 매일 섭취한 칼로리를 기록하세요.
// 기록 포맷 예시: "이승기: 450kcal, 괜찮아요 아직 여유 있어요!"
// 칼로리 기록은 setTimeout과 Promise를 사용해 1초 후 비동기적으로 처리하세요.
// 기록이 완료되면 "이승기 회원님, 오늘도 건강한 한 끼 감사합니다!"라는 메시지를 출력하세요.
// fs.promises.appendFile을 사용해 파일에 기록하세요.
// 만약 해당 회원의 당일 섭취 칼로리가 500kcal 이상이면, "이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!"라는 경고 메시지를 추가로 기록하세요.
// 파일이 정상적으로 기록되면 "식단 기록이 맛있게 저장되었습니다!"를 출력하세요.
// 파일이 존재하지 않으면 "식단 기록 파일이 어디로 갔죠?!"라고 출력하세요.
// async/await을 사용해 순차적으로 작업을 처리하세요.

// 출력 예제 (500kcal 미만일 경우)
// 식단 기록 중... (오늘도 건강한 한 끼!)
// 이승기 회원님, 오늘도 건강한 한 끼 감사합니다!
// 식단 기록이 맛있게 저장되었습니다!
// logs/diet.txt 최종 파일 내용
// 김종국: 400kcal, 괜찮아요 아직 여유 있어요!
// 유재석: 350kcal, 괜찮아요 아직 여유 있어요!
// 이승기: 450kcal, 괜찮아요 아직 여유 있어요!

// 출력 예제 (500kcal 이상일 경우)
// 식단 기록 중... (오늘도 건강한 한 끼!)
// 이승기 회원님, 오늘도 건강한 한 끼 감사합니다!
// 이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!
// 식단 기록이 맛있게 저장되었습니다!
// logs/diet.txt 최종 파일 내용
// 김종국: 400kcal, 괜찮아요 아직 여유 있어요!
// 유재석: 350kcal, 괜찮아요 아직 여유 있어요!
// 이승기: 550kcal, 조금 과했어요! 내일은 가볍게 가볼까요?
// 이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!

import fs from 'fs';

function checkFileExists(filepath) {
  if (fs.existsSync(filepath)) {
    return true;
  } else {
    console.log('식단 파일이 어디로 갔죠!?');
    return false;
  }
}

const asyncAppend = async (filepath, message, resolveMessage) => {
  const messageContent = message;

  return await new Promise((resolve, reject) => {
    setTimeout(() => {
      fs.promises.appendFile(filepath, `${messageContent}\n`, 'utf8', (err) => {
        if (err) {
          reject(`예약 파일에 저장 중 에러: ${err}`);
        }
      });

      resolve(resolveMessage);
    }, 1000);
  });
};

const recordDiet = async (name, calory) => {
  const filepath = './logs/diet.txt';

  if (!checkFileExists(filepath)) {
    return;
  }
  let message = `${name}: ${calory}kcal, ${
    calory >= 500
      ? '조금 과했어요! 내일은 가볍게 가볼까요?'
      : '괜찮아요 아직 여유 있어요!'
  }`;

  if (calory >= 500) {
    const input1 = asyncAppend(
      filepath,
      message,
      '이승기 회원님, 오늘도 건강한 한 끼 감사합니다!'
    );

    const input2 = asyncAppend(
      filepath,
      '이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!',
      '식단 기록이 맛있게 저장되었습니다!'
    );
    // 식단 기록 중... (오늘도 건강한 한 끼!)
    // 이승기 회원님, 오늘도 건강한 한 끼 감사합니다!
    // 이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!
    // 식단 기록이 맛있게 저장되었습니다!

    console.log('식단 기록 중... (오늘도 건강한 한 끼!)');
    console.log(await input1);
    console.log('이승기 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!');
    console.log(await input2);
  } else {
    const input1 = asyncAppend(
      filepath,
      message,
      '이승기 회원님, 오늘도 건강한 한 끼 감사합니다!'
    );

    console.log('식단 기록 중... (오늘도 건강한 한 끼!)');
    console.log(await input1);
    console.log('식단 기록이 맛있게 저장되었습니다!');
  }
};

recordDiet('이승기', 450);
