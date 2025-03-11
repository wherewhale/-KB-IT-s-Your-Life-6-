// 여기에 함수를 작성하세요!
const findRandomPokemon = () => {
  let pokemons = ['피카츄', '파이리', '꼬부기', '이상해씨', '뮤츠', '리자몽'];

  let randomIndex = Math.floor(Math.random() * pokemons.length);

  if (randomIndex === 5) {
    return `야생의 ${pokemons[randomIndex]}이 나타났다!`;
  } else {
    return `야생의 ${pokemons[randomIndex]}가 나타났다!`;
  }
};

console.log(findRandomPokemon());
console.log(findRandomPokemon());
console.log(findRandomPokemon());
