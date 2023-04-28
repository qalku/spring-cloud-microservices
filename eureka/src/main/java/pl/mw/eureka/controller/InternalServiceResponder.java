package pl.mw.eureka.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternalServiceResponder {
    private String appName;
    private String datasourceUrl;
    private String driverClassName;
    private String h2console;
    private String h2path;
    private String username;
}
