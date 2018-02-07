package Monopoly.utilities;

import java.util.ArrayList;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:35:45 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Game
 * Description: a file containing the Game class
 *
 * ****************************************
 */
/**
 *
 * @author njb011 and slm053
 */
public class Game {
    /**
     * represents an array of players in the game
     */
    private ArrayList<Player> PlayerList;
    /**
     * represents the board being played on
     */
    private Board board;
    /**
     * represents the dice that will be rolled
     */
    private Dice dice;
    /**
     * represents the index in PlayerList of the current player
     */
    private int currPlayerIndex;
    /**
     * represents how many of the players are bankrupt
     */
    private int numPlayersBankrupt;
    /**
     * represents the index of free parking for reference for all instances
     */
    private static final int FREE_SPACE_INDEX = 20;

    private Space currSpace;

    private int currTotalDiceRoll;

    private int[] currDiceRoll;

    /**
     * constructor for the Game class. Takes in the name of each player.
     *
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public Game(String p1, String p2, String p3, String p4) {
        this.PlayerList = new ArrayList<Player>();
        PlayerList.add(new Player(0, p1));
        PlayerList.add(new Player(1, p2));
        PlayerList.add(new Player(2, p3));
        PlayerList.add(new Player(3, p4));
        this.board = new Board();
        this.dice = new Dice();
        this.numPlayersBankrupt = 0;
        this.currSpace = null;
        this.currPlayerIndex = 0;
        this.currTotalDiceRoll = 0;
        this.currDiceRoll = null;
    }

    public ArrayList<Player> getPlayerList() {
        return PlayerList;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public String getFinalStats() {
        String winner = this.PlayerList.get(0).getPlayerName();
        int high = this.PlayerList.get(0).getBankAccount().getBalance();
        int i = 0;
        for (i = 0; i < this.PlayerList.size(); i++) {
            if (PlayerList.get(i).getBankAccount().getBalance() > high) {
                high = this.PlayerList.get(i).getBankAccount().getBalance();
                winner = this.PlayerList.get(i).getPlayerName();
            }
        }
        return winner;
    }

    public int[] getCurrDiceRoll() {
        return currDiceRoll;
    }

    /**
     * Method that represents the playing of the game
     */
    public void play() throws InsufficientFundsException {
        while (this.numPlayersBankrupt != 3) {
            if (MonopolyUtility.potentialMonopoly() == true) {
                ArrayList<Color> existingMonopolies = MonopolyUtility.findMonopolies();
                ArrayList<Property> playerMonopolies = MonopolyUtility.getPlayerMonopolies(
                        this.PlayerList.get(currPlayerIndex),
                        existingMonopolies);
                MonopolyUtility.buildProperties(playerMonopolies,
                                                this.PlayerList.get(
                                                        currPlayerIndex));

            }

            if (currPlayerIndex == this.PlayerList.size() - 1) {
                this.currPlayerIndex = 0;
            } //else just increment the index to the next player
            else {
                this.currPlayerIndex += 1;
            }

        }

    }

    public void moveToNextTurn() {
        if (currPlayerIndex == this.PlayerList.size() - 1) {
            this.currPlayerIndex = 0;
        } //else just increment the index to the next player
        else {
            this.currPlayerIndex += 1;
        }
    }

    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public int getNumPlayersBankrupt() {
        return numPlayersBankrupt;
    }

    public static int getFREE_SPACE_INDEX() {
        return FREE_SPACE_INDEX;
    }

    public Space getCurrSpace() {
        return currSpace;
    }

    public int getCurrTotalDiceRoll() {
        return currTotalDiceRoll;
    }

    //once it exits the while loop, game ends
    /**
     * method that represents the motions of a player taking their turn
     */
    public String takeTurn() throws InsufficientFundsException {
        this.currDiceRoll = this.dice.roll();
        this.currTotalDiceRoll = currDiceRoll[0] + currDiceRoll[1];
        //thought about making this a separate method, to check for if they are
        //still in jail, but it needs to be within this method because of the
        //return statement to break out of the method and not take the turn if
        //the player is still in jail
        //if (this.PlayerList.get(currPlayerIndex).isIsInJail()) {
        // if (this.PlayerList.get(currPlayerIndex).getRollsInJail() == 3) {
        //System.out.format("%s is now out of jail!\n",
        //                this.PlayerList.get(
        //                      currPlayerIndex).getPlayerName());
        String output = "";
        if (currDiceRoll[0] == currDiceRoll[1] && this.PlayerList.get(
                currPlayerIndex).isIsInJail()) {
            output = String.format(
                    "%s is now out of jail, they rolled a double totaling %d!\n",
                    this.PlayerList.get(
                            currPlayerIndex).getPlayerName(),
                    this.currTotalDiceRoll);
            this.PlayerList.get(currPlayerIndex).setRollsInJail(0);
            this.PlayerList.get(currPlayerIndex).setIsInJail(false);
            this.movePlayer();
        } else if (this.PlayerList.get(currPlayerIndex).isIsInJail() && this.PlayerList.get(
                currPlayerIndex).getRollsInJail() == 3) {
            output = String.format(
                    "This is %s's third roll in jail.  They are now out of jail and rolled a %d",
                    this.PlayerList.get(currPlayerIndex).getPlayerName(),
                    this.currTotalDiceRoll);
            this.PlayerList.get(currPlayerIndex).setRollsInJail(0);
            this.PlayerList.get(currPlayerIndex).setIsInJail(false);
            this.movePlayer();
        } else if (this.PlayerList.get(currPlayerIndex).isIsInJail()) {
            output = String.format(
                    "%s is still in jail-- did not roll a double!\n",
                    this.PlayerList.get(
                            currPlayerIndex).getPlayerName());
            this.PlayerList.get(currPlayerIndex).incrementRollsInJail();
            this.currSpace = this.board.getSpace(10);
        } else {
            output = String.format("%s rolled a %d", this.PlayerList.get(
                                   currPlayerIndex).getPlayerName(),
                                   this.currTotalDiceRoll);
            this.movePlayer();
        }

        return output;

    }

    public void movePlayer() {
        this.PlayerList.get(currPlayerIndex).move(this.currTotalDiceRoll);
        //System.out.format("%s is now on space #%d\n", this.PlayerList.get(
        //          currPlayerIndex).getPlayerName(), this.PlayerList.get(
        //              currPlayerIndex).getCurrLocation());
        this.currSpace = board.getSpace(
                this.PlayerList.get(currPlayerIndex).getCurrLocation());
        //System.out.format("%s landed on %s\n", this.PlayerList.get(
        //             currPlayerIndex).getPlayerName(),
        //         currSpace.getSpaceName());
    }

    public void evalSpace() {

        if (currSpace.getType().equals("Prop")) {
            ((Property) currSpace).landOnProperty(PlayerList, currPlayerIndex);
        } //check to see if space is a tax space
        else if (currSpace.getType().equals("Tax")) {
            try {
                ((Tax) currSpace).landOnTax(PlayerList, currPlayerIndex);
                //System.out.format("%s must pay $%d in taxes.\n",
                //         this.PlayerList.get(
                //               currPlayerIndex).getPlayerName(),
                //       ((Tax) currSpace).getTaxAmount());
            } catch (InsufficientFundsException e) {
                System.out.println("Not enough money to pay the tax.");
            }
        } else if (currSpace.getType().equals("Free")) {
            //check to see if there is any amount of money in the community pot
            ((Free) currSpace).landOnFree(PlayerList, currPlayerIndex);

        } else if (currSpace.getType().equals("GoToJail")) {
            ((GoToJail) currSpace).sendToJail(this.PlayerList, currPlayerIndex);

        } else if (currSpace.getType().equals("Chest")) {
            ((CommunityChest) currSpace).landOnCommunityChest(PlayerList,
                                                              currPlayerIndex,
                                                              this.board.getAllSpaces());
        } else if (currSpace.getType().equals("Go")) {
            ((GoELC) currSpace).landOnGo(PlayerList, currPlayerIndex);
        } else if (currSpace.getType().equals("AC")) {
            ((AcademicProperty) currSpace).landOnAcademicProp(PlayerList,
                                                              currPlayerIndex);
        } else if (currSpace.getType().equals("Chance")) {
            ((Chance) currSpace).landOnChance(PlayerList, currPlayerIndex,
                                              board.getAllSpaces());
        } else if (currSpace.getType().equals("Jail")) {
            ((Jail) currSpace).landOnJail(PlayerList, currPlayerIndex);
        }

    }
}
