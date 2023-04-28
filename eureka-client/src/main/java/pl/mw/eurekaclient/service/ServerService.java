package pl.mw.eurekaclient.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.model.Server;
import pl.mw.eurekaclient.repository.ServerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerService {

    private static final int PAGE_SIZE = 20;
    private final ServerRepository serverRepository;


    public Server addServer(Server server) {
        return serverRepository.save(server);
    }

    public List<Server> getMachines(int pageNumber, Sort.Direction sortDirection) {
        return serverRepository.findAllServers(
                PageRequest.of(pageNumber, PAGE_SIZE,
                        Sort.by(sortDirection, "id")
                )
        );
    }

    @Transactional
    public Server editServer(Server server) {
        Server serverEdited = serverRepository.findById(server.getId()).orElseThrow();
        serverEdited.setHostName(server.getHostName());
        serverEdited.setCountryId(server.getCountryId());
        serverEdited.setInstanceId(server.getInstanceId());
        serverEdited.setIpAddr(server.getIpAddr());
        serverEdited.setNumofcpus(server.getNumofcpus());
        serverEdited.setServeruptime(server.getServeruptime());
        serverEdited.setStatus(server.getStatus());
        serverEdited.setTotalavailmemory(server.getTotalavailmemory());

        return serverEdited;
    }

    public Long getServerIdByName(String hostname) {
        Server server = serverRepository.findByHostName(hostname);
        return server.getId();
    }

    public Server getSingleServer(long id) {
        return serverRepository.findById(id)
                .orElseThrow();
    }

    public Server getSingleServerByName(String hostName) {
        return serverRepository.findByHostName(hostName);
    }
}
