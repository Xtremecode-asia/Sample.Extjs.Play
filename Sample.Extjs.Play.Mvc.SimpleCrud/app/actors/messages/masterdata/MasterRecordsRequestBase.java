package actors.messages.masterdata;

import repositories.RepositoryBase;

import java.io.Serializable;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/6/12
 * Time: 11:24 PM
 */
public abstract class MasterRecordsRequestBase<TModel, TId> implements Serializable {
    private RepositoryBase<TModel, TId> repository;

    protected MasterRecordsRequestBase(Class repositoryClass) {
        try {
            this.repository = (RepositoryBase<TModel, TId>) repositoryClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RepositoryBase<TModel, TId> getRepository() {
        return repository;
    }
}
