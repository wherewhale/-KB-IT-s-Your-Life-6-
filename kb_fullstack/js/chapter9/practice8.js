let squirtle = { name: '꼬부기', hp: 50, attack: 10, type: '물' };
let bulbasaur = { name: '이상해씨', hp: 50, attack: 8, type: '풀' };

// 여기에 함수를 작성하세요!
const checkWeakness = (a, b) => {
  if (a === '불' && b === '풀') {
    return true;
  } else if (a === '물' && b === '불') {
    return true;
  } else if (a === '풀' && b === '물') {
    return true;
  } else {
    return false;
  }
};

const battle = (a, b) => {
  let damage = a.attack;

  if (checkWeakness(a.type, b.type)) {
    damage = damage * 2;
  }

  if (checkWeakness(b.type, a.type)) {
    damage = damage / 2;
  }

  b.hp -= damage;
  console.log(`${a.name}이(가) ${b.name}을(를) 공격했다! (피해량: ${damage})`);
  console.log(`${b.name}의 남은 체력 ${b.hp}`);
};

battle(squirtle, bulbasaur);
battle(bulbasaur, squirtle);

// 꼬부기이(가) 이상해씨을(를) 공격했다! (피해량: 5)
// 이상해씨의 남은 체력: 45
// 이상해씨가 꼬부기를 공격했다! (피해량: 16)
// 꼬부기의 남은 체력: 34
