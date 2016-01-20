
package com.myapp.service;

import com.myapp.model.Answer;
import java.util.List;

/**
 *
 * @author zama
 */
public interface AnswerService {
    
        Answer findAnswer(Long id_answer);

	void saveAnswer(Answer answer);
	
	void deleteAnswerBySession(Answer answer);
        
        public void deleteAnswerById(Long id_answer);
        
        void updateAnswer (Answer answer);
	
	List<Answer> findAllAnswers();
        
        public void deleteAllAnswersIncludedIdTask (Long idTask);
        
        public List<Long> findAllAnswersIdIncludedCurrentTaskId (Long idTask);
}
