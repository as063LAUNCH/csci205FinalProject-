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
 * File: AcademicPropertyTest
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
public class AcademicPropertyTest {
    static final double EPSILON = 1.0E-12;
    
    public AcademicPropertyTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrice method, of class AcademicProperty.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        AcademicProperty instance = new AcademicProperty("AC", "OLIN SCIENCE", 5, 100, 50);
        int expResult = 100;
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMultiplier method, of class AcademicProperty.
     */
    @Test
    public void testGetMultiplier() {
        System.out.println("getMultiplier");
        AcademicProperty instance = new AcademicProperty("AC", "OLIN SCIENCE", 5, 100, 50);
        double expResult = 1.0;
        double result = instance.getMultiplier();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of getCurrentRent method, of class AcademicProperty.
     */
    @Test
    public void testGetCurrentRent() {
        System.out.println("getCurrentRent");
        AcademicProperty instance = new AcademicProperty("AC", "OLIN SCIENCE", 5, 100, 50);
        int expResult = 50;
        int result = instance.getCurrentRent();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPurchased method, of class AcademicProperty.
     */
    @Test
    public void testIsPurchased() {
        System.out.println("isPurchased");
        AcademicProperty instance = new AcademicProperty("AC", "OLIN SCIENCE", 5, 100, 50);
        boolean expResult = false;
        boolean result = instance.isPurchased();
        assertEquals(expResult, result);
    }
    /**
     * Test of landOnAcademicProp method, of class AcademicProperty.
     */
    @Test
    public void testLandOnAcademicProp() {
        System.out.println("landOnAcademicProp");
        ArrayList<Player> players = null;
        int index = 0;
        AcademicProperty instance = null;
        instance.landOnAcademicProp(players, index);
    }





}
