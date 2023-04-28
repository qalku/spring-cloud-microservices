package pl.mw.eurekaclient.model.serverstatus;

import lombok.Getter;
import lombok.Setter;
import pl.mw.eurekaclient.model.Server;

import java.util.List;

@Getter
@Setter
public class ServerDataModel {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<Server> data;
}
