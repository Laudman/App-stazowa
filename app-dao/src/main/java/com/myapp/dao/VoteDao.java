/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.Vote;
import java.util.List;

/**
 *
 * @author zama
 */
public interface VoteDao {

        Vote findVote(Long id_vote);
        
	void saveVote(Vote vote);
	
	void deleteVoteBySession(Vote vote);
        
        void updateVote (Vote vote);
	
	List<Vote> findAllVotes();
        
        public Long amountPktInAnswer(Long idAnswer);
        
        public Long amountPktInTask(Long idTask);
        
        public void deleteAllVotesIncludedIdAnswer (Long idAnswer);
}
