package actors.messages;

import org.codehaus.jackson.JsonNode;

import java.io.Serializable;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/8/12
 * Time: 4:34 AM
 */
public abstract class JsonResponseBase implements Serializable {
    private JsonNode jsonResponse;
    private boolean success;

    protected JsonResponseBase(boolean success, JsonNode jsonResponse) {
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
