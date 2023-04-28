
function btnContent(key){
    icon="";
    switch(key){
        case "beans":
            icon="icons16x16/bin.png";
            break;
        case "caches-cache":
            icon="icons16x16/tag_blue.png";
            break;
        case "cache":
            icon="icons16x16/database_save.png";
            break;
        case "health-path":
            icon="icons16x16/details.gif";
            break;
        case "health":
            icon="icons16x16/page_gear.png";
            break;
        case "info":
            icon="icons16x16/information.png";
            break;
        case "conditions":
            icon="icons16x16/server_lightning.png";
            break;
        case "shutdown":
            icon="icons16x16/stop.png";
            break;
        case "configprops":
            icon="icons16x16/settings.gif";
            break;
        case "configprops-prefix":
            icon="icons16x16/settings.gif";
            break;
        case "env":
            icon="icons16x16/settings.gif";
            break;
        case "env-toMatch":
            icon="icons16x16/settings.gif";
            break;
        case "integrationgraph":
            icon="icons16x16/book_addresses.png";
            break;
        case "loggers":
            icon="icons16x16/report.png";
            break;
        case "loggers-name":
            icon="icons16x16/report_magnify.png";
            break;
        case "heapdump":
            icon="icons16x16/wand.png";
            break;
        case "metrics-name":
            icon="icons16x16/text_columns.png";
            break;
        case "metrics":
            icon="icons16x16/text_list_numbers.png";
            break;
        case "scheduledtasks":
            icon="icons16x16/clock.png";
            break;
        case "mappings":
            icon="icons16x16/chart_organisation.png";
            break;
        case "refresh":
            icon="icons16x16/arrow_refresh.png";
            break;
        case "restart":
            icon="icons16x16/page_refresh.png";
            break;
        case "pause":
            icon="icons16x16/page_white_delete.png";
            break;
        case "resume":
            icon="icons16x16/arrow_refresh.png";
            break;
        case "features":
            icon="icons16x16/plugin.gif";
            break;
        case "serviceregistry":
            icon="icons16x16/page_white_visualstudio.png";
            break;
        default:
            icon="icons16x16/help.png";
    }
    document.getElementById("btnContent"+key).innerHTML="<img src='/images/"+icon+"' height=16>";
}


function getTooltipInfo(key){
    var txt="";
    if(key=='beans'){ txt="Wyświetla wszystkie dostępne ziarna w naszej BeanFactory. Nie obsługuje filtrowania."; }
    if(key=='caches-cache'){ txt=""; }
    if(key=='caches'){ txt="Ujawnia dostępne pamięci podręczne."; }
    if(key=='health-path'){ txt=""; }
    if(key=='health'){ txt="Health podsumowuje stan naszej aplikacji."; }
    if(key=='info'){ txt="Info zwraca ogólne informacje. Mogą to być dane niestandardowe, informacje o kompilacji lub szczegóły dotyczące najnowszego zatwierdzenia."; }
    if(key=='conditions'){ txt="Conditions, wcześniej znany jako autoconfig, tworzy raport warunków dotyczących automatycznej konfiguracji."; }
    if(key=='shutdown'){ txt="Shutdown wykonuje płynne zamknięcie aplikacji."; }
    if(key=='configprops'){ txt="Pozwala pobrać wszystkie ConfigurationProperties fasoli."; }
    if(key=='configprops-prefix'){ txt=""; }
    if(key=='env'){ txt="Env zwraca bieżące właściwości środowiska. Dodatkowo możemy pobrać pojedyncze właściwości."; }
    if(key=='env-toMatch'){ txt=""; }
    if(key=='integrationgraph'){ txt="Przedstawia wykres integracji Springa. Wymaga zależności od Spring-integration-core."; }
    if(key=='loggers'){ txt="Loggers umożliwia wysyłanie zapytań i modyfikowanie poziomu logowania naszej aplikacji."; }
    if(key=='loggers-name'){ txt=""; }
    if(key=='heapdump'){ txt="Heapdump buduje i zwraca zrzut sterty z maszyny JVM używanej przez naszą aplikację."; }
    if(key=='metrics-name'){ txt="Metrics, szczegóły metryki naszej aplikacji. Może to obejmować zarówno metryki ogólne, jak i niestandardowe."; }
    if(key=='metrics'){ txt="Pokazuje informacje o metrykach dla bieżącej aplikacji. Domyślnie jest wrażliwy."; }
    if(key=='scheduledtasks'){ txt="Scheduledtasks zawiera szczegółowe informacje o każdym zaplanowanym zadaniu w naszej aplikacji."; }
    if(key=='mappings'){ txt="Wyświetla posortowaną listę wszystkich ścieżek RequestMapping."; }
    if(key=='refresh'){ txt=""; }
    if(key=='restart'){ txt=""; }
    if(key=='pause'){ txt=""; }
    if(key=='resume'){ txt=""; }
    if(key=='features'){ txt=""; }
    if(key=='serviceregistry'){ txt=""; }

    if(key=='trace'){ txt="Trace wyświetla informacje o śledzeniu (domyślnie kilka ostatnich żądań HTTP)."; }
    if(key=='httptrace'){ txt="Wyświetla informacje o ruchu w aplikacji, podobny do trace znanego z poprzedniej wersji Actuatora. Teraz jednak jest bardziej skondensowany (zawiera tylko kluczowe dane http)."; }

    if(key=='threaddump'){ txt="Threaddump zrzuca informacje o wątku bazowej maszyny JVM."; }
    if(key=='logfile'){ txt="Wyświetla logi w przeglądarce jeśli została zdefiniowana własność logging.file lub logging.path."; }
    if(key=='liquibase'){ txt="Zawiera szczegółowe informacje na temat migracji bazy danych Liquibase."; }

    return txt;
}



function afterRestart(data){
    var js=syntaxHighlight(data);
    var str = JSON.stringify(data, null, "\t");

    output(str);
    output(syntaxHighlight(str));

    setTimeout(function(){ getServer(); },1000);
    $( function() {
                    $( "#dialog-funkcje" ).dialog({
                      title: "RESTART...",
                      resizable: false,
                      height: "auto",
                      width: 250,
                      modal: true,
                      buttons: {
                        "Zamknij": function() {
                          $( this ).dialog( "close" );
                        }
                      }
                    });
                } );
    setTimeout(function(){ $( "#dialog-funkcje" ).dialog( "close" ); },3000);
}
function afterShutdown(data){
    var js=syntaxHighlight(data);
    var str = JSON.stringify(data, null, "\t");

    output(str);
    output(syntaxHighlight(str));

    setTimeout(function(){ getServer(); },1000);
    $( function() {
                $( "#dialog-funkcje" ).dialog({
                  title: "ZAMYKANIE...",
                  resizable: false,
                  height: "auto",
                  width: 250,
                  modal: true,
                  buttons: {
                    "Zamknij": function() {
                      $( this ).dialog( "close" );
                    }
                  }
                });
            } );
    setTimeout(function(){ $( "#dialog-funkcje" ).dialog( "close" ); },3000);
}
function afterRefresh(data){
    var js=syntaxHighlight(data);
        var str = JSON.stringify(data, null, "\t");

        output(str);
        output(syntaxHighlight(str));

        setTimeout(function(){ getServer(); },1000);
        $( function() {
                    $( "#dialog-funkcje" ).dialog({
                      title: "REFRESH...",
                      resizable: false,
                      height: "auto",
                      width: 250,
                      modal: true,
                      buttons: {
                        "Zamknij": function() {
                          $( this ).dialog( "close" );
                        }
                      }
                    });
                } );
        setTimeout(function(){ $( "#dialog-funkcje" ).dialog( "close" ); },3000);
}
function afterPause(data){
    var js=syntaxHighlight(data);
        var str = JSON.stringify(data, null, "\t");

        output(str);
        output(syntaxHighlight(str));

        setTimeout(function(){ getServer(); },1000);
        $( function() {
                    $( "#dialog-funkcje" ).dialog({
                      title: "PAUSE...",
                      resizable: false,
                      height: "auto",
                      width: 250,
                      modal: true,
                      buttons: {
                        "Zamknij": function() {
                          $( this ).dialog( "close" );
                        }
                      }
                    });
                } );
        setTimeout(function(){ $( "#dialog-funkcje" ).dialog( "close" ); },3000);
}
function afterResume(data){
    var js=syntaxHighlight(data);
        var str = JSON.stringify(data, null, "\t");

        output(str);
        output(syntaxHighlight(str));

        setTimeout(function(){ getServer(); },1000);
        $( function() {
                    $( "#dialog-funkcje" ).dialog({
                      title: "RESUME...",
                      resizable: false,
                      height: "auto",
                      width: 250,
                      modal: true,
                      buttons: {
                        "Zamknij": function() {
                          $( this ).dialog( "close" );
                        }
                      }
                    });
                } );
        setTimeout(function(){ $( "#dialog-funkcje" ).dialog( "close" ); },3000);
}