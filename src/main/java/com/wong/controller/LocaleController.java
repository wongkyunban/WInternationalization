package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {

    @GetMapping("/locale")
    public String localeHandler(HttpServletRequest request){
        String lastUrl = request.getHeader("referer");
        return "redirect:"+lastUrl;
    }
}
