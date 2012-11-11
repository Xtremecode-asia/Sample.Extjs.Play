package actors.messages.masterdata;

import org.codehaus.jackson.JsonNode;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/10/12
 * Time: 5:52 PM
 */
public class UpdateMasterRecordsRequest<TModel, TId> extends MasterRecordsRequestBase<TModel, TId> {
    private final JsonNode changedRecords;
    private final Long changedRecordId;

    public UpdateMasterRecordsRequest(JsonNode changedRecords, Long changedRecordId, Class repositoryClass) {
        super(repositoryClass);
        this.changedRecords = changedRecords;
        this.changedRecordId = changedRecordId;
    }

    public JsonNode getChangedRecords() {
        return changedRecords;
    }

    public Long getChangedRecordId() {
        return changedRecordId;
    }
}
