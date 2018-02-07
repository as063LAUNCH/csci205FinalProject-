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
 * File: JailTest
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
public class JailTest {
    
    public JailTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of landOnJail method, of class Jail.
     */
    @Test
    public void testLandOnJail() {
        System.out.println("landOnJail");
        ArrayList<Player> players = null;
        int index = 0;
        Jail instance = null;
        instance.landOnJail(players, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
