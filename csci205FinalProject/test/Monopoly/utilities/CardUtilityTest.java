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
 * File: CardUtilityTest
 * Description: A file testing the card utility class
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as063
 */
public class CardUtilityTest {
    private Card Card1;
    private Card Card2;
    private Card Card3;
    private Player Player1;

    public CardUtilityTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of chooseCard method, of class CardUtility.
     */
    @Test
    public void testChooseCard() {
        System.out.println("chooseCard");
        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(Card1);
        cardList.add(Card2);
        cardList.add(Card3);
        int index = 0;
        Card expResult = Card1;
        //Card result = CardUtility.chooseCard(cardList);
        //assertEquals(expResult, result);
    }

    /**
     * Test of displayCard method, of class CardUtility.
     */
    @Test
    public void testDisplayCard() {
        System.out.println("displayCard");
        Card drawn = Card1;
        String expResult = "Card1";
        String result = CardUtility.displayCard(drawn);
        assertEquals(expResult, result);
    }

}
