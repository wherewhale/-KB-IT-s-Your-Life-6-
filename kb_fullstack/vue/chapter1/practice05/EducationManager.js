import fs from 'fs';

export class EducationManager {
  constructor() {
    this.programs = [];
  }

  registerProgram(program) {
    this.programs.push(program);
    console.log(`[등록 완료] 교육 과정: ${program.name}`);
  }

  completeProgramWithFunction(programName) {
    const program = this.programs.find((p) => p.name === programName);
    program.isCompleted = true;
    console.log(`[이수 완료 - 일반 함수] 교육 과정: ${program.name}`);
  }

  completeProgramWithArrowFunction = (programName) => {
    const program = this.programs.find((p) => p.name === programName);
    program.isCompleted = true;
    console.log(`[이수 완료 - 화살표 함수] 교육 과정: ${program.name}`);
  };

  saveToFile() {
    return new Promise((resolve, reject) => {
      fs.promises
        .writeFile('./education_records.json', JSON.stringify(this.programs))
        .then(() => {
          console.log('[파일 저장 완료] 교육 기록이 파일로 저장되었습니다.');
          resolve();
        });
    });
  }
}
