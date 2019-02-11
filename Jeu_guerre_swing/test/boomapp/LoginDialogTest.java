/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boomapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author achra
 */
public class LoginDialogTest {
    
    public LoginDialogTest() {
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
     * Test of getUsername method, of class LoginDialog.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        LoginDialog instance = new LoginDialog();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class LoginDialog.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        LoginDialog instance = new LoginDialog();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSucceeded method, of class LoginDialog.
     */
    @Test
    public void testIsSucceeded() {
        System.out.println("isSucceeded");
        LoginDialog instance = new LoginDialog();
        boolean expResult = false;
        boolean result = instance.isSucceeded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
