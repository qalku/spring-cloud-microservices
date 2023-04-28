package pl.mw.eurekaclient.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mw.eurekaclient.model.App;

import java.util.List;

@Repository
public interface AppRepository extends CrudRepository<App, Long> {

    @Query("select p from App p where name = :title")
        //List<Post> findAllByTitle(String title);
    List<App> findAllByTitle(@Param("title") String title);

    // problem n+1
    @Query("Select p from App p ")
    List<App> findAllApps(Pageable page); // << stronicowanie Pageable //"left join fetch p.comment")

    @Query("select p from App p where name = :name")
    App findByName(String name);

    @Modifying
    @Transactional
    @Query("update App set status = :status ")
    void setDown(String status);
}
