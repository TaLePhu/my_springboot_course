package my.springboot.lap4_springioc_di;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface{

    @Override
    public String sendMessage() {
        return "email sending...update";
    }
}
