/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 12, 2016
 * Time: 9:03:21 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: TaxTest
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
public class TaxTest {
    
    public TaxTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTaxAmount method, of class Tax.
     */
    @Test
    public void testGetTaxAmount() {
        System.out.println("getTaxAmount");
        Tax instance = null;
        int expResult = 0;
        int result = instance.getTaxAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTaxAmount method, of class Tax.
     */
    @Test
    public void testSetTaxAmount() {
        System.out.println("setTaxAmount");
        int taxAmount = 0;
        Tax instance = null;
        instance.setTaxAmount(taxAmount);
    }
    

    /**
     * Test of landOnTax method, of class Tax.
     */
    @Test
    public void testLandOnTax() throws Exception {
        System.out.println("landOnTax");
        ArrayList<Player> player = null;
        int index = 0;
        Tax instance = null;
        instance.landOnTax(player, index);
    }

}
