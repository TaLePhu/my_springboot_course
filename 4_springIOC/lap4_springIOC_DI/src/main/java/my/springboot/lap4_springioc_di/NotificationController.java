package my.springboot.lap4_springioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private MessageInterface email;

//    @Autowired
//    public NotificationController(MessageInterface email) {
//        this.email = email;
//    }

    @Autowired
    public void setEmail(EmailService email) {
        this.email = email;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        return this.email.sendMessage();
    }
}
