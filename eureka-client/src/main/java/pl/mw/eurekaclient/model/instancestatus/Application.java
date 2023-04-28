package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {
    private Application application;
    private String name;
    private ArrayList<Instance> instance;
}
