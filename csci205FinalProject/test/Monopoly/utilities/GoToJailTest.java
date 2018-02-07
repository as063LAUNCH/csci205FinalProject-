/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 15, 2016
 * Time: 9:59:40 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: GoToJailTest
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
public class GoToJailTest {
    
    public GoToJailTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sendToJail method, of class GoToJail.
     */
    @Test
    public void testSendToJail() {
        System.out.println("sendToJail");
        ArrayList<Player> players = null;
        int index = 0;
        GoToJail instance = null;
        instance.sendToJail(players, index);
    }
    
}
