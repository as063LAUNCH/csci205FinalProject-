/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 15, 2016
 * Time: 9:37:48 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.model
 * File: MonopolyModel
 * Description: A model that represents the player names.
 *
 * ****************************************
 */
package Monopoly.model;

import Monopoly.utilities.Dice;
import Monopoly.utilities.Game;
import Monopoly.utilities.Player;
import Monopoly.utilities.Property;
import java.util.ArrayList;

/**
 *
 * @author slm053
 */
public class MonopolyModel {

    /**
     * represents the name of player 1
     */
    private String player1;
    /**
     * represents the name of player 2
     */
    private String player2;
    /**
     * represents the name of player 3
     */
    private String player3;
    /**
     * represents the name of player 4
     */
    private String player4;

    /**
     * represents the dice being used in the game
     */
    private Dice dice;

    /**
     * represents the list of players used in the game
     */
    private ArrayList<Player> PlayerList;
    /**
     * represents the game
     */
    private Game game;
    /**
     * represents the string of the current player's name
     */
    private String currPlayerName;

    /**
     * represents the location on the board of the player dots.
     */
    private int[][] dots;
    /**
     * represents the x value index
     */
    private final int XVAL = 0;

    /**
     * represents the y value index
     */
    private final int YVAL = 1;

    private ArrayList<Property> playerMonopolies;

    /**
     * constructor method for the DialogModel, initializes everything to zero
     */
    public MonopolyModel() {
        this.player1 = "Player1";
        this.player2 = "Player2";
        this.player3 = "Player3";
        this.player4 = "Player4";
        this.dice = new Dice();
        this.PlayerList = new ArrayList<Player>();
        PlayerList.add(new Player(0, player1));
        PlayerList.add(new Player(1, player2));
        PlayerList.add(new Player(2, player3));
        PlayerList.add(new Player(3, player4));
        this.game = null;
        this.currPlayerName = "";
        dots = new int[4][2];
        dots[0][XVAL] = 605; //player 1 x
        dots[0][YVAL] = 620; //player 1 y
        dots[1][XVAL] = 605; //player 2 x
        dots[1][YVAL] = 622; //player 2 y
        dots[2][XVAL] = 605; //player 3 x
        dots[2][YVAL] = 624; //player 3 y
        dots[3][XVAL] = 605; //player 4 x
        dots[3][YVAL] = 626; //player 5 y
        this.playerMonopolies = null;
    }
//getters and setters

    public void setPlayerMonopolies(ArrayList<Property> playerMonopolies) {
        this.playerMonopolies = playerMonopolies;
    }

    public ArrayList<Property> getPlayerMonopolies() {
        return playerMonopolies;
    }

    public void setGame(String p1, String p2, String p3, String p4) {
        this.game = new Game(p1, p2, p3, p4);
        this.currPlayerName = p1;
    }

    public void setCurrPlayerName() {
        this.currPlayerName = this.game.getPlayerList().get(
                this.game.getCurrPlayerIndex()).getPlayerName();
    }

    public void setPlayerList(ArrayList<Player> PlayerList) {
        this.PlayerList = PlayerList;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getCurrPlayerName() {
        return currPlayerName;
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<Player> getPlayerList() {
        return PlayerList;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public int[][] getDots() {
        return dots;
    }

    public void setDots(int[][] newDots) {
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[0].length; j++) {
                dots[i][j] = newDots[i][j];
            }

        }
    }

}
