package org.scoula.stock.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    final private StockService service;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("로그 분석", service.getList());
        model.addAttribute("list", service.getList());
        return "stock/list";
    }
}
