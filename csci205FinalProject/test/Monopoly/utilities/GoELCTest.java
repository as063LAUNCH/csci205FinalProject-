/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 15, 2016
 * Time: 9:59:42 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: GoELCTest
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
public class GoELCTest {
    
    public GoELCTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of landOnGo method, of class GoELC.
     */
    @Test
    public void testLandOnGo() {
        System.out.println("landOnGo");
        ArrayList<Player> players = null;
        int index = 0;
        GoELC instance = null;
        instance.landOnGo(players, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
