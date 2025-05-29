package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelVO {
    //private 데이터를 불러와서 저장하고 사용하는 방식은 Setter와 getter를 사용
    //만약 csv(DB)와 이름이 다른 컬럼이 있는 경우에는 넘어가기도 함
    private Long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;

    private List<TravelImageVO> images;
}
