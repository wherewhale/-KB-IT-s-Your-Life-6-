// 여기에 함수를 작성하세요!

getPokemonTypeInfo = (type) => {
  if (type === '불') {
    return '🔥 불 타입 포켓몬은 강한 공격력을 가지고 있어!';
  } else if (type === '물') {
    return '💧 물 타입 포켓몬은 유연한 전투 스타일을 가지고 있어!';
  } else {
    return '🤔 알 수 없는 타입이네!';
  }
};

console.log(getPokemonTypeInfo('불'));
console.log(getPokemonTypeInfo('물'));
console.log(getPokemonTypeInfo('전기'));
