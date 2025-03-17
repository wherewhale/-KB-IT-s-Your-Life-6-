// :책: 요구사항
// EducationProgram 클래스에서 교육 과정 정보를 입력받아 title, description을 관리하세요.
// EducationManager 클래스를 생성하여 교육 과정 등록과 이수 여부를 관리하세요.
// registerProgram 메서드로 교육 과정을 등록하세요.
// completeProgram 메서드에서 다음 두 가지 방법으로 이수 여부를 업데이트해보세요:
// 일반 함수(function) 사용 시 this가 어떻게 바인딩되는지 확인.
// 화살표 함수(=>) 사용 시 this가 어떻게 바인딩되는지 확인.
// 기록은 education_records.json 파일로 비동기 저장하세요.
// saveToFile은 fs.promises를 사용하여 비동기로 처리하세요.

// :흰색_확인_표시: 폴더 구조
// /education
// ├── EducationProgram.js
// ├── EducationManager.js
// ├── main.js
// └── education_records.json

// :흰색_확인_표시: education_records.json (결과 예시)
// [
//   {
//     "title": "기초 펫 돌봄",
//     "description": "기초적인 펫 돌봄 방법을 배웁니다.",
//     "isCompleted": true
//   },
//   {
//     "title": "건강관리",
//     "description": "펫의 건강을 유지하는 방법을 배웁니다.",
//     "isCompleted": true
//   }
// ]

// :흰색_확인_표시: 출력 예시
// [등록 완료] 교육 과정: 기초 펫 돌봄
// [등록 완료] 교육 과정: 건강관리
// [이수 완료 - 일반 함수] 기초 펫 돌봄
// [이수 완료 - 화살표 함수] 건강관리
// [파일 저장 완료] 교육 기록이 파일로 저장되었습니다.

import { EducationProgram } from './EducationProgram.js';
import { EducationManager } from './EducationManager.js';

const manager = new EducationManager();

const program1 = new EducationProgram(
  '기초 펫 돌봄',
  '기초적인 펫 돌봄 방법을 배웁니다.'
);
const program2 = new EducationProgram(
  '건강관리',
  '펫의 건강을 유지하는 방법을 배웁니다.'
);

manager.registerProgram(program1);
manager.registerProgram(program2);

// 일반 함수로 이수 처리 (this 바인딩 확인)
manager.completeProgramWithFunction('기초 펫 돌봄');

// 화살표 함수로 이수 처리 (this 바인딩 확인)
manager.completeProgramWithArrowFunction('건강관리');

// 파일로 저장
await manager.saveToFile();
