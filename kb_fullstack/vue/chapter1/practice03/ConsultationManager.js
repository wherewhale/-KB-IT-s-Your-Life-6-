const isValidPhoneNumber = (phoneNumber) => {
  const regex = /^010-[0-9]{4}-[0-9]{4}$/;
  return regex.test(phoneNumber);
};

export class ConsultationManager {
  constructor() {
    this.consultations = [];
  }

  // registerConsultation 메서드로 고객의 상담을 등록하고, 1초 후 자동 저장 완료 메시지를 출력하세요.
  registerConsultation(customer) {
    if (!isValidPhoneNumber(customer.phoneNumber)) {
      // [상담 등록 오류] 이몽룡: 잘못된 전화번호 형식입니다.
      console.log(
        `[상담 등록 오류] ${customer.name}: 잘못된 전화번호 형식입니다.`
      );
    } else if (
      this.consultations.some(
        (consultation) =>
          consultation.customer.phoneNumber === customer.phoneNumber
      )
    ) {
      console.log(
        `[상담 중복 오류] ${customer.name}: 이미 등록된 상담 기록입니다.`
      );
    } else {
      this.consultations.push({ customer });
      console.log(`[상담 등록] ${customer.name} - 선호 펫: ${customer.pet}`);
      setTimeout(() => {
        console.log(`[저장 완료] ${customer.name} 상담 기록 저장 완료!`);
      }, 1000);
    }
  }

  autoEndConsultation() {
    setTimeout(() => {
      console.log('[상담 기록 저장 종료]');
    }, 5000);
  }
}
