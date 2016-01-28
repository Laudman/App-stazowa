
package com.myapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zama
 */
public class AbstractDaoTest {
    
    public AbstractDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSession method, of class AbstractDao.
     */
    @Test
    public void testGetSession() {
        System.out.println("getSession");
        AbstractDao instance = new AbstractDaoImpl();
        Session expResult = null;
        Session result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByKey method, of class AbstractDao.
     */
    @Test
    public void testGetByKey() {
        System.out.println("getByKey");
        Long key = null;
        AbstractDao instance = new AbstractDaoImpl();
        Object expResult = null;
        Object result = instance.getByKey(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class AbstractDao.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Object entity = null;
        AbstractDao instance = new AbstractDaoImpl();
        instance.save(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AbstractDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object entity = null;
        AbstractDao instance = new AbstractDaoImpl();
        instance.update(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class AbstractDao.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Object entity = null;
        AbstractDao instance = new AbstractDaoImpl();
        instance.merge(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AbstractDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object entity = null;
        AbstractDao instance = new AbstractDaoImpl();
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEntityCriteria method, of class AbstractDao.
     */
    @Test
    public void testCreateEntityCriteria() {
        System.out.println("createEntityCriteria");
        AbstractDao instance = new AbstractDaoImpl();
        Criteria expResult = null;
        Criteria result = instance.createEntityCriteria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractDaoImpl extends AbstractDao {
    }
    
}
