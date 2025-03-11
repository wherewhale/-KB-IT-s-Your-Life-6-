// const person = {
//   name: 'Whale',
//   getName: function () {
//     console.log('person getName', this);
//   },
// };

// const globalPerson = person.getName;
// globalPerson();

let person = {
  name: '윤인성',
  eat: function (food) {
    console.log(this.name + '이 ' + food + '을/를 먹습니다.');

    const innerFunc = () => console.log('innerFunc', this);
    innerFunc();
  },
};

person.eat('밥');
