
package com.myapp.dao;

import com.myapp.model.Answer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zama
 */
@Repository("answerDao")
public class AnswerDaoImpl extends AbstractDao<Integer, Answer> implements AnswerDao{

    public Answer findAnswer(Long id_answer) {
            return getByKey(id_answer);
    }
    
    public void updateAnswer (Answer answer){
            update(answer);
        }

    public void saveAnswer(Answer answer) {
        save(answer);
    }

    public void deleteAnswerById(Long id_answer) {
        Query query = getSession().createSQLQuery("delete from answers where id_answer = :id_answer");
        query.setParameter("id_answer", id_answer);
        query.executeUpdate();    }

    public void deleteAnswerBySession(Answer answer) {
        getSession().delete(answer);
    }

    public List<Answer> findAllAnswers() {
        return getSession().createCriteria(Answer.class).list();
    }

    public List<Long> findAllAnswersIdIncludedCurrentTaskId (Long id_task){
         Query query = getSession().createSQLQuery("select id_answer as num from answers where id_task = :id_task")
         .addScalar("num", StandardBasicTypes.LONG);
         query.setParameter("id_task", id_task);
         List <Long> answersIdByIdTask = query.list();         
         return answersIdByIdTask;
    }
    
    public void deleteAllAnswersIncludedIdTask (Long id_task){
        Query query = getSession().createSQLQuery("delete from answers where id_task = :id_task");
        query.setParameter("id_task", id_task);
        query.executeUpdate();    
        
    }
 
    
}
