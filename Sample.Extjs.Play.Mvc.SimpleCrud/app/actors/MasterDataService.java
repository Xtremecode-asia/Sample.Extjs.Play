package actors;

import actors.messages.GetEmployeesRequest;
import actors.messages.GetEmployeesResponse;
import akka.dispatch.Future;
import flexjson.JSONSerializer;
import org.codehaus.jackson.JsonNode;
import play.libs.Json;
import repositories.EmployeeRepository;

import static akka.pattern.Patterns.ask;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 2:30 PM
 */
public class MasterDataService extends UntypedActorBase{
    public static final String ACTOR_NAME = "MasterDataService";

    @Override
    public void onReceive(Object message){
        if (message instanceof GetEmployeesRequest){
            getAllEmployees((GetEmployeesRequest) message);
        }
    }

    public static Future<Object> getAllEmployees(){
        return ask(getSingleInstance(), new GetEmployeesRequest(null), askTimeOut);
    }

    private void getAllEmployees(GetEmployeesRequest getEmployeesRequest) {
        JsonNode jsonResponse;
        String stringifiedResult;
        boolean success = false;
        try{
            EmployeeRepository employeeRepository = new EmployeeRepository();
            Long targetId = getEmployeesRequest.getId();
            JSONSerializer jsonSerializer = new JSONSerializer();

            if (targetId == null || targetId <= 0 ){
                stringifiedResult = jsonSerializer.exclude("class").serialize(employeeRepository.FindAll());
            }
            else{
                stringifiedResult = jsonSerializer.exclude("class").serialize(employeeRepository.FindById(targetId));
            }

            jsonResponse = Json.parse(stringifiedResult);
            success = true;
        }
        catch(Exception exception){
            exception.printStackTrace();
            jsonResponse = createJsonError(exception);
        }
        getSender().tell(new GetEmployeesResponse(success, jsonResponse));
    }


}
