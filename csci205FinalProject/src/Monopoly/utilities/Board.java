/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:35:33 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Board
 * Description: a file containing the Board Class
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author njb011
 */
public class Board {
    /**
     * represents all of the spaces to be included on the monopoly board
     */
    private final ArrayList<Space> allSpaces;
    /**
     * represents all of the cards to be included for chance and community chest
     */
    private final ArrayList<Card> allCards;

    /**
     * constructor for the Board class (initializes all the values for allSpaces
     * and allCards
     */
    public Board() {
        allCards = new ArrayList<Card>();
        allCards.add(new Card("Computer Crashes. Pay $50 to fix it.", -50));
        allCards.add(new Card("Have to pay for groceries, pay $20", -20));
        allCards.add(new Card("Rent a zipcar! Pay $30 to zipcar.", -30));
        allCards.add(new Card("Need a new desk lamp.", -50));
        allCards.add(new Card("Pay your semesterly dues.", -20));
        allCards.add(
                new Card("You need to buy stationary for finals week.", -23));
        allCards.add(new Card("Take your partner/friends out to a nice dinner.",
                              -25));
        allCards.add(new Card(
                "Late night cravings? Order Dominos",
                -20));
        allCards.add(new Card(
                "It's your roommates' birthday. Throw a party!",
                -20));
        allCards.add(new Card(
                "You received a $100 fine for having a candle in your room.",
                -100));
        allCards.add(new Card("You won a $100 at an ACE raffle!", 100));
        allCards.add(new Card(
                "You covered someone's shift at work",
                20));
        allCards.add(new Card("Free milkshake coupon from 7th Street", 10));
        allCards.add(new Card("You won a $20 award for being excellent!", 20));
        allCards.add(new Card("You won a programming contest, collect $50!", 50));
        allCards.add(new Card(
                "You won the emerging leader award for your organization.", 50));
        allCards.add(new Card(
                "You returned something to the switchboard.  Collect $30 for being a good person!",
                30));
        allCards.add(new Card("You found $10 in your laundry bag.", 10));
        allCards.add(new Card(
                "You won the first position in the innovation design competition. Congratulations!",
                30));
        allCards.add(new Card(
                "You got promoted as the Student Manager in your workplace. Get a bonus!",
                50));
        allSpaces = new ArrayList<Space>();
        //Element at index 0
        allSpaces.add(new GoELC("Go", "ELC", 0)); //jk make this a go space
        //Element at index 1
        allSpaces.add(new Property("Prop", "Harris", 1, Color.PURPLE, 50, 2, 10,
                                   30, 90, 160, 250, 50));
        //Element at index 2
        allSpaces.add(
                new CommunityChest("Chest", "Community Chest", 2, allCards));
        //Element at index 3
        allSpaces.add(
                new Property("Prop", "Larison", 3, Color.PURPLE, 50, 4, 20, 60,
                             180, 320, 450, 50));
        //Element at index 4
        allSpaces.add(new Tax("Tax", "Tax- LostID", 4, 40));
        //Element at index 5
        allSpaces.add(new AcademicProperty("AC", "Olin Science", 5, 200, 50));
        //Element at index 6
        allSpaces.add(
                new Property("Prop", "Larison Cottage", 6, Color.LIGHTBLUE, 100,
                             6, 30, 90, 270, 400, 550, 50));
        //Element at index 7
        allSpaces.add(new Chance("Chance", "Chance", 7, allCards));
        //Element at index 8
        allSpaces.add(
                new Property("Prop", "Galloway", 8, Color.LIGHTBLUE, 100, 6, 30,
                             90, 270, 400, 550, 50));
        //Element at index 9
        allSpaces.add(new Property("Prop",
                                   "E & I House", 9,
                                   Color.LIGHTBLUE, 120, 8, 40, 100, 300, 450,
                                   600, 50));
        //Element at index 10
        allSpaces.add(new Jail("Jail", "BREAKIRON 164 (JAIL)", 10));
        //Element at index 11
        allSpaces.add(
                new Property("Prop", "23rd Avenue", 11, Color.MAGENTA, 140, 10,
                             50, 150, 450, 625, 750, 100));
        //Element at index 12
        allSpaces.add(new Tax("Tax", "Tax - Lost Room Key ", 12, 80));
        //Element at index 13
        allSpaces.add(new Property("Prop", "Martin House", 13, Color.MAGENTA,
                                   140, 10, 50, 150, 450, 625, 750, 100));
        //Element at index 14
        allSpaces.add(
                new Property("Prop", "Carey House", 14, Color.MAGENTA, 160, 12,
                             60, 180, 500, 700, 900, 100));
        //Element at index 15
        allSpaces.add(
                new AcademicProperty("AC", "Dana Engineering", 15, 200, 50));
        //Element at index 16
        allSpaces.add(new Property("Prop", "Bucknell West", 16, Color.ORANGE,
                                   180, 14, 70, 200, 550, 750, 950, 140));
        //Element at index 17
        allSpaces.add(new Chance("Chance", "Chance", 17, allCards));
        //Element at index 18
        allSpaces.add(
                new Property("Prop", "Corner House", 18, Color.ORANGE, 180, 14,
                             70, 200, 550, 750, 950, 140));
        //Element at index 19
        allSpaces.add(new Property("Prop", "Vedder", 19, Color.ORANGE, 200, 16,
                                   80, 220, 600, 800, 1000, 140));
        //Element at index 20
        allSpaces.add(new Free("Free", "Academic Quad - Free Space", 20));
        //Element at index 21
        allSpaces.add(new Property("Prop", "Smith", 21, Color.RED, 220, 18, 90,
                                   250, 700, 875, 1050, 180));
        //Element at index 22
        allSpaces.add(new Chance("Chance", "Chance", 22, allCards));
        //Element at index 23
        allSpaces.add(new Property("Prop", "Trax", 23, Color.RED, 220, 18, 90,
                                   250, 700, 875, 1050, 180));
        //Element at index 24
        allSpaces.add(new Property("Prop", "7th Street", 24, Color.RED, 240, 20,
                                   100, 300, 750, 925, 1100, 180));
        //Element at index 25
        allSpaces.add(new AcademicProperty("AC", "The Library", 25, 200, 50));
        //Element at index 26
        allSpaces.add(new Property("Prop", "Kress", 26, Color.YELLOW, 260, 22,
                                   110, 330, 800, 975, 1150, 200));
        //Element at index 27
        allSpaces.add(new Property("Prop", "Swartz", 27, Color.YELLOW, 260, 22,
                                   110, 330, 800, 975, 1150, 200));
        //Element at index 28
        allSpaces.add(new Tax("Tax", "Tax - Buy Textbook ", 28, 200));
        //Element at index 29
        allSpaces.add(
                new Property("Prop", "Summit House", 29, Color.YELLOW, 280, 24,
                             120, 360, 850, 1025, 1200, 200));
        //Element at index 30
        allSpaces.add(new GoToJail("GoToJail", "GO DO Homework (JAIL)", 30));
        //Element at index 31
        allSpaces.add(new Property("Prop", "McDonell", 31, Color.GREEN, 300, 26,
                                   130, 390, 900, 1100, 1275, 220));
        //Element at index 32
        allSpaces.add(new Property("Prop", "Roberts", 32, Color.GREEN, 300, 26,
                                   130, 390, 900, 1100, 1275, 220));
        //Element at index 33
        allSpaces.add(new CommunityChest("Chest", "Community Chest", 33,
                                         allCards));
        //Element at index 34
        allSpaces.add(new Property("Prop", "Gateways", 34, Color.GREEN, 320, 28,
                                   150, 450, 1000, 1200, 1400, 220));
        //Element at index 35
        allSpaces.add(new AcademicProperty("AC", "Breakiron", 35, 200, 50));
        //Element at index 36
        allSpaces.add(new Chance("Chance", "Chance", 36, allCards));
        //Element at index 37
        allSpaces.add(new Property("Prop", "Demosthenian", 37, Color.DARKBLUE,
                                   350, 35, 175, 500, 1100, 1300, 1500, 280));
        //Element at index 38
        allSpaces.add(new Tax("Tax", "Tax - Tuition", 38, 300));
        //Element at index 39
        allSpaces.add(new Property("Prop", "South Campus Apartments", 39,
                                   Color.DARKBLUE, 400, 50, 200, 600, 1400, 1700,
                                   2000, 300));

    }
    //getters

    public ArrayList<Space> getAllSpaces() {
        return allSpaces;
    }

    public Space getSpace(int index) {
        return allSpaces.get(index);
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }
}
