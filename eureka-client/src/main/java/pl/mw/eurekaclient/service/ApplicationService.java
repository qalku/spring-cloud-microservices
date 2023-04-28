package pl.mw.eurekaclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.repository.AppRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ApplicationService {

    private static final int PAGE_SIZE=20;
    private final AppRepository appRepository;

    //@Cacheable(cacheNames = "Apps")
    public List<App> getApps(int page, Sort.Direction sort){
        //return postRepository.findAllPosts(PageRequest.of(page,PAGE_SIZE, Sort.by(Sort.Order.asc("id"),Sort.Order.desc("created"))));
        return appRepository.findAllApps(
                PageRequest.of(page,PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        ); //<< stronicowanie i sortowanie
    }

    public Long getAppIdByName(String name) {
        App app=appRepository.findByName(name);
        return app.getId();
    }

    //@Cacheable(cacheNames = "SingleApps", key = "#id")
    public App getSingleApp(long id) {
        return appRepository.findById(id)
                .orElseThrow();
    }

    //@Cacheable(cacheNames = "AppsWithComments")
    public List<App> getAppsWithComments(int pageNumber, Sort.Direction sort) {
        List<App> allApps = appRepository.findAllApps(
                PageRequest.of(pageNumber,PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
        //wyciagniecie id z postow
        List<Long> ids = allApps.stream()
                .map(App::getId) //.map(post -> post.getId())
                .collect(Collectors.toList());
        // na podstawie id pobrac zależności przez repository komentarzy
        //--List<Comment> comments = commentRepository.findAllByAppIdIn(ids);
        //--allApps.forEach(post -> app.setComment(extractComments(comments,app.getId())));

        return allApps;
    }
/*
    private List<Comment> extractComments(List<Comment> comments, long id) {
        // przefiltrowane komentarze ktore naleza do tego posta
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
*/
    @Transactional
    public App addApp(App app) {
        return appRepository.save(app);
    }

    @Transactional                                                  // do jednej transakcji zapytania hibernate z metody
    //@CachePut(cacheNames = "SingleApp",key = "#result.id")         // adnotacja do cachowania edycji
    public App editApp(App app) {
        // zabezpieczenie przed brakiem id w post i aktualizacja tylko wybranych pól
        App appEdited = appRepository.findById(app.getId()).orElseThrow();
        appEdited.setName(app.getName());
        appEdited.setInstanceId(app.getInstanceId());
        appEdited.setHostName(app.getHostName());
        appEdited.setApp(app.getApp());
        appEdited.setIpAddr(app.getIpAddr());
        appEdited.setStatus(app.getStatus());
        appEdited.setOverriddenstatus(app.getOverriddenstatus());
        appEdited.setPort(app.getPort());
        appEdited.setSecureport(app.getSecureport());
        appEdited.setCountryId(app.getCountryId());
        appEdited.setHomePageUrl(app.getHomePageUrl());
        appEdited.setVipAddress(app.getVipAddress());
        appEdited.setSecureVipAddress(app.getSecureVipAddress());
        appEdited.setIsCoordinatingDiscoveryServer(app.getIsCoordinatingDiscoveryServer());

        appEdited.setDatabaseType(app.getDatabaseType());
        appEdited.setDatabaseAddress(app.getDatabaseAddress());
        appEdited.setDatabaseUser(app.getDatabaseUser());
        appEdited.setDatabaseOn(app.getDatabaseOn());
        appEdited.setDatabaseViewOn(app.getDatabaseViewOn());
        appEdited.setDatabaseConsole(app.getDatabaseConsole());

        appEdited.setSwaggerApiOn(app.getSwaggerApiOn());

        return appEdited;
    }

                         // automatyczne usuwanie z cache'a przy usuwaniu
    public void deleteApp(long id) {
        appRepository.deleteById(id);
    }

    // usuwanie calosci cascha
    //@CacheEvict(cacheNames = "PostWithComments")
    public void clearAppWithComments(){

    }

    public void setStatusyDown() {
        appRepository.setDown("DOWN");
    }
}
