// logs/members.txt 파일이 미리 생성되어 있어야 합니다.
// 김종국: 체중 80kg, 벤치프레스 100kg
// 유재석: 체중 70kg, 스쿼트 150kg
// 새로 추가할 회원 정보는 다음과 같습니다.
// 이승기: 체중 68kg, 벤치프레스 80kg

// fs.appendFile을 사용하여 비동기적으로 회원 정보를 파일에 추가하세요.
// 추가가 완료되면 "회원 정보가 성공적으로 추가되었습니다."를 출력하세요.
// 파일이 존재하지 않는 경우, "회원 정보 파일이 없습니다."라고 출력하세요.
// 상대 경로를 사용하세요.
// :흰색_확인_표시: 출력 예제
// 파일이 정상적으로 존재하고 추가된 경우
// 회원 정보가 성공적으로 추가되었습니다.
// 파일이 존재하지 않는 경우
// 회원 정보 파일이 없습니다.
// logs/members.txt의 최종 내용
// 김종국: 체중 80kg, 벤치프레스 100kg
// 유재석: 체중 70kg, 스쿼트 150kg
// 이승기: 체중 68kg, 벤치프레스 80kg

import fs from 'fs';

const newMemberInfo = '\n이승기: 체중 68kg, 벤치프레스 80kg';

if (!fs.existsSync('./logs/members.txt')) {
  console.log('회원 정보 파일이 없습니다.');
} else {
  fs.appendFile('./logs/members.txt', newMemberInfo, (err) => {
    if (err) {
      console.log('회원 정보 파일이 없습니다.');
      return;
    }
    console.log('회원 정보가 성공적으로 추가되었습니다.');
    return;
  });
}
