package pl.mw.userservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @GetMapping("/users/hello")
    public String hello(){
        return "Hello from UserApi";
    }

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("/service/payments")
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        int port = webServerAppCtxt.getWebServer().getPort();
        String ipAddress = httpServletRequest.getRemoteAddr();

        String projectUrl="http://"+ipAddress+":"+port+"/swagger-ui/index.html";
        httpServletResponse.setHeader("Location", projectUrl);
        httpServletResponse.setStatus(302);
    }
}