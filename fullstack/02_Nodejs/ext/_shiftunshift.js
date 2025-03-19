const ar = [0, 1, 2, 3];
console.log('ar = ' + ar);
ar.unshift(100, 200);
console.log('ar = ' + ar);
const test1 = ar.unshift(300);

console.log(test1);
console.log('ar = ' + ar);
const test = ar.shift();

console.log(test);
console.log('ar = ' + ar);
