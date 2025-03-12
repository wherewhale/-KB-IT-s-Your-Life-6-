// status.js에서 orderStatus와 updateStatus를 import 하세요.
// trackStatus라는 async 함수를 작성하세요.
// await을 사용해 다음 순서로 상태를 순차적으로 업데이트하세요:
// samgyeopsal → '굽는 중'
// samgyeopsal → '완료'
// galbi → '굽는 중'
// galbi → '완료'
// 모든 상태가 업데이트된 후, orderStatus 객체를 출력하세요

import { orderStatus, updateStatus } from './status.mjs';

async function trackStatus() {
  try {
    await updateStatus('samgyeopsal', '굽는 중');
    await updateStatus('samgyeopsal', '완료');
    await updateStatus('galbi', '굽는 중');
    await updateStatus('galbi', '완료');
    console.log(`📋 최종 주문 상태: ${JSON.stringify(orderStatus)}`);
  } catch (error) {
    console.error(error);
  }
}

trackStatus();
