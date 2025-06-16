package org.scoula.icecream.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class IcecreamServiceImpl implements IcecreamService {
    final private IcecreamMapper mapper;

    @Override
    public void create(IcecreamDTO icecream) {
        log.info("생성 : " + icecream);
        IcecreamVO vo = icecream.toVo();
        mapper.create(vo);
        icecream.setNo(vo.getNo());
    }
}
