import actors.MasterDataService;
import actors.ReportingService;
import akka.actor.ActorSystem;
import play.Application;
import play.GlobalSettings;
import play.mvc.Http;
import play.mvc.Result;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 9:30 PM
 */

public class Global extends GlobalSettings {
    private static ActorSystem actorsystem;
    public static final String ACTOR_SYSTEM = "SampleExtjsPlayMvcBackends";

    @Override
    public void onStart(Application application) {
        super.onStart(application);
        initialiseActors();
    }

    private void initialiseActors() {
        actorsystem = ActorSystem.create(ACTOR_SYSTEM);
        // Create involved actor instances
        MasterDataService.initialiseSingleton(actorsystem, MasterDataService.class, MasterDataService.ACTOR_NAME);
        ReportingService.initialiseSingleton(actorsystem, ReportingService.class, ReportingService.ACTOR_NAME);
    }

    @Override
    public void onStop(Application application) {
        super.onStop(application);
        actorsystem.shutdown();
    }

    @Override
    public Result onError(Http.RequestHeader requestHeader, Throwable throwable) {
        String error =String.format("%s \n Stack trace:%s", throwable.getMessage(), throwable.getStackTrace());
        Logger.getLogger("application").log(Level.SEVERE, error);
        return super.onError(requestHeader, throwable);
    }
}
