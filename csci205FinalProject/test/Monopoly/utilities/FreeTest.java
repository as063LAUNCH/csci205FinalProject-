/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 15, 2016
 * Time: 9:59:41 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: FreeTest
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author as063
 */
public class FreeTest {
    
    public FreeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFreeSpaceAccount method, of class Free.
     */
    @Test
    public void testGetFreeSpaceAccount() {
        System.out.println("getFreeSpaceAccount");
        //Free instance = new Free();
        Account expResult = null;
        //Account result = instance.getFreeSpaceAccount();
        //assertEquals(expResult, result);
    }

    /**
     * Test of landOnFree method, of class Free.
     */
    @Test
    public void testLandOnFree() {
        System.out.println("landOnFree");
        ArrayList<Player> players = null;
        int index = 0;
        Free instance = null;
        instance.landOnFree(players, index);
    }

    /**
     * Test of getAmount method, of class Free.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Free instance = null;
        int expResult = 0;
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAmount method, of class Free.
     */
    @Test
    public void testAddAmount() {
        System.out.println("addAmount");
        int amount = 0;
        Free instance = null;
        instance.addAmount(amount);
    }

    /**
     * Test of collectMoney method, of class Free.
     */
    @Test
    public void testCollectMoney() {
        System.out.println("collectMoney");
        Free instance = null;
        instance.collectMoney();
    }
    
}
