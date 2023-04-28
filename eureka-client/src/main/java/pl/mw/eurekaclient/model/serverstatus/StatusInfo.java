package pl.mw.eurekaclient.model.serverstatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusInfo {
   private StatusInfo statusInfo;
   private ArrayList<GeneralStats> generalStats;
   private ArrayList<ApplicationStats> applicationStats;
   private ArrayList<InstanceInfo> instanceInfo;
}
