package org.scoula.icecream.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
})
@Log4j2
class IcecreamControllerTest {
    @Autowired
    IcecreamService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void create() throws Exception {
        String resultPage = mockMvc.perform(
                        MockMvcRequestBuilders.post("/icecream/new")
                                .param("name", "테스트아이스")
                                .param("flavor", "테스트하는 것 만큼 답답하고 어지러운 맛")
                                .param("price", "5252")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }


}
