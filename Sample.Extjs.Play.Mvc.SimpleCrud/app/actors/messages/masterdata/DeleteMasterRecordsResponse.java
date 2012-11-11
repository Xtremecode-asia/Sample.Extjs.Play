package actors.messages.masterdata;

import actors.messages.JsonResponseBase;
import org.codehaus.jackson.JsonNode;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/9/12
 * Time: 6:51 AM
 */
public class DeleteMasterRecordsResponse extends JsonResponseBase {
    public DeleteMasterRecordsResponse(boolean success, JsonNode jsonResponse) {
        super(success, jsonResponse);
    }
}
