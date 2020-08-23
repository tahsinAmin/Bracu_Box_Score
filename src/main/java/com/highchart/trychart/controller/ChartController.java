package com.highchart.trychart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ChartController {

    @RequestMapping("/charts")
    public String charts(Map<String, Object> model) {
        return "charts";
    }
}
