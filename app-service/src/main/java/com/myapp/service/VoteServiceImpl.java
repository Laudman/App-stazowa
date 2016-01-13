
package com.myapp.service;

import com.myapp.dao.VoteDao;
import com.myapp.model.Vote;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zama
 */
@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService{
        
        @Autowired
        private VoteDao voteDao;
        
        public Vote findVote(Long id_vote) {
            return voteDao.findVote(id_vote);
	}
        
        public int addPkt (Vote vote){
        // 1 - add vote and pkt++
        // 2 - add vote and pkp--
        // 0 - no add  
    
        int x = 1;
                if(findAllVotes() == null){
                    x = 1;
                }
                else if(findAllVotes() != null && vote.getId_task() == null){
                        for(Vote v: findAllVotes()){
                            if( (v.getId_user().equals(vote.getId_user())) && (v.getId_answer().equals(vote.getId_answer())) ){
                                x = 0;
                                break;
                            }
                        }
                    }
                else if(findAllVotes() != null && vote.getId_answer() == null){
                        for(Vote v: findAllVotes()){
                            if( (v.getId_user().equals(vote.getId_user())) && (v.getId_task().equals(vote.getId_task())) ){
                                x = 0;
                                break;
                            }
                        }
                    }
                if (x == 1 && vote.getVotePkt() >  0 ){
                    x = 1;
                }
                else if(x == 1 && vote.getVotePkt() <  0 ){
                    x =  2;
                }
            return x;
        }
        
    

	public void saveVote(Vote vote) {
            voteDao.saveVote(vote);
	}
	
	public void updateVote(Vote vote) {
            voteDao.updateVote (vote);
	}

	public void deleteVoteBySession(Vote vote) {
            voteDao.deleteVoteBySession(vote);
	}
        

	public List<Vote> findAllVotes() {
		return voteDao.findAllVotes();
	}
        
        public Long amountPktInAnswer(Long idAnswer){
            return voteDao.amountPktInAnswer(idAnswer);
        }
        
        public Long amountPktInTask(Long idTask){
            return voteDao.amountPktInTask(idTask);
        }

  
}