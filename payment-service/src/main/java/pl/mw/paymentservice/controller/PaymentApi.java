package pl.mw.paymentservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentApi {

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    // z gita config:
    @Value("${app.user}")
    private String appUser;


    @GetMapping("/payments/hello")
    public String hello(){
        return "Hello from PaymentApi - instanceId: "+instanceId+" / appUser: "+appUser;
    }

    @GetMapping("/payments")
    public String starter(){
        return "Start PaymentApi - instanceId: "+instanceId+" / appUser: "+appUser;
    }

    @GetMapping("/service/payments")
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        int port = webServerAppCtxt.getWebServer().getPort();
        String ipAddress = httpServletRequest.getRemoteAddr();

        String projectUrl="http://"+ipAddress+":"+port+"/swagger-ui/index.html";
        httpServletResponse.setHeader("Location", projectUrl);
        httpServletResponse.setStatus(302);
    }
}
