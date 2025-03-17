// const youngho = {
//   firstName: 'Youngho',
//   lastName: 'Son',
//   getFullName: function () {
//     return `${this.firstName} ${this.lastName}`;
//   },
// };

// // 일반함수에서 this는 호출한 객체
// console.log(youngho.getFullName()); // Youngho Son

function user(first, last) {
  this.firstName = first;
  this.lastName = last;
}

user.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName} (Prototype method)`;
};

const youngho = new user('Youngho', 'Son');
const tester = new user('Tester', 'Lee');

console.log(youngho.getFullName()); // Youngho Son (Prototype method)
console.log(tester.getFullName()); // Tester Lee (Prototype method)
