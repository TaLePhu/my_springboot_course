package my.springboot.lap4_springioc_di.rest;

import my.springboot.lap4_springioc_di.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyController2 {

    private MessageInterface emailService;
    private MessageInterface zaloService;
    private MessageInterface smsService;

    @Autowired
    public NotifyController2(
            @Qualifier("emailService") MessageInterface emailService,
            @Qualifier("zaloService") MessageInterface zaloService,
            @Qualifier("smsService") MessageInterface smsService
    ) {
        this.emailService = emailService;
        this.zaloService = zaloService;
        this.smsService = smsService;
    }

    @GetMapping("email")
    public String sendEmail() {
        return this.emailService.sendMessage();
    }

    @GetMapping("zalo")
    public String sendZalo() {
        return this.zaloService.sendMessage();
    }

    @GetMapping("sms")
    public String sendSms() {
        return this.smsService.sendMessage();
    }

}
