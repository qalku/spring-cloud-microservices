package pl.mw.eurekaclient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String hostName;
    private String instanceId;
    //private String app;
    private String ipAddr;
    private String status;
    private String overriddenstatus;
    private Integer port;
    private Integer securePort;
    private String countryId;

    //private String dataCenterInfo;
    //private String leaseInfo;
    //private String metadata;

    //private String homePageUrl;
    //private String statusPageUrl;
    //private String healthCheckUrl;
    //private String vipAddress;
    //private String secureVipAddress;
    //private String isCoordinatingDiscoveryServer;
    //private String lastUpdatedTimestamp;
    //private String lastDirtyTimestamp;

    private Integer numofcpus;
    private String totalavailmemory;
    private String currentmemoryusage;
    private String serveruptime;

    // applicationStats
}
