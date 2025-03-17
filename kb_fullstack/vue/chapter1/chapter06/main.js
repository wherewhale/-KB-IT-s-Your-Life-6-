// Pet이라는 상위 클래스를 생성하여 name, species, adoptionDate(입양일)를 관리하세요.
// PetPhoto와 PetGrowthRecord라는 하위 클래스를 생성하고, 각각의 추가 정보를 관리하세요.
// PetPhoto: 사진의 파일 경로(photoPath)와 등록 날짜(uploadDate)를 관리.
// PetGrowthRecord: 성장 기록(description)과 기록 날짜(recordDate)를 관리.
// 사진과 성장 기록을 PetAlbumManager 클래스에서 관리하세요.
// 사진과 성장 기록은 pet_album.json 파일로 비동기로 저장하세요.
// 중복된 사진 파일 경로나 성장 기록 날짜는 중복 등록이 불가능하도록 처리하세요.
// fs.promises를 사용하여 파일을 비동기적으로 저장하세요.

// :흰색_확인_표시: 폴더 구조
// /petAlbum
// ├── Pet.js                      // 상위 클래스
// ├── PetPhoto.js                  // 하위 클래스 1
// ├── PetGrowthRecord.js           // 하위 클래스 2
// ├── PetAlbumManager.js           // 앨범 관리 클래스
// ├── main.js                      // 프로그램 실행 파일
// └── pet_album.json               // 앨범 기록 저장 파일

import { PetPhoto } from './PetPhoto.js';
import { PetGrowthRecord } from './PetGrowthRecord.js';
import { PetAlbumManager } from './PetAlbumManager.js';

const manager = new PetAlbumManager();

// 사진 기록 등록
await manager.addRecord(
  new PetPhoto('나비', '고양이', '2023-03-10', '/images/navy_01.jpg')
);
await manager.addRecord(
  new PetPhoto('나비', '고양이', '2023-03-10', '/images/navy_01.jpg')
); // 중복 테스트

// 성장 기록 등록
await manager.addRecord(
  new PetGrowthRecord(
    '나비',
    '고양이',
    '2023-03-10',
    '처음으로 캣타워를 올랐어요!',
    '2025-03-14'
  )
);
await manager.addRecord(
  new PetGrowthRecord(
    '나비',
    '고양이',
    '2023-03-10',
    '처음으로 캣타워를 올랐어요!',
    '2025-03-14'
  )
); // 중복 테스트
// :흰색_확인_표시: pet_album.json (결과 예시)
// [
//   {
//     "name": "나비",
//     "species": "고양이",
//     "adoptionDate": "2023-03-10",
//     "photoPath": "/images/navy_01.jpg",
//     "uploadDate": "2025-03-14T02:42:35.639Z",
//     "type": "Photo"
//   },
//   {
//     "name": "나비",
//     "species": "고양이",
//     "adoptionDate": "2023-03-10",
//     "description": "처음으로 캣타워를 올랐어요!",
//     "recordDate": "2025-03-14",
//     "type": "Growth Record"
//   }
// ]

// :흰색_확인_표시: 출력 예시
// [등록 완료] 나비: Photo가 등록되었습니다.
// [파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.
// [등록 오류] 나비: 중복된 사진입니다.
// [등록 완료] 나비: Growth Record가 등록되었습니다.
// [파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.
// [등록 오류] 나비: 중복된 성장 기록입니다.
