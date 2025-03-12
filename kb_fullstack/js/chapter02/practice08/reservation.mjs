// reserveLargeRoom 함수"✅ 대형 룸이 예약되었습니다."라는 문자열을 반환하세요.
// reserveStandardSeat 함수"✅ 일반석이 예약되었습니다."라는 문자열을 반환하세요.
// getReservation 함수인원 수를 매개변수로 받아서, 5명 이상이면 reserveLargeRoom, 그렇지 않으면 reserveStandardSeat 함수를 반환하세요.
// export로 외부에서 사용할 수 있도록 처리하세요.

const reserveLargeRoom = () => {
  console.log('✅ 대형 룸이 예약되었습니다.');
};

const reserveStandardSeat = () => {
  console.log('✅ 일반석이 예약되었습니다.');
};

export const getReservation = (people) => {
  if (people >= 5) {
    return reserveLargeRoom;
  } else {
    return reserveStandardSeat;
  }
};
