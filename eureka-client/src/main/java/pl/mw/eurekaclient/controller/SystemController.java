package pl.mw.eurekaclient.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.mw.eurekaclient.model.*;
import pl.mw.eurekaclient.model.instancestatus.Application;
import pl.mw.eurekaclient.model.instancestatus.Applications;
import pl.mw.eurekaclient.model.instancestatus.Instance;
import pl.mw.eurekaclient.model.openapi.ApiPaths;
import pl.mw.eurekaclient.model.openapi.Paths.Pather;
import pl.mw.eurekaclient.model.openapi.StartOpenApi;
import pl.mw.eurekaclient.model.serverstatus.*;
import pl.mw.eurekaclient.service.ApplicationService;
import pl.mw.eurekaclient.service.ServerFunctions;
import pl.mw.eurekaclient.service.ServerService;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import io.swagger.v3.oas.models.OpenAPI;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequiredArgsConstructor
@Tag(name = "Kontrolel Systemowy", description = "Automatyczna aktualizacja danych o systemie z Eureki.")
public class SystemController {
    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    private final ApplicationService applicationService;
    private final ServerService serverService;

    // kolejny informator: eureka/status
    @Operation(summary = "Ukryte załadowanie danych serwera do bazy danych")
    @GetMapping(path = "/server") //, produces = MediaType.APPLICATION_JSON_VALUE
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Server getDaneServer() throws JsonProcessingException {
        ServerFunctions fun=new ServerFunctions(applicationService, serverService);
        return fun.getServers();
    }

    @Operation(summary = "Ukryte załadowanie listy danych aplikacji do bazy")
    @GetMapping(path = "/system", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getDane()  throws JsonProcessingException{
        ServerFunctions fun=new ServerFunctions(applicationService, serverService);
        return fun.getInstances();
    }

}
