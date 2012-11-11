package actors;

import actors.messages.masterdata.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.Future;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import play.libs.Json;
import repositories.EmployeeRepository;
import repositories.RepositoryBase;

import static akka.pattern.Patterns.ask;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 2:30 PM
 */
public class MasterDataService extends UntypedActorBase{
    public static final String ACTOR_NAME = "MasterDataService";
    private static ActorRef s_instance;

    public static void initialiseActorRef(ActorSystem actorSystem){
        s_instance = actorSystem.actorOf(new Props(MasterDataService.class), ACTOR_NAME);
    }

    @Override
    public void onReceive(Object message){
        if (message instanceof GetAllMasterRecordsRequest){
            getAll((GetAllMasterRecordsRequest) message);
        }
        else if (message instanceof CreateMasterRecordsRequest){
            create((CreateMasterRecordsRequest) message);
        }
        else if (message instanceof DeleteMasterRecordsRequest){
            delete((DeleteMasterRecordsRequest) message);
        }
        else if (message instanceof UpdateMasterRecordsRequest){
            update((UpdateMasterRecordsRequest) message);
        }
    }
    //<editor-fold desc="-- Service Methods --">
    public static Future<Object> getAllMasterRecords(Class repositoryClass){
        return ask(s_instance, new GetAllMasterRecordsRequest(null, repositoryClass), askTimeOut);
    }

    public static Future<Object> createMasterRecords(JsonNode newRecords, Class repositoryClass){
        return ask(s_instance, new CreateMasterRecordsRequest(newRecords, repositoryClass), askTimeOut);
    }

    public static<TId> Future<Object> deleteMasterRecord(TId masterRecordId, Class repositoryClass){
        return ask(s_instance, new DeleteMasterRecordsRequest(new Object[]{masterRecordId}, repositoryClass), askTimeOut);
    }

    public static Future<Object> update(JsonNode changedRecords, Long changedRecordId, Class<EmployeeRepository> repositoryClass) {
        return ask(s_instance, new UpdateMasterRecordsRequest(changedRecords, changedRecordId, repositoryClass), askTimeOut);
    }

    //</editor-fold>

    //<editor-fold desc="-- Helpers --">
    private void create(CreateMasterRecordsRequest message) {
        JsonNode jsonResponse;
        boolean success = false;
        try{
            JSONDeserializer jsonDeserializer = new JSONDeserializer();
            RepositoryBase repository = message.getRepository();
            Object deserialisedNewRecords =
                    jsonDeserializer.use(null, repository.getModelClass()).deserialize(message.getNewRecords().toString());
            Object createdRecord = repository.Add(deserialisedNewRecords);
            JSONSerializer jsonSerializer = new JSONSerializer();
            jsonResponse = Json.parse(jsonSerializer.exclude("class").serialize(createdRecord));
            success = true;
        }
        catch(Exception exception){
            exception.printStackTrace();
            jsonResponse = createJsonError(exception);
        }
        getSender().tell(new CreateMasterRecordsResponse(success, jsonResponse));
    }

    private void getAll(GetAllMasterRecordsRequest getAllRequest) {
        JsonNode jsonResponse;
        boolean success = false;
        try{
            RepositoryBase repository = getAllRequest.getRepository();
            Long targetId = getAllRequest.getId();
            JSONSerializer jsonSerializer = new JSONSerializer();
            String stringifiedResult;
            if (targetId == null || targetId <= 0 ){
                stringifiedResult = jsonSerializer.exclude("class").serialize(repository.FindAll());
            }
            else{
                stringifiedResult = jsonSerializer.exclude("class").serialize(repository.FindById(targetId));
            }

            jsonResponse = Json.parse(stringifiedResult);
            success = true;
        }
        catch(Exception exception){
            exception.printStackTrace();
            jsonResponse = createJsonError(exception);
        }
        getSender().tell(new GetAllMasterRecordsResponse(success, jsonResponse));
    }

    private void delete(DeleteMasterRecordsRequest message) {
        ObjectNode jsonResponse;
        boolean success = false;
        try{
            RepositoryBase repository = message.getRepository();
            int deletedRecords = repository.Delete(message.getIds() );
            success = true;
            jsonResponse = Json.newObject();
            jsonResponse.put("count", deletedRecords);
            jsonResponse.put(IS_SUCCESS, success);
        }
        catch(Exception exception){
            exception.printStackTrace();
            jsonResponse = createJsonError(exception);
        }
        getSender().tell(new DeleteMasterRecordsResponse(success, jsonResponse));
    }

    private void update(UpdateMasterRecordsRequest message){
        ObjectNode jsonResponse;
        boolean success = false;
        try{
            RepositoryBase repository = message.getRepository();
            JSONDeserializer jsonDeserializer = new JSONDeserializer();
            Object deserialisedChangedRecords =
                jsonDeserializer.use(null, repository.getModelClass()).deserialize(message.getChangedRecords().toString());
            int updatedRecords = repository.Update(message.getChangedRecordId(), deserialisedChangedRecords);
            success = true;
            jsonResponse = Json.newObject();
            jsonResponse.put("count", updatedRecords);
            jsonResponse.put(IS_SUCCESS, success);
        }
        catch(Exception exception){
            exception.printStackTrace();
            jsonResponse = createJsonError(exception);
        }
        getSender().tell(new UpdateMasterRecordsResponse(success, jsonResponse));
    }

    //</editor-fold>

}
