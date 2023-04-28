package pl.mw.eurekaclient.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.model.Server;

import java.util.List;

@Repository
public interface ServerRepository extends CrudRepository<Server, Long> {

    @Query("Select p from Server p ")
    List<Server> findAllServers(PageRequest id);

    //@Query("select p from Server p where hostname = :hostname")
    Server findByHostName(String hostname);

}
