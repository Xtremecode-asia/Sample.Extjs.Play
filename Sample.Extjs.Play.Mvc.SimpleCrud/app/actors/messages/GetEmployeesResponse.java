package actors.messages;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import java.io.Serializable;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 6:34 PM
 */
public class GetEmployeesResponse implements Serializable {

    private JsonNode jsonResponse;
    private boolean success;

    public GetEmployeesResponse(boolean success, JsonNode jsonResponse) {
        this.success = success;
        this.jsonResponse = jsonResponse;
    }

    public JsonNode getJsonResponse() {
        return jsonResponse;
    }

    public boolean getSuccess() {
        return success;
    }
}
