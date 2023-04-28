package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Applications {
   private Applications applications;
   private String versions__delta;
   private String apps__hashcode;
   private ArrayList<Application> application;
}
