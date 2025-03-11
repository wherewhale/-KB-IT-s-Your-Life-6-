const attackPokemon = (attacker, defender) => {
  defender.hp -= attacker.attack;
  if (defender.hp > 0) {
    console.log(
      `${attacker.name}이(가) ${defender.name}을 공격했다! 남은 체력 : ${defender.hp}`
    );
  } else {
    console.log(`${defender.name}이(가) 쓰러졌다!`);
  }
};

let pikachu = { name: '피카츄', hp: 100, attack: 20 };
let charmander = { name: '파이리', hp: 80, attack: 15 };

// 여기에 함수를 작성하세요!

attackPokemon(pikachu, charmander);
attackPokemon(charmander, pikachu);
attackPokemon(pikachu, charmander);
attackPokemon(pikachu, charmander);
attackPokemon(pikachu, charmander);
