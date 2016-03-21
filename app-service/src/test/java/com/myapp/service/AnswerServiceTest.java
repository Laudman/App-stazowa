///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.myapp.service;
//
//import com.myapp.model.Answer;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author zama
// */
//public class AnswerServiceTest {
//    
//    public AnswerServiceTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of findAnswer method, of class AnswerService.
//     */
//    @Test
//    public void testFindAnswer() {
//        System.out.println("findAnswer");
//        Long id_answer = null;
//        AnswerService instance = new AnswerServiceImpl();
//        Answer expResult = null;
//        Answer result = instance.findAnswer(id_answer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveAnswer method, of class AnswerService.
//     */
//    @Test
//    public void testSaveAnswer() {
//        System.out.println("saveAnswer");
//        Answer answer = null;
//        AnswerService instance = new AnswerServiceImpl();
//        instance.saveAnswer(answer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAnswerBySession method, of class AnswerService.
//     */
//    @Test
//    public void testDeleteAnswerBySession() {
//        System.out.println("deleteAnswerBySession");
//        Answer answer = null;
//        AnswerService instance = new AnswerServiceImpl();
//        instance.deleteAnswerBySession(answer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAnswerById method, of class AnswerService.
//     */
//    @Test
//    public void testDeleteAnswerById() {
//        System.out.println("deleteAnswerById");
//        Long id_answer = null;
//        AnswerService instance = new AnswerServiceImpl();
//        instance.deleteAnswerById(id_answer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateAnswer method, of class AnswerService.
//     */
//    @Test
//    public void testUpdateAnswer() {
//        System.out.println("updateAnswer");
//        Answer answer = null;
//        AnswerService instance = new AnswerServiceImpl();
//        instance.updateAnswer(answer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAllAnswers method, of class AnswerService.
//     */
//    @Test
//    public void testFindAllAnswers() {
//        System.out.println("findAllAnswers");
//        AnswerService instance = new AnswerServiceImpl();
//        List<Answer> expResult = null;
//        List<Answer> result = instance.findAllAnswers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAllAnswersIncludedIdTask method, of class AnswerService.
//     */
//    @Test
//    public void testDeleteAllAnswersIncludedIdTask() {
//        System.out.println("deleteAllAnswersIncludedIdTask");
//        Long idTask = null;
//        AnswerService instance = new AnswerServiceImpl();
//        instance.deleteAllAnswersIncludedIdTask(idTask);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAllAnswersIdIncludedCurrentTaskId method, of class AnswerService.
//     */
//    @Test
//    public void testFindAllAnswersIdIncludedCurrentTaskId() {
//        System.out.println("findAllAnswersIdIncludedCurrentTaskId");
//        Long idTask = null;
//        AnswerService instance = new AnswerServiceImpl();
//        List<Long> expResult = null;
//        List<Long> result = instance.findAllAnswersIdIncludedCurrentTaskId(idTask);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class AnswerServiceImpl implements AnswerService {
//
//        public Answer findAnswer(Long id_answer) {
//            return null;
//        }
//
//        public void saveAnswer(Answer answer) {
//        }
//
//        public void deleteAnswerBySession(Answer answer) {
//        }
//
//        public void deleteAnswerById(Long id_answer) {
//        }
//
//        public void updateAnswer(Answer answer) {
//        }
//
//        public List<Answer> findAllAnswers() {
//            return null;
//        }
//
//        public void deleteAllAnswersIncludedIdTask(Long idTask) {
//        }
//
//        public List<Long> findAllAnswersIdIncludedCurrentTaskId(Long idTask) {
//            return null;
//        }
//    }
//    
//}
