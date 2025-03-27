function Rectangle(width, height) {
  this.getWidth = function () {
    return width;
  };
  this.getHeight = function () {
    return height;
  };
  this.setWidth = function (w) {
    width = w;
  };
  this.setHeight = function (h) {
    height = h;
  };
}

Rectangle.prototype.getArea = function () {
  return this.getWidth() * this.getHeight();
};

function Square(length) {
  this.base = Rectangle;
  this.base(length, length); // 부모 클래스 생성자 함수
  // 부모 클래스의 생성자 함수 호출
  // new 없이 호출했으므로 this가 Sqaure의 인스턴스가 됨
}
Square.prototype = Rectangle.prototype;
Square.prototype.constructor = Square;
let rectangle = new Rectangle(5, 7);
let square = new Square(5);
console.log(rectangle.getArea() + ' : ' + square.getArea());
console.log(square instanceof Rectangle);

class Student {
  constructor(name, age) {
    this._name = name;
    this.age = age;
  }
  printProfile() {
    console.log(`이름 : ${this.name}, 나이 : ${this.age}`);
  }
  get name() {
    return this._name;
  }
  set name(name) {
    this._name = name;
  }
}

class Child extends Parent {
  constructor(name, age) {
    super(name);
    this.age = age;
  }
  print() {
    super.print();
    console.log('나이 : ' + this.age);
  }
  static sayHello() {
    console.log('Hello~');
  }
}
