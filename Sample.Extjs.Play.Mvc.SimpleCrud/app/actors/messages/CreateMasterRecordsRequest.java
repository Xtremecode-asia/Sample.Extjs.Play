package actors.messages;

import org.codehaus.jackson.JsonNode;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/6/12
 * Time: 11:20 PM
 */
public class CreateMasterRecordsRequest<TModel, TId> extends MasterRecordsRequestBase<TModel, TId> {
    private JsonNode newRecords;

    public CreateMasterRecordsRequest(JsonNode newRecords, Class repositoryClass) {
        super(repositoryClass);
        this.newRecords = newRecords;
    }

    public JsonNode getNewRecords() {
        return newRecords;
    }
}
