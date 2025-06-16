package org.scoula.icecream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.icecream.domain.IcecreamVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamDTO {
    private Long no;
    private String name;
    private String flavor;
    private int price;

    public static IcecreamDTO of(IcecreamVO vo) {
        return vo == null ? null : IcecreamDTO.builder()
                .name(vo.getName())
                .flavor(vo.getFlavor())
                .price(vo.getPrice())
                .build();
    }

    // DTO  VO 변환
    public IcecreamVO toVo() {
        return IcecreamVO.builder()
                .name(name)
                .flavor(flavor)
                .price(price)
                .build();
    }
}

