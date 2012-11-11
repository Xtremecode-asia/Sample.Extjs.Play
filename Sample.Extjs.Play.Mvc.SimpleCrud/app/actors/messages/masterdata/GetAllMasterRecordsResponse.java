package actors.messages.masterdata;

import actors.messages.JsonResponseBase;
import org.codehaus.jackson.JsonNode;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 6:34 PM
 */
public class GetAllMasterRecordsResponse extends JsonResponseBase {
    public GetAllMasterRecordsResponse(boolean success, JsonNode jsonResponse) {
        super(success, jsonResponse);
    }
}
