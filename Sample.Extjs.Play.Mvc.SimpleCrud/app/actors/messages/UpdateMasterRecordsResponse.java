package actors.messages;

import org.codehaus.jackson.JsonNode;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 11/10/12
 * Time: 6:27 PM
 */
public class UpdateMasterRecordsResponse extends JsonResponseBase{
    public UpdateMasterRecordsResponse(boolean success, JsonNode jsonResponse) {
        super(success, jsonResponse);
    }
}
