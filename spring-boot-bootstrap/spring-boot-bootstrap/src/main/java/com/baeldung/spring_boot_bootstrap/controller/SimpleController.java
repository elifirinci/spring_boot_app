package com.baeldung.spring_boot_bootstrap.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    // application.properties içindeki uygulama adını alır
    @Value("${spring.application.name}")
    private String appName;

    // Anasayfa endpoint'i
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName); // HTML'de kullanılmak üzere model'e eklenir
        return "home"; // templates/home.html sayfasını render eder
    }
}
;

