// 프로젝트의 logs 폴더 안에 workout_log.txt 파일이 미리 생성되어 있어야 합니다.
// 파일 내용은 다음과 같이 입력되어 있어야 합니다.
// 김종국 - 벤치프레스 100kg, 스쿼트 150kg
// 유재석 - 덤벨 컬 20kg, 플랭크 2분
// fs.readFile을 사용해 비동기적으로 파일을 읽고 내용을 출력하세요.
// 파일을 정상적으로 읽으면 "운동 기록 출력 완료!"라는 문구를 먼저 출력한 뒤, 파일 내용을 출력하세요.
// 상대 경로를 사용하세요.
// 파일이 존재하지 않으면 "운동 기록 파일이 없습니다."라고 출력하세요.
// :흰색_확인_표시: 출력 예제
// 운동 기록 출력 완료!
// 김종국 - 벤치프레스 100kg, 스쿼트 150kg
// 유재석 - 덤벨 컬 20kg, 플랭크 2분
// 파일이 없는 경우:
// 운동 기록 파일이 없습니다.

import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = fileURLToPath(new URL('.', import.meta.url));
const filePath = path.join(__dirname, 'logs', 'workout_log.txt');

if (fs.existsSync(filePath)) {
  fs.readFile(filePath, 'utf8', (err, data) => {
    if (err) {
      console.error('파일을 읽는 도중 에러 발생:', err);
      return;
    }
    console.log('운동 기록 출력 완료!');
    console.log(data);
  });
} else {
  console.log('운동 기록 파일이 없습니다.');
}
