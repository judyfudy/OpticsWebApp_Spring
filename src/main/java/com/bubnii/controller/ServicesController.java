package com.bubnii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {

    @GetMapping(value = "/services")
    public String allServices() {
        return "services";
    }

    @GetMapping(value = "/consultation")
    public String consultationService() {
        return "consultation_text";
    }

    @GetMapping(value = "/diagnostic")
    public String diagnosticService() {
        return "diagnostic_page";
    }

    @GetMapping(value = "/repair")
    public String repairService() {
        return "repair_page";
    }

}
