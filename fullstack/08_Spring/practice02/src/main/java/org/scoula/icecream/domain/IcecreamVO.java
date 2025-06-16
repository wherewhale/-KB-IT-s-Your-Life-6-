package org.scoula.icecream.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamVO {
//    - 아이스크림 이름(name)
//- 맛 설명(flavor)
//- 가격(price)
    private Long no;
    private String name;
    private String flavor;
    private int price;
}
