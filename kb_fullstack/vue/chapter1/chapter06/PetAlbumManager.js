import fs from 'fs';

export class PetAlbumManager {
  constructor() {
    this.records = [];
  }
  async addRecord(record) {
    // 중복된 사진 파일 경로나 성장 기록 날짜는 중복 등록이 불가능하도록 처리하세요.
    const isDuplicate = this.records.some((r) => {
      if (record.type === 'Photo') {
        return r.type === 'Photo' && r.photoPath === record.photoPath;
      }
      if (record.type === 'Growth Record') {
        return r.type === 'Growth Record' && r.recordDate === record.recordDate;
      }
      return false;
    });

    if (isDuplicate) {
      console.log(
        `[등록 오류] ${record.name}: 중복된 ${
          record.type === 'Photo' ? '사진' : '성장 기록'
        }입니다.`
      );
      return;
    } else {
      this.records.push(record);
      try {
        if (record.type === 'Photo') {
          console.log(
            `[등록 완료] ${record.name}: ${record.type}가 등록되었습니다.`
          );
        } else {
          console.log(
            `[등록 완료] ${record.name}: ${record.type}이 등록되었습니다.`
          );
        }
        console.log(await this.saveRecordsToFile());
      } catch (err) {
        console.error('pet_album.json 저장 실패:', err);
      }
    }
  }

  async saveRecordsToFile() {
    return await new Promise((resolve, reject) => {
      fs.promises
        .writeFile('./pet_album.json', JSON.stringify(this.records), 'utf8')
        .then(() => {
          resolve('[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.');
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
}
