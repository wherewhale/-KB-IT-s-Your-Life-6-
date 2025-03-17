// Pet 클래스를 만들어 name, species, vaccinations(예방접종 목록),
// healthCheckDate(마지막 건강검진 날짜), alreadyWarned(경고 여부)를 속성으로 가집니다.
// PetHealthManager 클래스를 생성하여 펫 건강 정보를 관리하세요.
// registerPet 메서드로 펫을 등록하고, 등록 시 펫의 정보를 출력하세요.
// 예방접종은 중복 등록이 불가능하도록 하고, 중복 시 오류 메시지를 출력하세요.
// checkHealthStatus 메서드를 통해 3초마다 건강 상태를 검사하고, 1년 이상 건강검진을 받지 않은 경우 단 한 번만 경고하도록 처리하세요.
// updateHealthCheckDate 메서드로 건강검진 날짜를 업데이트할 수 있어야 합니다.
// 건강 상태 검사는 10초 후에 자동 종료되도록 하며, 종료 시 [검사 종료] 메시지를 출력하세요.
// :흰색_확인_표시: 출력 예제
// [등록] 고양이 - 나비 (예방접종: [종합백신], 건강검진: 2023-03-10)
// [예방접종 추가] 나비: 광견병
// [예방접종 중복] 나비: 광견병은 이미 등록되어 있습니다.
// [건강검진 경고] 나비: 1년 이상 건강검진을 받지 않았습니다!
// [건강검진 업데이트] 나비: 2024-03-10
// [검사 종료]
// :흰색_확인_표시: 예시 형식
// 🐾 시스템 사용 예시

function getFormattedDate(date) {
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0'); // 월(0~11)이므로 +1 필요
  const day = String(date.getDate()).padStart(2, '0');

  return `${year}-${month}-${day}`;
}

function checkDate(name, date, alreadyWarned) {
  const currentDate = new Date();
  const checkInDate = new Date(date);
  const diffTime = Math.abs(currentDate - checkInDate);
  const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

  if (diffDays >= 365) {
    if (!alreadyWarned) {
      console.log(`[건강검진 경고] ${name}: 1년 이상 검진을 받지 않았습니다!`);
      alreadyWarned = true;
    }
  } else {
    alreadyWarned = false;
  }
}

class Pet {
  constructor(name, species, vaccinations, healthCheckDate) {
    this.name = name;
    this.species = species;
    this.vaccinations = vaccinations;
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = false;
  }
  addVaccination(vaccination) {
    if (!this.vaccinations.includes(vaccination)) {
      this.vaccinations.push(vaccination);
      console.log(`[예방접종 추가] ${this.name}: ${vaccination}`);
      return;
    } else {
      console.log(
        `[예방접종 중복] ${this.name}: ${vaccination}은(는) 이미 등록되어 있습니다.`
      );
    }
  }

  updateHealthCheckDate() {
    this.healthCheckDate = new Date();
    console.log(
      `[건강검진 업데이트] ${this.name}: ${getFormattedDate(
        this.healthCheckDate
      )}`
    );
  }
}

// [등록] 고양이 - 나비 (예방접종: [종합백신], 건강검진: 2023-03-10)
class PetHealthManager {
  constructor() {
    this.pets = [];
  }
  registerPet(pet) {
    this.pets.push(pet);
    console.log(
      `[등록] ${pet.species} - ${pet.name} (예방접종: [${pet.vaccinations.join(
        ', '
      )}], 건강검진: ${getFormattedDate(pet.healthCheckDate)})`
    );
  }

  checkHealthStatus() {
    this.pets.forEach((pet) => {
      checkDate(pet.name, pet.healthCheckDate, pet.alreadyWarned);
    });
  }
}

const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2023-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병'); // 중복 테스트

// checkHealthStatus 메서드를 통해 3초마다 건강 상태를 검사하고, 1년 이상 건강검진을 받지 않은 경우 단 한 번만 경고하도록 처리하세요.
// 건강 상태 검사 시작
const checkHealthIntervalId = setInterval(() => {
  manager.checkHealthStatus();
}, 3000);

setTimeout(() => {
  clearInterval(checkHealthIntervalId); // 3초마다 실행되는 검사 중지
  console.log('[검사 종료]');
}, 10000);

// 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date());
}, 5000);
