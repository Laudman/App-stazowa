/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.dao.AnswerDao;
import com.myapp.model.Answer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zama
 */
@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService{
    
        @Autowired
        private AnswerDao answerDao;
    
        private static List<Answer> answers;
	
	public Answer findAnswer(Long id_answer) {
		return answerDao.findAnswer(id_answer);
	}

	public void saveAnswer(Answer answer) {
		answerDao.saveAnswer(answer);
	}
	
	public void updateAnswer(Answer answer) {
		answerDao.updateAnswer (answer);
	}

	public void deleteAnswerBySession(Answer answer) {
		answerDao.deleteAnswerBySession(answer);
	}
        
        public void deleteAnswerById(Long id_answer){
            answerDao.deleteAnswerById(id_answer);
        }

	public List<Answer> findAllAnswers() {
		return answerDao.findAllAnswers();
	}

}
