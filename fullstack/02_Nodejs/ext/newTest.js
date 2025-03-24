function Student(name, korean, math, english, science) {
  this.name = name;
  this.korean = korean;
  this.math = math;
  this.english = english;
  this.science = science;
}
let student1 = new Student('김세진', 90, 83, 76, 89);
let student2 = Student('김세진', 90, 83, 76, 89);

console.log(student1, student2);
