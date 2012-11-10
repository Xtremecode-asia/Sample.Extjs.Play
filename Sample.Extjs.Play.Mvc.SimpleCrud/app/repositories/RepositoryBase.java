package repositories;

import com.avaje.ebean.Ebean;
import java.util.List;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/6/12
 * Time: 10:57 PM
 */
public abstract class RepositoryBase<TModel, TId> {
    public List<TModel> FindAll(){
        return Ebean.find(getModelClass()).findList();
    }

    public TModel FindById(TId id){
        return Ebean.find(getModelClass()).where().eq(getIdPropertyName(), id).findUnique();
    }

    public int Delete(TId[] ids){
        if (ids.length == 1){
            return Ebean.delete(getModelClass(), ids[0]);
        }
        return Ebean.delete(getModelClass(), ids);
    }

    public TModel Add(TModel newRecord){
        Ebean.beginTransaction();
        try{
            Ebean.save(newRecord);
            Ebean.commitTransaction();
        }
        finally {
            Ebean.endTransaction();
        }
        return newRecord;
    }


    public int Update(TId changedRecordId, TModel... changedRecords) {
        List<TModel> recordsToUpdate = java.util.Arrays.asList(changedRecords);
        Ebean.beginTransaction();
        try{
            for(TModel recordToUpdate : recordsToUpdate){
                Ebean.update(recordToUpdate);
            }
            Ebean.commitTransaction();
        }
        finally {
            Ebean.endTransaction();
        }
        return Ebean.save(recordsToUpdate);
    }

    //<editor-fold desc="-- Properties --">
    public abstract Class<TModel> getModelClass();

    public String getIdPropertyName() {
        return "id";
    }
    //</editor-fold>
}
