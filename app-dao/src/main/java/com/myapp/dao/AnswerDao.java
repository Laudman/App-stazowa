
package com.myapp.dao;

import com.myapp.model.Answer;
import java.util.List;

/**
 *
 * @author zama
 */
public interface AnswerDao {
    
        Answer findAnswer(Long id_answer);

	void saveAnswer(Answer task);
	
	void deleteAnswerById(Long id_answer);
        
        void deleteAnswerBySession (Answer answer);
        
        public void updateAnswer (Answer answer);
	
	List<Answer> findAllAnswers();
        
        public void deleteAllAnswersIncludedIdTask (Long idTask);
        
        public List<Long> findAllAnswersIdIncludedCurrentTaskId (Long idTask);
    
}
