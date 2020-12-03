package ru.max.spring_security_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Serov Maxim
 */
@Controller
public class ControllerUser {
    @GetMapping("/")
    public String getInfoAllUsers() {
        return "show_users";
    }

    @GetMapping("/hr_info")
    public String getInfoForHR() {
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoForManagers() {
        return "view_for_managers";
    }
}
