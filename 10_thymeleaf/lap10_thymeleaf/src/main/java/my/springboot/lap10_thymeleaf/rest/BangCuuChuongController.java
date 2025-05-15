package my.springboot.lap10_thymeleaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BangCuuChuongController {


    @GetMapping("hien-thi/{x}")
    public String hienThiBangCuuChuong(@PathVariable int x, Model model) {
        model.addAttribute("number", x);
        //return ten file thymeleaf
        return "bang-cuu-chuong";
    }


}
