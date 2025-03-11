function outer() {
  var value = 1234;
}

outer();

//참조하고 있는 값이 없기 때문에 value는 이미 스택에서 사라졌다.
console.log('value = ' + value);
