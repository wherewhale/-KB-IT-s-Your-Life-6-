// 헬스장에서는 회원들의 운동 기록을 주기적으로 백업하고 있습니다.
// logs/workout_log.txt 파일을 읽어 logs/backup_log.txt로 비동기적으로 스트림을 통해 복사하세요.

// 요구사항
// logs/workout_log.txt 파일이 미리 존재해야 합니다.
// 김종국 - 벤치프레스 100kg, 스쿼트 150kg
// 유재석 - 덤벨 컬 20kg, 플랭크 2분
// 해당 파일을 읽어 logs/backup_log.txt로 복사하세요.
// 복사가 완료되면 "백업이 완료되었습니다."라는 문구를 출력하세요.
// 복사 중 에러가 발생하면, "백업 중 오류가 발생했습니다."라는 문구를 출력하세요.
// pipe() 메서드를 사용하여 스트림을 연결하세요.
// 상대 경로를 사용하세요.

// 출력 예제
// 정상적으로 복사가 완료된 경우
// 백업이 완료되었습니다.
// 파일이 없거나 복사 중 오류가 발생한 경우
// 백업 중 오류가 발생했습니다. Error: ENOENT: no such file or directory, open 'logs/workout_log.txt'

import fs from 'fs';

const rs = fs.createReadStream('./logs/workout_log.txt');
const ws = fs.createWriteStream('./logs/backup_log.txt');

rs.on('error', (err) => {
  if (err.code === 'ENOENT') {
    console.error('백업 중 오류가 발생했습니다.', err);
  } else {
    console.error('📛 알 수 없는 오류 발생:', err);
  }
});

rs.pipe(ws)
  .on('close', () => {
    console.log('백업이 완료되었습니다.');
  })
  .on('error', (err) => {
    console.error('백업 중 오류가 발생했습니다.', err);
  });
