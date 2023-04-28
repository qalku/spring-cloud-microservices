package pl.mw.eurekaclient.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.model.Server;
import pl.mw.eurekaclient.model.instancestatus.Applications;
import pl.mw.eurekaclient.model.instancestatus.ReturnDataModel;
import pl.mw.eurekaclient.model.serverstatus.GatewayModel;
import pl.mw.eurekaclient.model.serverstatus.ServerDataModel;
import pl.mw.eurekaclient.service.ServerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Kontrolel Serwerów", description = "Zarządzanie zidentyfikowanymi serwerami.")
public class ServerController {
    private final ServerService serverService;
    private RestTemplate restTemplate = new RestTemplate();         // klient http RestTemplate

    @Operation(summary = "Pobranie listy wszystkich zarejestrowanych serwerów")
    @GetMapping(path = "/machines", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerDataModel getServers(@RequestParam(required = false) Integer page, Sort.Direction sort) { //List<App>
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        //return applicationService.getAppsWithComments(pageNumber, sortDirection);

        List<Server> apps = serverService.getMachines(pageNumber, sortDirection);
        int count = apps.size();

        ServerDataModel model = new ServerDataModel();
        model.setData(apps);
        model.setRecordsTotal(count);
        model.setRecordsFiltered(count);

        return model;
    }

    @Operation(summary = "Pobranie danych serwera po ID")
    @GetMapping(path = "/machines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Server getServer(@PathVariable long id) {
        Server ret = serverService.getSingleServer(id);
        return ret;
    }

    @Operation(summary = "Pobranie danych serwera po Nazwie [QalkuW10]")
    @GetMapping(path = "/machines/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Server getServerName(@PathVariable String name) {
        Server ret = serverService.getSingleServerByName(name);
        return ret;
    }

    @Operation(summary = "Pobranie danych serwera po ID")
    @GetMapping(path = "/machines/gateway/routes")//, produces = MediaType.APPLICATION_JSON_VALUE
    public String getGatewayRoute() {

        String dane = restTemplate.getForObject("http://localhost:8080/actuator/gateway/routes", String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        String zwrot="<table width=100%>";
        try {
            GatewayModel[] gatewayModels = mapper.readValue(dane, GatewayModel[].class);
            int i=0;
            for (GatewayModel gs : gatewayModels) {
                i++;
                String predicate = gs.getPredicate();
                String uri = gs.getUri();
                System.out.println("P: " + predicate + ", URI: " + uri);
                zwrot=zwrot+"<tr><td>"+i+"</td><td>"+uri+"</td><td>"+predicate+"</td></tr>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zwrot=zwrot+"</table>";

        return zwrot;
    }


}
