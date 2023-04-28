package pl.mw.userservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Serwis Wewnetrzny", description = "Metryczka konfiguracji aplikacji.")
public class InternalServiceController {

    @Autowired
    private Environment env;

    @Operation(summary = "Ukryte załadowanie listy danych aplikacji do bazy")
    @GetMapping(path="/services/configs",produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public InternalServiceResponder getDane() throws JsonProcessingException {
        String appName=env.getProperty("spring.application.name");

        String datasourceUrl = env.getProperty("spring.datasource.url");
        String driverClassName = env.getProperty("spring.datasource.driverClassName");
        String username = env.getProperty("spring.datasource.username");

        String h2console = env.getProperty("spring.h2.console.enabled");
        String h2path = env.getProperty("spring.h2.console.path");

        InternalServiceResponder isp = new InternalServiceResponder();
        isp.setAppName(appName);
        isp.setDatasourceUrl(datasourceUrl);
        isp.setDriverClassName(driverClassName);
        isp.setH2console(h2console);
        isp.setH2path(h2path);
        isp.setUsername(username);

        return isp;
    }
}
