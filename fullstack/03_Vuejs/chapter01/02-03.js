const p1 = { name: 'john', age: 20 };
p1.age = 22;

// 객체는 참조형 변수이기 때문에, 변경이 가능하다. (mutable )
console.log(p1);

p1 = { name: 'lee', age: 25 }; //Type Error: Assignment to constant variable.
