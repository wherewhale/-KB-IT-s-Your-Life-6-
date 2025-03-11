let charmander = { name: '파이리', level: 14, evolution: '리자드' };
let pikachu = { name: '피카츄', level: 20, evolution: null };

// 여기에 함수를 작성하세요!

const levelUp = (pokemon) => {
  pokemon.level += 1;
  console.log(`${pokemon.name}의 레벨이 ${pokemon.level}이(가) 되었다!`);
  if (pokemon.evolution !== null && pokemon.level == 16) {
    pokemon.name = pokemon.evolution;
    console.log(`${pokemon.name}이(가) ${pokemon.evolution}으로 진화했다!`);
  }
};

levelUp(charmander);
levelUp(charmander);
levelUp(pikachu);
