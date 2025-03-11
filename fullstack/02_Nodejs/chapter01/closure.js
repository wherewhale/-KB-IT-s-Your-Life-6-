function test(name) {
  var output = 'Hello ' + name + '...!';
  return function () {
    console.log(output);
  };
}
var test_1 = test('Node');
var test_2 = test('Javascript');
test_1();
test_2();
