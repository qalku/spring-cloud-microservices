package pl.mw.eurekaclient.model.serverstatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralStats {
    private GeneralStats generalStats;
    private Integer numofcpus;
    private String totalavailmemory;
    private String currentmemoryusage;
    private String serveruptime;

}
