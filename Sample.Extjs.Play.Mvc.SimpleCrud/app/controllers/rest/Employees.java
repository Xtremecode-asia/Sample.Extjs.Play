package controllers.rest;

import actors.MasterDataService;
import actors.messages.GetEmployeesResponse;
import akka.dispatch.Mapper;
import org.codehaus.jackson.JsonNode;
import play.libs.Akka;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 9:18 AM
 */
public class Employees extends Controller {
    public static Result create(){
        // TODO: Implement this
        return ok();
    }

    public static Result retrieve(){
        return async(
            Akka.asPromise(MasterDataService.getAllEmployees().map(
                    new Mapper<Object, Result>() {
                        @Override
                        public Result apply(Object rawResponse) {
                            GetEmployeesResponse response = (GetEmployeesResponse) rawResponse;
                            JsonNode jsonResponse = response.getJsonResponse();
                            return response.getSuccess() ? ok(jsonResponse) : badRequest(jsonResponse);
                        }
                    }
            ))
        );
    }

    public static Result update(){
        // TODO: Implement this
        return ok();
    }

    public static Result delete(){
        // TODO: Implement this
        return ok();
    }
}
