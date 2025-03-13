// fs 모듈을 사용하여 현재 프로젝트 디렉터리의 members 폴더 안에 kim_jong_kook.txt 파일을 생성하세요.
// 파일 내용: "김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg"
// path 모듈을 사용하여 아래 정보를 출력하세요.
// 디렉터리 경로 (dirname)
// 파일 이름 (basename)
// 확장자 (extname)
// 확장자를 제외한 파일 이름 (basename 사용)

import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = fileURLToPath(new URL('.', import.meta.url));

let content = `
=================================
김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg
=================================
`;

const newPath = path.join('./members', 'kim_jong_kook.txt');

if (fs.existsSync('./members')) {
  //   console.log('file already exist');
} else {
  fs.mkdirSync('./members');
}

fs.writeFileSync('./members/kim_jong_kook.txt', content, {
  flag: 'a',
  recursive: true,
});
console.log('파일 생성 완료!');

// 디렉터리 경로: members
// 파일 이름: kim_jong_kook.txt
// 파일 확장자: .txt
// 파일 이름(확장자 제외): kim_jong_kook
console.log('디렉터리 경로:', path.dirname(newPath)); // 'members'
console.log('파일 이름:', path.basename(newPath)); // 'kim_jong_kook.txt'
console.log('파일 확장자:', path.extname(newPath)); // '.txt'
console.log('파일 이름(확장자 제외):', path.basename(newPath, '.txt')); // 'kim_jong_kook.txt'
