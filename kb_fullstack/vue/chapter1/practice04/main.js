// Customer 클래스에서 고객 정보를 입력받아 name, lifestyle, housing, familyMembers를 관리하세요.
// PetRecommender 클래스를 생성하여 펫을 추천하세요.
// 생활 패턴(활동적/조용한), 주거 형태(아파트/단독주택), 가족 구성원(어린이 있음/없음)에 따라 조건에 맞는 펫을 추천하세요.
// 추천 결과는 pet_recommendations.json 파일에 저장하세요.
// fs.promises로 비동기 파일 저장을 구현하세요.

// :흰색_확인_표시: 폴더 구조
// /recommendation
// ├── Customer.js
// ├── PetRecommender.js
// ├── main.js
// └── pet_recommendations.json

// :흰색_확인_표시: main.js
// import { Customer } from './Customer.js';
// import { PetRecommender } from './PetRecommender.js';

// const recommender = new PetRecommender();

// const customer1 = new Customer('홍길동', '활동적', '단독주택', '어린이 없음');
// const customer2 = new Customer('이몽룡', '조용한', '아파트', '어린이 있음');

// recommender.recommendPet(customer1);
// recommender.recommendPet(customer2);
// await recommender.saveToFile();
// :흰색_확인_표시: pet_recommendations.json (결과 예시)
// [
//   {
//     "name": "홍길동",
//     "recommendedPet": "골든 리트리버"
//   },
//   {
//     "name": "이몽룡",
//     "recommendedPet": "고양이"
//   }
// ]

import { Customer } from './Customer.js';
import { PetRecommender } from './PetRecommender.js';

const recommender = new PetRecommender();

const customer1 = new Customer('홍길동', '활동적', '단독주택', '어린이 없음');
const customer2 = new Customer('이몽룡', '조용한', '아파트', '어린이 있음');

recommender.recommendPet(customer1);
recommender.recommendPet(customer2);
await recommender.saveToFile();
