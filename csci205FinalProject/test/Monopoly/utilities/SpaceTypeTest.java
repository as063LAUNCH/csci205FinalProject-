/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 12, 2016
 * Time: 9:03:23 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: SpaceTypeTest
 * Description: A file testing the SpaceType class
 *
 * ****************************************
 */
package Monopoly.utilities;

import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as063
 */
public class SpaceTypeTest {

    public SpaceTypeTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class SpaceType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        SpaceType[] expResult = null;
        SpaceType[] result = SpaceType.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class SpaceType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        SpaceType expResult = null;
        SpaceType result = SpaceType.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
