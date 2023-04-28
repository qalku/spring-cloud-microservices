package pl.mw.eurekaclient.model.instancestatus;

import lombok.Getter;
import lombok.Setter;
import pl.mw.eurekaclient.model.App;

import java.util.List;

@Getter
@Setter
public class ReturnDataModel {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;

    private List<App> data;
}
