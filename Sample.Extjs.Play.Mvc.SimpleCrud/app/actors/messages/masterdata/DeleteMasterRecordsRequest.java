package actors.messages.masterdata;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/9/12
 * Time: 6:47 AM
 */
public class DeleteMasterRecordsRequest<TModel, TId> extends MasterRecordsRequestBase<TModel, TId>  {
    private TId[] ids;

    public DeleteMasterRecordsRequest(TId[] ids, Class repositoryClass) {
        super(repositoryClass);
        this.ids = ids;
    }

    public TId[] getIds() {
        return ids;
    }
}
