package controllers.rest;

import actors.messages.JsonResponseBase;
import akka.dispatch.Future;
import akka.dispatch.Mapper;
import org.codehaus.jackson.JsonNode;
import play.libs.Akka;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/10/12
 * Time: 5:38 PM
 */
public abstract class RestControllerBase extends Controller {
    protected static Result async(Future<Object> unmappedResult){
        return async(
                Akka.asPromise(unmappedResult.map(
                        new Mapper<Object, Result>() {
                            @Override
                            public Result apply(Object rawResponse) {
                                JsonResponseBase response = (JsonResponseBase) rawResponse;
                                JsonNode jsonResponse = response.getJsonResponse();
                                return response.getSuccess() ? ok(jsonResponse) : badRequest(jsonResponse);
                            }
                        }
                ))
        );
    }
}
