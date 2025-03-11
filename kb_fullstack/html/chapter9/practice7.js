let bulbasaur = { name: '이상해씨', level: 5, skills: ['몸통박치기'] };

// 여기에 함수를 작성하세요!
const levelUp = (pokemon) => {
  pokemon.level += 1;
  console.log(`${pokemon.name}의 레벨이 ${pokemon.level}이(가) 되었다!`);

  for (let skill in newSkills) {
    if (pokemon.level == skill) {
      pokemon.skills.push(newSkills[skill]);
      console.log(
        `신난다~! ${pokemon.name}이(가) ${newSkills[skill]}을(를) 배웠다!`
      );
    }
  }
};

let newSkills = {
  7: '덩굴채찍',
  10: '씨뿌리기',
  16: '솔라빔',
};

levelUp(bulbasaur);
levelUp(bulbasaur);
levelUp(bulbasaur);
