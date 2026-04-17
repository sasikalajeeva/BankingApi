package com.bank.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        System.out.println("inside web controller");
        return "dashboard"; // JSP page
    }
}