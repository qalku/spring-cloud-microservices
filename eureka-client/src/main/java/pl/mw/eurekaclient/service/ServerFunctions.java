package pl.mw.eurekaclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import pl.mw.eurekaclient.controller.SystemController;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.model.Server;
import pl.mw.eurekaclient.model.instancestatus.Application;
import pl.mw.eurekaclient.model.instancestatus.Applications;
import pl.mw.eurekaclient.model.instancestatus.Instance;
import pl.mw.eurekaclient.model.openapi.StartOpenApi;
import pl.mw.eurekaclient.model.serverstatus.ApplicationStats;
import pl.mw.eurekaclient.model.serverstatus.GeneralStats;
import pl.mw.eurekaclient.model.serverstatus.InstanceInfo;
import pl.mw.eurekaclient.model.serverstatus.StatusInfo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RequiredArgsConstructor
public class ServerFunctions {
    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);
    @Autowired
    private DiscoveryClient discoveryClient;
    private RestTemplate restTemplate = new RestTemplate();         // klient http RestTemplate
    private ApplicationService applicationService;
    private ServerService serverService;


    public ServerFunctions(ApplicationService applicationService, ServerService serverService) {
        this.applicationService=applicationService;
        this.serverService=serverService;
    }

    public Server getServers() throws JsonProcessingException{
        String dane = restTemplate.getForObject("http://127.0.0.1:8761/eureka/status/", String.class);
        dane = dane.replaceAll("com.netflix.appinfo.InstanceInfo\\$DefaultDataCenterInfo", "DefaultDataCenterInfo");
        dane = dane.replaceAll("com.netflix.eureka.util.StatusInfo", "statusInfo");
        dane = dane.replaceAll("management.port", "managementport");
        //dane=dane.replaceAll("@","");
        dane = dane.replaceAll("-", "");
        dane = dane.replaceAll("\\$", "pxi");
        dane = dane.replaceAll("class", "classi");
        dane = dane.replaceAll("<availablereplicas></availablereplicas>", "<availablereplicas>0</availablereplicas>");

        String dane2 = "" + convertXmlToJson2(dane) + "";
        dane2 = dane2.replaceAll("\"\":", "\"W\":");

        //System.out.println(" >> "+dane2);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        Server server = new Server();

        try {
            StatusInfo[] map = mapper.readValue(dane2, StatusInfo[].class);
            for (StatusInfo status : map) {


                server = new Server();

                GeneralStats generalStats = status.getGeneralStats().get(0);
                ApplicationStats applicationStats = status.getApplicationStats().get(0);
                InstanceInfo instanceInfo = status.getInstanceInfo().get(0);

                String hostName = instanceInfo.getHostName();

                Long id = 0L;
                try {
                    id = serverService.getServerIdByName(hostName);
                    if (id > 0) {
                        server.setId(id);
                    }
                } catch (Exception e) {
                }


                server.setNumofcpus(parseInt(String.valueOf(generalStats.getNumofcpus())));
                server.setTotalavailmemory(generalStats.getTotalavailmemory());
                server.setCurrentmemoryusage(generalStats.getCurrentmemoryusage());
                server.setServeruptime(generalStats.getServeruptime());

                server.setInstanceId(instanceInfo.getInstanceId());
                server.setHostName(hostName);
                server.setIpAddr(instanceInfo.getIpAddr());
                server.setStatus(instanceInfo.getStatus());
                server.setOverriddenstatus(instanceInfo.getOverriddenstatus());
                server.setCountryId(instanceInfo.getCountryId());

                if (id > 0) {
                    serverService.editServer(server);
                } else {
                    serverService.addServer(server);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server;
    }

    public String getInstances() throws JsonProcessingException {
        applicationService.setStatusyDown();
        getServers();

        String dane = restTemplate.getForObject("http://localhost:8761/eureka/apps/", String.class);
        dane = dane.replaceAll("management.port", "managementport");
        dane = dane.replaceAll("@", "");
        dane = dane.replaceAll("\\$", "pxi");
        dane = dane.replaceAll("class", "classi");
        dane = "[" + dane + "]";
        logger.info("ZWROT: " + dane);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // 1. convert JSON array to Array objects
        Applications[] map = mapper.readValue(dane, Applications[].class);
        for (Applications applications : map) {

            int ileAplikacji = applications.getApplications().getApplication().size();

            for (int i = 0; i < ileAplikacji; i++) {
                Application application = applications.getApplications().getApplication().get(i);
                String name = application.getName();

                Instance instance = application.getInstance().get(0);
                String instanceId = instance.getInstanceId();
                String app = instance.getApp();

                Long id = 0L;
                App apka = new App();

                try {
                    id = applicationService.getAppIdByName(name);
                    if (id > 0) {
                        apka.setId(id);
                    }
                } catch (Exception e) {
                }

                String port = instance.getPort().getPxi();
                String secureport = instance.getSecurePort().getPxi();

                //System.out.println(name+" >> "+instance.getStatus());

                apka.setName(name);
                apka.setInstanceId(instanceId);
                apka.setHostName(instance.getHostName());
                apka.setApp("" + instance.getApp());
                apka.setIpAddr(instance.getIpAddr());
                apka.setStatus(instance.getStatus());
                apka.setOverriddenstatus(instance.getOverriddenstatus());
                apka.setPort(parseInt(port));
                apka.setSecureport(parseInt(secureport));
                apka.setCountryId(parseInt(instance.getCountryId()));
                apka.setHomePageUrl(instance.getHomePageUrl());
                apka.setStatusPageUrl(instance.getStatusPageUrl());
                apka.setHealthCheckUrl(instance.getHealthCheckUrl());

                apka.setVipAddress(instance.getVipAddress());
                apka.setSecureVipAddress(instance.getSecureVipAddress());
                apka.setIsCoordinatingDiscoveryServer(instance.getIsCoordinatingDiscoveryServer());
                apka.setActionType(instance.getActionType());


                // konfiguracje bazodanowe
                String adres = instance.getHomePageUrl() + "services/configs";
                //System.out.println("Adres: "+adres);
                try {
                    String configs = restTemplate.getForObject(adres, String.class);
                    ObjectMapper mapperConfig = new ObjectMapper();
                    mapperConfig.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                    Map<String, String> inConf = mapperConfig.readValue(configs, Map.class);

                    String appName = inConf.get("appName");
                    String driver = inConf.get("driverClassName");
                    String hConsole = inConf.get("h2console");
                    String dbAdress = inConf.get("datasourceUrl");
                    String user = inConf.get("username");
                    String hpath = inConf.get("h2path");

                    //System.out.println(appName+" >>>>>>>>>>>>>>> "+driver+", hConsole: "+hConsole+", adres: "+dbAdress+", h2Path: "+hpath);

                    apka.setDatabaseOn(1);
                    apka.setDatabaseAddress(dbAdress);
                    apka.setDatabaseUser(user);
                    apka.setDatabaseConsole(hpath);

                    if (driver.equals("org.h2.Driver")) {
                        apka.setDatabaseType("H2");
                    } else if (driver.equals("org.hibernate.dialect.MySQL5InnoDBDialect")) {
                        apka.setDatabaseType("MYSQL");
                    } else if (driver.equals("org.hibernate.dialect.PostgreSQLDialect")) {
                        apka.setDatabaseType("PostgreSQL");
                    } else {
                        apka.setDatabaseType("");
                    }
                    try {
                        if (hConsole.equals("true")) {
                            apka.setDatabaseViewOn(1);
                        } else {
                            apka.setDatabaseViewOn(0);
                        }
                    } catch (Exception j) {
                        apka.setDatabaseViewOn(0);
                    }

                } catch (Exception u) {
                    //u.printStackTrace();
                    apka.setDatabaseOn(0);
                    apka.setDatabaseViewOn(0);
                }

                // swagger api
                int swagger = 0;
                try {
                    String linkSwagger = instance.getHomePageUrl() + "v3/api-docs";
                    String swaggerControl = swaggerControl(linkSwagger);
                    swagger = 1;
                } catch (Exception u) {
                }

                apka.setSwaggerApiOn(swagger);

                apka.setCreated(LocalDateTime.now());

                if (id > 0) {
                    applicationService.editApp(apka);
                } else {
                    applicationService.addApp(apka);
                }
            }

        }
        return dane;
    }






    public String convertXmlToJson2(String xml) {
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode;
        try {
            jsonNode = xmlMapper.readTree(xml.getBytes());
            ObjectMapper objMapper = new ObjectMapper();
            objMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            objMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            objMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            return objMapper.writeValueAsString(jsonNode);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String swaggerControl(String link) {
        //System.out.println("LINK SWAGGER: "+link);
        String dane = restTemplate.getForObject(link, String.class);
        //System.out.println("DANE: "+dane);

        dane = dane.replaceAll("/", "");
        dane = dane.replaceAll("\\*", "");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        try {
            StartOpenApi[] map = mapper.readValue("[" + dane + "]", StartOpenApi[].class);
            for (StartOpenApi apis : map) {


                String ver = apis.getOpenapi();
                //System.out.println("version: "+ver);
                Object pathx = apis.getPaths();
                String daneX = "[" + pathx + "]";
                //System.out.println(">>>> "+daneX);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
/*
    public List<ServiceInstance> getApplications() {

        List<String> services = this.discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
        services.forEach(serviceName -> {
            this.discoveryClient.getInstances(serviceName).forEach(instance -> {
                instances.add(instance);
            });
        });
        return instances;
    }
 */
}
