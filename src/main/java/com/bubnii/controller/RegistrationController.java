package com.bubnii.controller;

import com.bubnii.controller.interceptors.LoggerInterceptor;
import com.bubnii.enums.PersonType;
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
public class RegistrationController {
    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Autowired
    PersonService personService;

    /**
     * Handles get request to registration view
     *
     * @return registration view
     */
    @GetMapping(value = "/registration")
    public String onRegistration() {
        return "registration";
    }

    /**
     * Handles post request to registration
     *
     * @param firstName person's first name
     * @param lastName  person's last name
     * @param username  person's username
     * @param password  person's password
     * @return status code response
     */
    @PostMapping(value = "/registration")
    public @ResponseBody
    ResponseEntity<Object> register(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("email") String email) {

        Person person = personService.getPersonByCredentials(username);

        String securePassword = HashPasswordUtil.hashPassword(password);

        if (person == null) {

            person = new Person(username, securePassword, firstName, lastName, email, PersonType.USER);

            try {
                personService.add(person);
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
            }
            person = personService.getPersonByCredentials(username);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); // true == allow create
            session.setAttribute("user", username);
            session.setAttribute("userId", person.getIdPerson());

            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

    }
}
