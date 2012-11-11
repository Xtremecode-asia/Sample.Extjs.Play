package actors.messages.masterdata;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 6:03 PM
 */
public class GetAllMasterRecordsRequest<TModel, TId> extends MasterRecordsRequestBase<TModel, TId> {
    private Long id;

    public GetAllMasterRecordsRequest(Long id, Class repositoryClass) {
        super(repositoryClass);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
