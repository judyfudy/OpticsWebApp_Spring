package com.bubnii.controller;

import com.bubnii.controller.interceptors.LoggerInterceptor;
import com.bubnii.model.Person;
import com.bubnii.service.interfaces.PersonService;
import com.bubnii.utils.HashPasswordUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Autowired
    PersonService personService;

    /**
     * Handles get request to welcome page
     *
     * @return login view
     */

    @GetMapping(value = "/login")
    public String onLogin() {
        return "login";
    }

    /**
     * Handles post request to login person
     *
     * @param username person's username
     * @param password person's password
     * @return status code response
     */

    @PostMapping(value = "/login")
    public @ResponseBody
    ResponseEntity<Object> login(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {

        Person person = null;

        try {
            person = personService.getPersonByCredentials(username);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }

        if (person != null) {

            boolean validPassword = HashPasswordUtil.checkPassword(password, person.getPassword());

            if (validPassword) {

                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession(true); // true == allow create
                session.setAttribute("user", username);
                session.setAttribute("userId", person.getIdPerson());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    /** 
     * Handles get request to log out
     *
     * @return welcome view
     */

    @GetMapping(value = "/logout")
    public String logout() {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create
        session.invalidate();

        return "redirect:/";
    }

}
