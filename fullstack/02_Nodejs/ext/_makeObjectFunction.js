function makeStudent(name, korean, math, english, science) {
  let student = {
    name: name,
    korean: korean,
    math: math,
    english: english,
    science: science,

    getSum: function () {
      return this.korean + this.math + this.english + this.science;
    },

    getAverage: function () {
      return this.getSum() / 4;
    },

    toString: function () {
      return `${this.name}\t${this.getSum()}\t${this.getAverage()}`;
    },
  };
  return student;
}
