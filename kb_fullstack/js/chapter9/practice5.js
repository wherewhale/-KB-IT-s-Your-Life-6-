let pikachu = { name: '피카츄', level: 5, xp: 20 };

// 여기에 함수를 작성하세요!

const gainXP = () => {
  pikachu.xp += 30;

  if (pikachu.xp >= 50) {
    pikachu.level += 1;
    pikachu.xp = 0;
    console.log(`피카츄이(가) 레벨업! 현재 레벨: ${pikachu.level}`);
  } else {
    console.log(`피카츄이(가) 경험치를 얻었다! 현재 경험치: ${pikachu.xp}`);
  }
};

gainXP(pikachu);
gainXP(pikachu);
