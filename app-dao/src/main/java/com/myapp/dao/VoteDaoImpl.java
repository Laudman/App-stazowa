/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.User;
import com.myapp.model.Vote;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zama
 */
@Repository("voteDao")
public class VoteDaoImpl extends AbstractDao<Integer, Vote> implements VoteDao {
    
    public Vote findVote(Long id_vote) {
		return getByKey(id_vote);
	}
    public void updateVote (Vote vote){
            update(vote);
        }

    public void saveVote(Vote vote) {
        save(vote);
    }

    public void deleteVoteBySession(Vote vote) {
        getSession().delete(vote);
    }

    public List<Vote> findAllVotes() {
        return getSession().createCriteria(Vote.class).list();
    }
    
    public Long amountPktInAnswer(Long idAnswer){ 
    Long sum = (Long)getSession().createCriteria(Vote.class)
        .setProjection(Projections.sum("votePkt"))
        .add(Restrictions.eq("id_answer", idAnswer))
        .uniqueResult();
    return sum;
    }
    
    public Long amountPktInTask(Long idTask){ 
    Long sum = (Long)getSession().createCriteria(Vote.class)
        .setProjection(Projections.sum("votePkt"))
        .add(Restrictions.eq("id_task", idTask))
        .uniqueResult();
    return sum;
    }
    
    public void deleteAllVotesIncludedIdAnswer (Long id_answer){
        Query query = getSession().createSQLQuery("delete from votes where id_answer = :id_answer");
        query.setParameter("id_answer", id_answer);
        query.executeUpdate();  
    }
    
}
