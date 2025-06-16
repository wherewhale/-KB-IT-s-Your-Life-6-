package org.scoula.stock.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.stock.domain.StockVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDTO {
    private Long no;
    private String stockCode;
    private String stockName;
    private Long price;
    private String description;
    private Date regDate;

    // VO  DTO 변환
    public static StockDTO of(StockVO vo) {

        return vo == null ? null : StockDTO.builder()
                .no(vo.getNo())
                .stockCode(vo.getStockCode())
                .stockName(vo.getStockName())
                .price(vo.getPrice())
                .description(vo.getDescription())
                .regDate(vo.getRegDate())
                .build();
    }

    // DTO  VO 변환

    public StockVO toVo() {
        return StockVO.builder()
                .no(no)
                .stockCode(stockCode)
                .stockName(stockName)
                .price(price)
                .description(description)
                .regDate(regDate)
                .build();
    }
}
