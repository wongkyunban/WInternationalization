package com.wong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeController{

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/index","/home","/"},method = RequestMethod.GET)
    public String getHomePage(Model model, Locale locale) {
        return "home";
    }
}
