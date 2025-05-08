package my.springboot.lap4_springioc_di.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface{

    @Override
    public String sendMessage() {
        return "email sending...update";
    }
}
