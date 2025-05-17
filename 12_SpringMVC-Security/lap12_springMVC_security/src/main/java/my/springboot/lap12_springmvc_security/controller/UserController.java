package my.springboot.lap12_springmvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String homePage(Model model) {
        return "user/home";
    }

}
