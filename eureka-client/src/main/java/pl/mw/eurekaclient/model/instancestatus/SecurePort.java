package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurePort {
    //"securePort":{"$":443,"@enabled":"false"}
    private SecurePort securePort;
    private String pxi;
    private String enabled;
}
