package my.springboot.lap12_springmvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

    @GetMapping()
    public String publicPage() {
        return "public/index";
    }
}
