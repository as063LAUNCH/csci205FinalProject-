/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 23, 2016
 * Time: 9:10:03 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: MoveUtility
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

/**
 *
 * @author slm053
 */
/*
 //Sienna's Quick Notes: Corner pieces: 64 units apart
 // smaller pieces: 54 units apart
 //start coordinates:  within --between (620-700), (620-700)
 //move 64, then 54 (8), 64 (-x direction)
 // '''                     (-y direction)
 // '''                     (x direction)
 /// '''                    (y direction)

 set each piece to start about 10 pixels apart?
 movement is PER PLAYER
 boolean down;
 boolean right;
 initialize down = true;
 initialize right = true;

 if(player location % 10 == 0 )
 if(down)
 if(right)
 else if (right)

 */
public final class MoveUtility {
    /**
     * represents the boundary of right before the top left space on the board
     * (y coordinate)
     */
    private final int TOPLEFT = 90;
    /**
     * represents the boundary of right before the top right space on the board
     * (x coordinate)
     */
    private final int TOPRIGHT = 600;
    /**
     * represents the boundary of right before the bottom left space on the
     * board (x coordinate)
     */
    private final int BOTTOMLEFT = 104;
    /**
     * represents the boundary of right before the bottom right space on the
     * board (y coordinate)
     */
    private final int BOTTOMRIGHT = 600;
    /**
     * represents whether the movement will be to the left
     */
    private boolean movinLeft;

    /**
     * represents whether the movement will be upwards
     */
    private boolean movinUp;

    /**
     * represents the amount of space between big spaces and smaller spaces
     */
    private final int SMALLTOBIG = 10;
    /**
     * represents moving from the top right corner
     */
    private final int BIGTOBIG = 15;

    /**
     * represents the amount of space between small spaces
     */
    private final int SMALLSMALL = 54;

    /**
     * represents the x value index
     */
    private final int XVAL = 0;

    /**
     * represents the y value index
     */
    private final int YVAL = 1;

    /**
     * represents the location of jail
     */
    private int[] JAILLOCATION = {80, 80};

    /**
     * method that determines if the player is in a corner spot. Also adds to
     * help center piece
     *
     * @return an integer to dictate which corner you are in, or -1 in not in a
     * corner
     */
    private void inCorner(int[][] list, int playerIndex) {
        if (list[0][XVAL] > TOPRIGHT && list[1][XVAL] > TOPRIGHT && list[2][XVAL] > TOPRIGHT && list[3][XVAL] > TOPRIGHT) {
            return;
        }
        if (list[playerIndex][XVAL] > TOPRIGHT && list[playerIndex][YVAL] < TOPLEFT) {
            list[playerIndex][XVAL] += (SMALLTOBIG);
            list[playerIndex][YVAL] += (BIGTOBIG);
            //return TOPRIGHT;
        }

        if (list[playerIndex][XVAL] < BOTTOMLEFT && list[playerIndex][YVAL] > BOTTOMRIGHT) {
            list[playerIndex][XVAL] -= (SMALLTOBIG);
            list[playerIndex][YVAL] -= (SMALLTOBIG);
            //return BOTTOMLEFT;
        }
        if (list[playerIndex][YVAL] > BOTTOMRIGHT && list[playerIndex][XVAL] > TOPRIGHT) {
            list[playerIndex][YVAL] += (SMALLTOBIG);
            list[playerIndex][XVAL] -= (SMALLTOBIG);
            //return BOTTOMRIGHT;
        }
        if (list[playerIndex][YVAL] < TOPLEFT && list[playerIndex][XVAL] < BOTTOMLEFT) {
            list[playerIndex][YVAL] -= (SMALLTOBIG);
            list[playerIndex][XVAL] += (BIGTOBIG);
            //return TOPLEFT;
        }
    }

    private int whereAmI(int[][] list, int playerIndex) {
        if (list[playerIndex][XVAL] > BOTTOMLEFT && list[playerIndex][YVAL] > BOTTOMRIGHT) {
            return 0;
        } else if (list[playerIndex][YVAL] < TOPLEFT && list[playerIndex][XVAL] < TOPRIGHT) {
            return 2;
        } else if (list[playerIndex][XVAL] < BOTTOMLEFT) {
            return 1;
        } else {
            return 3;
        }
    }

    /**
     * main utility to change the rolls into an updated player location
     */
    public int[][] updateDots(int roll, int[][] list, int playerIndex) {

        /**
         * for this variable, 0 means moving on the bottom of the board, 1 means
         * moving on the left side of the board, 2 means moving on the top of
         * the board, and 3 means moving on the right of the board. if
         *
         */
        int direction;

        for (int i = 0; i < roll; i++) {
            inCorner(list, playerIndex);
            direction = whereAmI(list, playerIndex);

            if (direction == 0) {
            } else if (direction == 1) {
                list[playerIndex][YVAL] -= SMALLSMALL;
            } else if (direction == 2) {
                list[playerIndex][XVAL] += SMALLSMALL;
            } else {
                list[playerIndex][YVAL] += SMALLSMALL;
            }

        }
        return list;
    }

    /**
     * dots[0][XVAL] = 605; //player 1 x dots[0][YVAL] = 620; //player 1 y
     * dots[1][XVAL] = 610; //player 2 x dots[1][YVAL] = 625; //player 2 y
     * dots[2][XVAL] = 620; //player 3 x dots[2][YVAL] = 630; //player 3 y
     * dots[3][XVAL] = 630; //player 4 x dots[3][YVAL] = 635; //player 5 y /**
     * method that updates the dots if a player is in jail
     *
     * @param list
     * @param playerIndex
     * @return new list of dot locations
     */
    public int[][] jailUpdateDots(int[][] list, int playerIndex) {
        if (playerIndex == 0) {
            list[playerIndex][XVAL] = 75;
            list[playerIndex][YVAL] = 630;

        }
        if (playerIndex == 1) {
            list[playerIndex][XVAL] = 75;
            list[playerIndex][YVAL] = 633;

        }
        if (playerIndex == 2) {
            list[playerIndex][XVAL] = 75;
            list[playerIndex][YVAL] = 635;

        }
        if (playerIndex == 3) {
            list[playerIndex][XVAL] = 75;
            list[playerIndex][YVAL] = 638;
        }
        return list;
    }

    public int[][] bankruptUodateDots(int[][] list, int playerIndex) {
        list[playerIndex][XVAL] = 700;
        list[playerIndex][YVAL] = 700;
        return list;
    }

}
