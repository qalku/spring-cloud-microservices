package pl.mw.eurekaclient.model.instancestatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Item item;
    private Applications applications;
}
