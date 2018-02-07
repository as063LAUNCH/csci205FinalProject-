package Monopoly.utilities;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 9, 2016
 * Time: 4:00:12 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: CardUtility
 * Description: represents a utility class that helps perform card actions
 *
 * ****************************************
 */
import java.util.ArrayList;

/**
 *
 * @author slm053 and emo006
 */
public final class CardUtility {
    /**
     * function that chooses the card from the list
     *
     * @param cardList
     * @return
     */
    /**
     * represents the current index in the array of cards
     */
    private int currCardIndex;
    /**
     * represents the static index of free space for reference
     */
    private static final int FREE_SPACE_INDEX = 20;

    /**
     * constructor for the utility. In place to set the initial card index
     */
    public CardUtility() {
        this.currCardIndex = 0;
    }

    /**
     * method that chooses a card from cardList
     *
     * @param cardList
     * @return The chosen card
     */
    public Card chooseCard(ArrayList<Card> cardList) {

        if (currCardIndex == cardList.size() - 1) {
            currCardIndex = 0;
        } else {
            currCardIndex++;
        }
        return cardList.get(currCardIndex);

    }

    /**
     * method that displays the card's value
     *
     * @param drawn
     * @return String of the card's value
     */
    public static String displayCard(Card drawn) {
        return drawn.toString();
    }

    /**
     * reads the card, and decides whether the card is a location card or not,
     * acts accordingly
     *
     * @param drawn
     * @param affected
     * @param spaces
     * @throws Monopoly.utilities.InsufficientFundsException
     */
    public static void act(Card drawn, Player affected, ArrayList<Space> spaces) throws InsufficientFundsException {
        if (drawn.getIsLocationCard()) {
            newLocation(drawn, affected);

        } else {
            accountChange(drawn, affected, spaces);
        }
    }

    /**
     * action of the card if it is an accountChange
     *
     * @param drawn
     * @param affected
     */
    private static void accountChange(Card drawn, Player affected,
                                      ArrayList<Space> spaces) throws InsufficientFundsException {
        affected.getBankAccount().deposit(drawn.getFeeReward());
        if (drawn.getFeeReward() < 0) {
            ((Free) spaces.get(FREE_SPACE_INDEX)).addAmount(
                    (-1) * drawn.getFeeReward());
        }
    }

    /**
     * action of the card if it is a location change
     *
     * @param drawn
     * @param affected
     */
    private static void newLocation(Card drawn, Player affected) {
        affected.move(drawn.getNewLocation());

    }
}
