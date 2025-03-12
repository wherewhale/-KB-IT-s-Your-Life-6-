function displayA() {
  console.log('A');
}

function displayB() {
  setTimeout(() => {
    console.log('B');
  }, 1000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
