//ES6부터는 class를 사용할 수 있도록 기능이 개선되었다.

class User {
  constructor(first, last) {
    this.firstName = first;
    this.lastName = last;
  }
  getFullName() {
    return `${this.firstName} ${this.lastName}`;
  }
}
