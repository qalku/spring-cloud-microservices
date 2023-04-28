package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instance {
    private Instance instance;
    private String instanceId;
    private String hostName;
    private String app;
    private String ipAddr;
    private String status;
    private String overriddenstatus;
    private Port port;
    private SecurePort securePort;
    private String countryId;
    //private ArrayList<DataCenterInfo> dataCenterInfo;
    //private ArrayList<LeaseInfo> leaseInfo;
    //private ArrayList<Metadata> metadata;
    private String homePageUrl;
    private String statusPageUrl;
    private String healthCheckUrl;
    private String vipAddress;
    private String secureVipAddress;
    private String isCoordinatingDiscoveryServer;
    private String lastUpdatedTimestamp;
    private String lastDirtyTimestamp;
    private String actionType;

}
