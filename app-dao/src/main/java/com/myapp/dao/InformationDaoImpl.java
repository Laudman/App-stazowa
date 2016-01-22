
package com.myapp.dao;

import com.myapp.model.Information;
import com.myapp.model.Subscribe;
import com.myapp.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zama
 */
@Repository("informationDao")
public class InformationDaoImpl extends AbstractDao<Integer, Information> implements InformationDao{
    
     public Information findInformation(Long idInformation) {
		return getByKey(idInformation);
	}
    
    public void saveInformation(Information information) {
        save(information);
    }

    public void deleteInformationBySession(Information information) {
        getSession().delete(information);
    }
    
    public void deleteInformationById(Long idInformation) {

		Query query = getSession().createSQLQuery("delete from informations where id_information = :idInformation");
		query.setParameter("id_information", idInformation);
		query.executeUpdate();
	}

    public List<Information> findAllInformations() {
        return getSession().createCriteria(Information.class).list();
    }
    
    public Information findInformationsIncludeIdTaskAndUser (Long idTask, User idUser){
        Criteria crit = getSession().createCriteria(Subscribe.class)
                .add(Restrictions.eq("idTask", idTask))
                .add(Restrictions.eq("user", idUser));
                 return (Information) crit.uniqueResult();
    }
}
