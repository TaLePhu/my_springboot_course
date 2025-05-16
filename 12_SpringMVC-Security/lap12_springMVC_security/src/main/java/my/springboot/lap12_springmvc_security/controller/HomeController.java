package my.springboot.lap12_springmvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping()
    public String homePage(Model model) {
        return "home";
    }
}
