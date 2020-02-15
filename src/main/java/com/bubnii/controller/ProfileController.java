package com.bubnii.controller;

import com.bubnii.model.Person;
import com.bubnii.service.interfaces.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private final PersonService personService;

    public ProfileController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String onProfile(final HttpSession session, final Model model) {
        final int userId = (int) session.getAttribute("userId");

        final Person personInfo = personService.get(userId);
        model.addAttribute("personInfo", personInfo);

        return "profile";
    }
}
