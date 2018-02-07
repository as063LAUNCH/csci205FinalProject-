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
 * File: SpaceTest
 * Description: A file testing the Space class
 *
 * ****************************************
 */
package Monopoly.utilities;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as063
 */
public class SpaceTest {

    public SpaceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getType method, of class Space.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Space instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpaceName method, of class Space.
     */
    @Test
    public void testGetSpaceName() {
        System.out.println("getSpaceName");
        Space instance = null;
        String expResult = "";
        String result = instance.getSpaceName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpaceLocation method, of class Space.
     */
    @Test
    public void testGetSpaceLocation() {
        System.out.println("getSpaceLocation");
        Space instance = null;
        int expResult = 0;
        int result = instance.getSpaceLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpaceName method, of class Space.
     */
    @Test
    public void testSetSpaceName() {
        System.out.println("setSpaceName");
        String spaceName = "";
        Space instance = null;
        instance.setSpaceName(spaceName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpaceLocation method, of class Space.
     */
    @Test
    public void testSetSpaceLocation() {
        System.out.println("setSpaceLocation");
        int spaceLocation = 0;
        Space instance = null;
        instance.setSpaceLocation(spaceLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
