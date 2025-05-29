package org.scoula.dao;

import org.scoula.domain.TravelImageVO;
import org.scoula.domain.TravelVO;

import java.util.List;
import java.util.Optional;

public interface TravelDao {
    void insert(TravelVO travel);
    //리턴값 없어도 된다. 예외 발생 여부에 따라 다르게 처리하면 되기 때문

    void insertImage(TravelImageVO image);

    int getTotalCount();
    List<String> getDistricts(); // 권역 목록 얻기 (distinct 통해서 권역만 가져오는거)
    List<TravelVO> getTravels(); // 목록 얻기
    List<TravelVO> getTravels(int page); // 페이지별 목록 얻기
    List<TravelVO> getTravels(String district); // 해당 권역의 목록 얻기
    Optional<TravelVO> getTravel(Long no); // 특정 관광지 정보 얻기
}
