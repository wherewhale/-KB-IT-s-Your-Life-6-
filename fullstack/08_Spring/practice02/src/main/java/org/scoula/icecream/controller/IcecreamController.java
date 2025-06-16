package org.scoula.icecream.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/icecream")
@RequiredArgsConstructor
public class IcecreamController {
    final private IcecreamService service;

    @PostMapping("/new")
    public String create(IcecreamDTO icecream) {
        service.create(icecream);
        log.info("create: " + icecream);
        return "redirect:/icecream/list";
    }
}
