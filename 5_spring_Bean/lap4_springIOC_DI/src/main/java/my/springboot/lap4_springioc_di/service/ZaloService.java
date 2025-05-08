package my.springboot.lap4_springioc_di.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface{
    @Override
    public String sendMessage() {
        return "Zalo sending...";
    }
}
