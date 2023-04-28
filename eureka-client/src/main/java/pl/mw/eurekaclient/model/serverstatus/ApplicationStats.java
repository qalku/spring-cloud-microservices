package pl.mw.eurekaclient.model.serverstatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationStats {
    private ApplicationStats applicationStats;
    private String registeredreplicas;
    private String availablereplicas;
    private String unavailablereplicas;
}
