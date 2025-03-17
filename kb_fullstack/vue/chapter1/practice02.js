// Item 클래스를 생성하여 name, type(사료/용품), stock(재고), alreadyWarned(경고 여부)을 속성으로 관리하세요.
// InventoryManager 클래스를 생성하여 재고를 관리하세요.
// addItem 메서드로 아이템을 등록하고, 등록 시 해당 정보를 출력하세요.
// updateStock 메서드로 재고를 업데이트하세요.
// 재고가 5개 미만일 경우 자동으로 '재고 부족' 경고 메시지를 출력하세요.
// 재고가 음수로 입력되면 오류 메시지를 출력하세요.
// 재고가 정상적으로 변경되면 alreadyWarned를 초기화하여 다시 경고가 가능하도록 설정하세요.
// checkStock 메서드를 통해 1초마다 재고 상태를 자동으로 검사하세요.
// 검사 상태는 5초 후 자동 종료되도록 하며, 종료 시 [재고 검사 종료] 메시지를 출력하세요.

// 출력 예제
// [추가] 사료 - 고급 고양이 사료 (재고: 10개)
// [업데이트] 고급 고양이 사료 재고: 4개
// [재고 부족 경고] 고급 고양이 사료: 재고가 5개 미만입니다!
// [업데이트 오류] 재고는 0 이상이어야 합니다.
// [자동 경고] 고급 고양이 사료: 재고가 5개 미만입니다!
// [재고 검사 종료]

// 예시 코드 (사용 흐름 안내용)
// // 🐾 시스템 사용 예시
// const inventory = new InventoryManager();

// // 아이템 등록
// const item1 = new Item('고급 고양이 사료', '사료', 10);
// inventory.addItem(item1);

// // 재고 업데이트
// inventory.updateStock('고급 고양이 사료', 4);  // 5개 미만 → 경고 발생
// inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// // 재고 상태 검사 시작 (5초 후 종료)
// inventory.checkStock();

// 클래스 및 메서드 요구사항
// Item 클래스
// 속성: name, type(사료/용품), stock(재고), alreadyWarned(경고 여부).
// 생성자를 통해 초기 값을 설정하세요.
// InventoryManager 클래스
// addItem(item): 새로운 아이템을 등록하고, 등록 정보를 출력하세요.
// updateStock(name, newStock): 재고를 업데이트하고, 5개 미만이면 경고를 출력하세요. 음수일 경우 오류를 발생시키세요.
// checkStock(): 1초마다 자동으로 재고 상태를 검사하고, 5초 후 자동 종료하세요.

class Item {
  constructor(name, type, stock, alreadyWarned = false) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = alreadyWarned;
  }
}

class InventoryManager {
  constructor() {
    this.inventory = [];
  }
  addItem(item) {
    this.inventory.push(item);
    // [추가] 사료 - 고급 고양이 사료 (재고: 10개)
    console.log(`[추가] ${item.name} - ${item.type} (재고: ${item.stock}개)`);
  }

  updateStock(name, newStock) {
    // 재고가 5개 미만일 경우 자동으로 '재고 부족' 경고 메시지를 출력하세요.
    // 재고가 음수로 입력되면 오류 메시지를 출력하세요.
    // 재고가 정상적으로 변경되면 alreadyWarned를 초기화하여 다시 경고가 가능하도록 설정하세요.
    const item = this.inventory.find((i) => i.name === name);

    if (newStock < 0) {
      console.log('[업데이트 오류] 재고는 0 이상이어야 합니다.');
      return;
    }

    if (newStock < 5) {
      console.log(`[재고 부족 경고] ${item.name}: 재고가 5개 미만입니다!`);
    }

    item.stock = newStock;
    item.alreadyWarned = false;
    console.log(`[업데이트] ${item.name} 재고: ${item.stock}개`);
  }
  checkStock() {
    const intervalId = setInterval(() => {
      this.inventory.forEach((item) => {
        if (item.stock < 5 && !item.alreadyWarned) {
          console.log(`[자동 경고] ${item.name}: 재고가 5개 미만입니다!`);
          item.alreadyWarned = true;
        }
      });
    }, 1000);
    setTimeout(() => {
      clearInterval(intervalId);
      console.log('[재고 검사 종료]');
    }, 5000);
  }
}

// 🐾 시스템 사용 예시
const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
