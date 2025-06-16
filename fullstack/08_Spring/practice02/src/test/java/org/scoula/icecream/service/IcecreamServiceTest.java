package org.scoula.icecream.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j2
class IcecreamServiceTest {
    @Autowired
    private IcecreamService service;

    @Test
    public void create() {
        IcecreamDTO icecream = new IcecreamDTO();
        icecream.setName("테스트아이스");
        icecream.setFlavor("테스트하는 것 만큼 답답하고 어지러운 맛");
        icecream.setPrice(5252);

        service.create(icecream);

        log.info("생성된 게시물의 번호: " + icecream.getNo());
    }
}