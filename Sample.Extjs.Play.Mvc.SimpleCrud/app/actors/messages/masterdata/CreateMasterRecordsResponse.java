package actors.messages.masterdata;

import actors.messages.JsonResponseBase;
import org.codehaus.jackson.JsonNode;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/8/12
 * Time: 4:32 AM
 */
public class CreateMasterRecordsResponse extends JsonResponseBase {
    public CreateMasterRecordsResponse(boolean success, JsonNode jsonResponse) {
        super(success, jsonResponse);
    }
}
