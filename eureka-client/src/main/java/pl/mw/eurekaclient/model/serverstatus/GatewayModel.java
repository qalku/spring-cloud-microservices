package pl.mw.eurekaclient.model.serverstatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayModel {
    private GatewayModel gatewayModel;
    private String predicate;
    private String uri;

}
