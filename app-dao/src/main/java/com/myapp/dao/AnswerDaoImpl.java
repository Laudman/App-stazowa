/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.Answer;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
 
    
}
