package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.util.Timeout;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import play.Logger;
import play.libs.Json;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 2:51 PM
 */
public abstract class UntypedActorBase extends UntypedActor {
    private Config config = ConfigFactory.load();
    protected static final String AKKA = "akka";
    protected static final String IS_SUCCESS = "IsSuccess";
    protected static final String ERROR = "Error";
    private static ActorRef actorRefSingleInstance;
    protected static Timeout askTimeOut = new Timeout(100, TimeUnit.MINUTES);

    public static ActorRef getSingleInstance() {
        return actorRefSingleInstance;
    }

    protected String getStringById(String stringId){
        return config.getString(stringId);
    }

    protected static ObjectNode createJsonError(Exception exception) {
        ObjectNode result = Json.newObject();
        String error = String.format("%s \n Stack trace:%s", exception.getMessage(), Arrays.toString(exception.getStackTrace()));
        result.put(IS_SUCCESS, false);
        result.put(ERROR, error);
        Logger.of(AKKA).error(error);
        return result;
    }

    public abstract void onReceive(Object message);

    public static void initialiseSingleton(ActorSystem actorsystem, Class actorClass, String actorName) {
        actorRefSingleInstance = actorsystem.actorOf(new Props(actorClass), actorName );
    }
}
