function outer() {
  var value = 1234;
  function inner() {
    console.log('value = ' + value);
  }
  return inner;
}

var outin = outer();
outin(); //inner (클로저로 인해 value값을 참조하고 있다.)
