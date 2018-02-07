/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 12, 2016
 * Time: 9:03:22 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: PlayerTest
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
public class PlayerTest {
    private Player instance;
    private static final int MAX_SPACE_NUM = 39;
    private Account bankAccount;
    private int playerNumber = 1;
    private static ArrayList<Space> propertiesOwned = null;
    private boolean isInJail = false;
    private int rollsInJail = 2;
    private int currLocation = 10;
    private String playerName = "Peter";

    
    public PlayerTest() {
        instance = new Player(1, "Peter");
  
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Player instance = new Player(1, "Peter");
        String expResult = "Peter";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int numSpaces = 10;
        Player instance = new Player(1, "Peter");
        instance.move(numSpaces);
    }


    /**
     * Test of getBankAccount method, of class Player.
     */
    @Test
    public void testGetBankAccount() {
        System.out.println("getBankAccount");
        Player instance = new Player(1, "Peter");
        Account expResult = null;
        Account result = instance.getBankAccount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerNumber method, of class Player.
     */
    @Test
    public void testGetPlayerNumber() {
        System.out.println("getPlayerNumber");
        Player instance = new Player(1, "Peter");
        int expResult = 1;
        int result = instance.getPlayerNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertiesOwned method, of class Player.
     */
    @Test
    public void testGetPropertiesOwned() {
        System.out.println("getPropertiesOwned");
        Player instance = new Player(1, "Peter");
        ArrayList<Space> expResult = null;
        ArrayList<Space> result = instance.getPropertiesOwned();
        assertEquals(expResult, result);
    }

    /**
     * Test of isIsInJail method, of class Player.
     */
    @Test
    public void testIsIsInJail() {
        System.out.println("isIsInJail");
        Player instance = new Player(1, "Peter");
        boolean expResult = false;
        boolean result = instance.isIsInJail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRollsInJail method, of class Player.
     */
    @Test
    public void testGetRollsInJail() {
        System.out.println("getRollsInJail");
        Player instance = new Player(1, "Peter");
        int expResult = 0;
        int result = instance.getRollsInJail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrLocation method, of class Player.
     */
    @Test
    public void testGetCurrLocation() {
        System.out.println("getCurrLocation");
        Player instance = new Player(1, "Peter");
        int expResult = 0;
        int result = instance.getCurrLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsBankrupt method, of class Player.
     */
    @Test
    public void testSetIsBankrupt() {
        System.out.println("setIsBankrupt");
        boolean isBankrupt = false;
        Player instance = null;
        instance.setIsBankrupt(isBankrupt);

    }

    /**
     * Test of isIsBankrupt method, of class Player.
     */
    @Test
    public void testIsIsBankrupt() {
        System.out.println("isIsBankrupt");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isIsBankrupt();
        assertEquals(expResult, result);

    }

    /**
     * Test of getStats method, of class Player.
     */
    @Test
    public void testGetStats() {
        System.out.println("getStats");
        Player instance = null;
        String expResult = "";
        String result = instance.getStats();
        assertEquals(expResult, result);

    }

    /**
     * Test of incrementRollsInJail method, of class Player.
     */
    @Test
    public void testIncrementRollsInJail() {
        System.out.println("incrementRollsInJail");
        Player instance = null;
        instance.incrementRollsInJail();
    }


}
