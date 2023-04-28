package pl.mw.eurekaclient.model.openapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartOpenApi {
    private StartOpenApi startOpenApi;
    private String openapi;
    private Object info;
    //private ArrayList<ExternalDocs> externalDocs;
    //private ArrayList<ApiServers> servers;
    //private ArrayList<Tags> tags;
    private Object paths;
    //private ArrayList<ApiPaths> paths;
    //private ArrayList<Components> components;
}
