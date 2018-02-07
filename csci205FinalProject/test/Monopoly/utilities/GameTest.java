/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 12, 2016
 * Time: 9:03:22 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: GameTest
 * Description: A file testing the Game class
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as063
 */
public class GameTest {

    public GameTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPlayerList method, of class Game.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("getPlayerList");
        Game instance = null;
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getPlayerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = null;
        Board expResult = null;
        Board result = instance.getBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDice method, of class Game.
     */
    @Test
    public void testGetDice() {
        System.out.println("getDice");
        Game instance = null;
        Dice expResult = null;
        Dice result = instance.getDice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Game instance = null;
        //instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeTurn method, of class Game.
     */
    @Test
    public void testTakeTurn() {
        System.out.println("takeTurn");
        Game instance = null;
        //instance.takeTurn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
