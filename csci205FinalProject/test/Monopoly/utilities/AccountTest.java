/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 12, 2016
 * Time: 9:03:21 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: AccountTest
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author as063
 */
public class AccountTest {
    static final double EPSILON = 1.0E-12;
    static final int INITIAL_AMOUNT = 2000;
    private Account instance;
    private int balance;
    
    
    public AccountTest() {
        this.balance = INITIAL_AMOUNT;
    }
    
    @Before
    public void setUp() {
        instance = new Account("test");
        instance.setBalance(INITIAL_AMOUNT);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Account instance = new Account("Player1");
        int expResult = 1500;
        int result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() throws Exception {
        System.out.println("withdraw");
        this.balance = 2000;
        double amount = 1000.0;
        Account instance = new Account("Player1") ;
        instance.withdraw(amount);
        int expResult = 1000;
        int result = instance.getBalance();
    }

    /**
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        this.balance = 2000;
        double amount = 1000.0;
        Account instance = new Account("Player1") ;
        instance.deposit(amount);
        int expResult = 3000;
        int result = instance.getBalance();
        
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Account instance = new Account("Player1");
        this.balance = 2000;
        String expResult = "THE ACCOUNT Player1CURRENTLY CONTAINS $1500";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Account.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Account instance = new Account("Player1");;
        String expResult = "Player1";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

}
