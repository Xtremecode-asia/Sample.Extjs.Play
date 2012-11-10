package controllers.rest;

import actors.MasterDataService;
import org.codehaus.jackson.JsonNode;
import play.mvc.BodyParser;
import play.mvc.Result;
import repositories.EmployeeRepository;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 9:18 AM
 */
public class Employees extends RestControllerBase {
    @BodyParser.Of(BodyParser.Json.class)
    public static Result create(){
        return async(MasterDataService.createMasterRecords(request().body().asJson(), EmployeeRepository.class));
    }

    public static Result retrieve(){
        return async(MasterDataService.getAllMasterRecords(EmployeeRepository.class));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result update(Long id){
        JsonNode json = request().body().asJson();
        return async(MasterDataService.update(json, id, EmployeeRepository.class));
    }

    public static Result delete(Long id){
        return async(MasterDataService.deleteMasterRecord(id.longValue(), EmployeeRepository.class));
    }
}
