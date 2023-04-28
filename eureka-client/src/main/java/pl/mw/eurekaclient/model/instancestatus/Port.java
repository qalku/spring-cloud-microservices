package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Port {
    //"port":{"pxi":8761,"@enabled":"true"}
    private Port port;
    private String pxi;
    private String enabled;
}
