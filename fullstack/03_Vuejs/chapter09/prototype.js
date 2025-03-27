// function Human(name, age) {
//   this.name = name;
//   this.age = age;
//   this.intro = function () {
//     console.log('name = ' + this.name);
//     console.log('age = ' + this.age);
//   };
// }
// let kim = new Human('김상형', 29);
// let lee = new Human('이승우', 42);
// kim.intro();
// lee.intro();

function Human(name, age) {
  this.name = name;
  this.age = age;
}
Human.prototype.intro = function () {
  console.log('name = ' + this.name);
  console.log('age = ' + this.age);
};
let kim = new Human('김상형', 29);
let lee = new Human('이승우', 40);
kim.intro();
lee.intro();
