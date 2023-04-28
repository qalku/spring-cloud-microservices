package pl.mw.eurekaclient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String instanceId;

    private String hostName;

    private String app;
    private String ipAddr;
    private String status;
    private String overriddenstatus;
    private Integer port;
    private Integer secureport;
    private Integer countryId;
    private String homePageUrl;
    private String statusPageUrl;
    private String healthCheckUrl;
    private String vipAddress;
    private String secureVipAddress;
    private String isCoordinatingDiscoveryServer;
    private String actionType;
    private Integer databaseOn;
    private Integer databaseViewOn;
    private String databaseType;
    private String databaseAddress;
    private String databaseUser;
    private String databaseConsole;
    private Integer swaggerApiOn;
    private LocalDateTime created;

}
