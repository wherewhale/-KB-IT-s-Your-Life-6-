// 여기에 함수를 작성하세요!
const pokedex = [];

const addPokemon = (name, type, level) => {
  pokedex.push({ name: name, type: type, level: level });
  console.log(`${name}이(가) 도감에 등록되었습니다!`);
};

// 뮤츠이(가) 도감에 등록되었습니다!
// 망나뇽이(가) 도감에 등록되었습니다!
//

addPokemon('뮤츠', '에스퍼', 70);
addPokemon('망나뇽', '드래곤', 55);

console.log(pokedex);
