package actors.messages;

import java.io.Serializable;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 6:03 PM
 */
public class GetEmployeesRequest implements Serializable {
    private Long id;

    public GetEmployeesRequest(Long id){

        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
