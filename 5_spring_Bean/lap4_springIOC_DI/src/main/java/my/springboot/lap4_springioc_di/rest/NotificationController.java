package my.springboot.lap4_springioc_di.rest;

import my.springboot.lap4_springioc_di.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private MessageInterface messageInterface;


    /** Constructor Injection*/
    @Autowired
    public NotificationController(@Qualifier("zaloService") MessageInterface messageInterface) {
        this.messageInterface = messageInterface;
    }



    @GetMapping("/send-msg")
    public String sendMessage() {
        return this.messageInterface.sendMessage();
    }
}
