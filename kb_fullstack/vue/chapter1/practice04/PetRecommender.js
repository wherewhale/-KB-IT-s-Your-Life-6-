import fs from 'fs';

export class PetRecommender {
  constructor() {
    this.petRecommendations = [];
  }
  recommendPet(customer) {
    let animal;
    let score = 0;
    let result;

    if (customer.lifestyle === '활동적') {
      animal = 0; //강아지
    } else {
      animal = 1; //고양이
    }

    if (customer.housing !== '아파트') {
      score += 1; //아파트
    }

    if (customer.familyMembers !== '어린이 있음') {
      score += 1; //어��이
    }

    if (animal === 0) {
      if (score === 0) {
        result = '말티즈';
      } else if (score === 1) {
        result = '골든 리트리버';
      } else {
        result = '늑대';
      }
    } else {
      if (score === 0) {
        result = '코숏';
      } else if (score === 1) {
        result = '치타';
      } else {
        result = '호랑이';
      }
    }

    this.petRecommendations.push({
      name: customer.name,
      recommendedPet: result,
    });
  }

  saveToFile() {
    return new Promise((resolve, reject) => {
      fs.promises
        .writeFile(
          './pet_recommendations.json',
          JSON.stringify(this.petRecommendations)
        )
        .then(() => {
          console.log('pet_recommendations.json 저장 성공!');
          resolve();
        })
        .catch((err) => {
          console.error('pet_recommendations.json 저장 실패:', err);
          reject(err);
        });
    });
  }
}
