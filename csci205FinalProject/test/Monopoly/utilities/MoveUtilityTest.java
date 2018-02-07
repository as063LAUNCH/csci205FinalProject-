/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 24, 2016
 * Time: 6:54:13 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: MoveUtilityTest
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author slm053
 */
public class MoveUtilityTest {
    private int[][] list;
    private int playerIndex;
    private int roll;
    private MoveUtility instance;
    private final int XVAL = 0;
    private final int YVAL = 1;

    public MoveUtilityTest() {
        this.list = new int[4][2];
        this.playerIndex = 0;
        this.roll = 2;
    }

    @Before
    public void setUp() {
        instance = new MoveUtility();
        list[0][XVAL] = 620; //player 1 x
        list[0][YVAL] = 620; //player 1 y
        list[1][XVAL] = 635; //player 2 x
        list[1][YVAL] = 635; //player 2 y
        list[2][XVAL] = 650; //player 3 x
        list[2][YVAL] = 650; //player 3 y
        list[3][XVAL] = 665; //player 4 x
        list[3][YVAL] = 665; //player 5 y
    }

    @After
    public void tearDown() {
        instance = null;
        list = null;
    }

    /**
     * Test of updateDots method, of class MoveUtility.
     */
    @Test
    public void testUpdateDots() {
        System.out.println("updateDots");

        MoveUtility instance = new MoveUtility();
        int[][] expResult = new int[4][2];
        expResult[0][XVAL] = 512; //player 1 x
        expResult[0][YVAL] = 620; //player 1 y
        expResult[1][XVAL] = 635; //player 2 x
        expResult[1][YVAL] = 635; //player 2 y
        expResult[2][XVAL] = 650; //player 3 x
        expResult[2][YVAL] = 650; //player 3 y
        expResult[3][XVAL] = 665; //player 4 x
        expResult[3][YVAL] = 665; //player 5 y

        int[][] result = instance.updateDots(roll, list, playerIndex);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(
                        "in i = " + i + "  j = " + j + " : " + result[i][j]);
            }
        }
        assertArrayEquals(expResult, result);

    }

}
