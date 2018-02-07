/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 12, 2016
 * Time: 9:03:23 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: BoardTest
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
public class BoardTest {
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSpace method, of class Board.
     */
    @Test
    public void testGetSpace() {
        System.out.println("getSpace");
        int index = 0;
        Board instance = new Board();
        Space expResult = null;
        Space result = instance.getSpace(index);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllSpaces method, of class Board.
     */
    @Test
    public void testGetAllSpaces() {
        System.out.println("getAllSpaces");
        Board instance = new Board();
        ArrayList<Space> expResult = null;
        ArrayList<Space> result = instance.getAllSpaces();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllCards method, of class Board.
     */
    @Test
    public void testGetAllCards() {
        System.out.println("getAllCards");
        Board instance = new Board();
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getAllCards();
        assertEquals(expResult, result);
       
    }

}
