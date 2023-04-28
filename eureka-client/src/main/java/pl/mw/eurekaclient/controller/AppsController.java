package pl.mw.eurekaclient.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.mw.eurekaclient.model.App;
import pl.mw.eurekaclient.model.instancestatus.ReturnDataModel;
import pl.mw.eurekaclient.service.ApplicationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Kontrolel Aplikacji w Eurece", description = "Zarządzanie mikroserwisami.")
public class AppsController {
    private final ApplicationService applicationService;

    @Operation(summary = "Pobranie listy wszystkich instancji aplikacji")
    @GetMapping(path = "/apps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnDataModel getApps(@RequestParam(required = false) Integer page, Sort.Direction sort) { //List<App>
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        //return applicationService.getAppsWithComments(pageNumber, sortDirection);

        List<App> apps = applicationService.getApps(pageNumber, sortDirection);
        int count = apps.size();

        ReturnDataModel model = new ReturnDataModel();
        model.setData(apps);
        model.setRecordsTotal(count);
        model.setRecordsFiltered(count);

        return model;
    }

    @Operation(summary = "Pobranie danych pojedynczej instancji")
    @GetMapping(path = "/apps/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public App getOneApp(@PathVariable long id) { //List<AppEntity>
        App ret = applicationService.getSingleApp(id);
        if (ret.getDatabaseOn().doubleValue() < 1) {
            ret.setDatabaseOn(0);
        }
        return ret;
    }

    @Operation(summary = "Usuwanie instancji z bazy danych")
    @DeleteMapping("/apps/{id}")
    public void deleteApp(@PathVariable long id) {
        applicationService.deleteApp(id);
    }

}
