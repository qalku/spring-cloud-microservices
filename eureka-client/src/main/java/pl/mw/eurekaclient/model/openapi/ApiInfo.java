package pl.mw.eurekaclient.model.openapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiInfo {
    private ApiInfo info;
    private String title;
    private String description;

}
