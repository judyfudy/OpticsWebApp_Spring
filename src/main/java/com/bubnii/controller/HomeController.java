package com.bubnii.controller;

import com.bubnii.controller.interceptors.LoggerInterceptor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    /**
     * Handles post request to welcome page (for login and registration)
     *
     * @return logical view name
     */
    @GetMapping(value = "/")
    public String onhome() {
        return "/homePage";
    }

    @PostMapping(value = "/home")
    public String home() {

        return "redirect:/";
    }


}
