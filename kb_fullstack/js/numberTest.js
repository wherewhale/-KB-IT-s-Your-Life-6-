var foo;
console.log(foo); // undefined

foo = 10;
console.log(typeof foo); // number

foo = 'hello';
console.log(typeof foo); // string

foo = true;
console.log(typeof foo); // boolean

foo = null;
console.log(typeof foo); // object

foo = undefined;
console.log(typeof foo); // undefined

foo = Symbol();
console.log(typeof foo); // symbol

foo = {};
console.log(typeof foo); // object

foo = [];
console.log(typeof foo); // object

foo = function () {};
console.log(typeof foo); // function
