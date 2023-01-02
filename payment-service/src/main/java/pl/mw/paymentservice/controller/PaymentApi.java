package pl.mw.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentApi {
    @GetMapping("/hello")
    public String hello(){
        return "Hello from PaymentApi";
    }
}
