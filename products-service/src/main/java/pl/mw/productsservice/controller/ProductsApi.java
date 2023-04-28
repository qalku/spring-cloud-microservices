package pl.mw.productsservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductsApi {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("/products/hello")
    public String hello(){
        return "Hello from ProductsApi";
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
