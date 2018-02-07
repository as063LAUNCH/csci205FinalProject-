/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 12, 2016
 * Time: 9:03:21 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: DiceTest
 * Description: A file testing the dice class
 *
 * ****************************************
 */
package Monopoly.utilities;

import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as063
 */
public class DiceTest {

    public DiceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of roll method, of class Dice.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        Dice instance = new Dice();
        int[] expResult = null;
        int[] result = instance.roll();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getRolled method, of class Dice.
     */
    @Test
    public void testGetRolled() {
        System.out.println("getRolled");
        Dice instance = new Dice();
        int[] expResult = null;
        int[] result = instance.getRolled();
        assertArrayEquals(expResult, result);
    }

}
