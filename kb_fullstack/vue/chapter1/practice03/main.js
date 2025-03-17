// 요구사항
// Customer와 ConsultationManager 클래스를 각각 별도의 모듈로 분리하여 작성하세요.
// registerConsultation 메서드로 고객의 상담을 등록하고, 1초 후 자동 저장 완료 메시지를 출력하세요.
// 고객 전화번호는 010-0000-0000 형태로 입력해야 하며, 형식이 다르면 오류 메시지를 출력하세요.
// 5초 후 자동으로 상담 기록 저장을 종료하고 [상담 기록 저장 종료] 메시지를 출력하세요.
// 상담 기록은 중복 등록이 불가능하도록 처리하세요.
// import와 export를 통해 모듈을 정상적으로 불러오세요.

// :흰색_확인_표시: 폴더 구조
// /consultation
// ├── Customer.js             // Customer 클래스
// ├── ConsultationManager.js  // ConsultationManager 클래스
// └── main.js                 // 프로그램 실행
// :흰색_확인_표시: main.js (실행 파일)
// // main.js
// import { Customer } from './Customer.js';
// import { ConsultationManager } from './ConsultationManager.js';

// // 상담 매니저 인스턴스 생성
// const manager = new ConsultationManager();

// // 상담 등록 예시
// manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '고양이'));
// manager.registerConsultation(new Customer('이몽룡', '123-4567-8901', '강아지')); // 잘못된 번호
// manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '고양이')); // 중복 등록

// // 5초 후 상담 기록 자동 종료
// manager.autoEndConsultation();
// :흰색_확인_표시: 출력 예제
// [상담 등록] 홍길동 - 선호 펫: 고양이
// [상담 등록 오류] 이몽룡: 잘못된 전화번호 형식입니다.
// [상담 중복 오류] 홍길동: 이미 등록된 상담 기록입니다.
// [저장 완료] 홍길동 상담 기록 저장 완료!
// [상담 기록 저장 종료]

import { Customer } from './Customer.js';
import { ConsultationManager } from './ConsultationManager.js';

const manager = new ConsultationManager();
manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '고양이'));
manager.registerConsultation(new Customer('이몽룡', '123-4567-8901', '강아지')); // 잘못된 번호
manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '고양이')); // 중복 등록

manager.autoEndConsultation();
