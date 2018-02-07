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
 * Package: monopoly.utilities
 * File: Card
 * Description: a class that represents a card in chance or community chest
 *
 * ****************************************
 */
/**
 *
 * @author emo006 and slm053
 */
public class Card {
    /**
     * represents the new location th player must go to if the card is a
     * location card
     */
    private int newLocation;
    /**
     * represents the fee or the reward the player has to pay if the card is a
     * pay card
     */
    private int feeReward;

    /**
     * Represents the string of the card to be read.
     */
    private String message;
    /**
     * Boolean value that represents if the action affects location
     */
    private Boolean isLocationCard;

    /**
     * constructor for if the card affects the location of the player ( a
     * location card)
     *
     * @param newLocation
     * @param message
     */
    public Card(int newLocation, String message) {
        this.newLocation = newLocation;
        this.message = message;
        this.isLocationCard = true;

    }

    /**
     * constructor for if the card affects the account of the player ( a pay
     * card)
     *
     * @param feeOrReward
     * @param message
     */
    public Card(String message, int feeOrReward) {
        this.feeReward = feeOrReward;
        this.message = message;
        this.isLocationCard = false;
    }

    /**
     * shows the card as a string
     *
     * @return message that represents what the card says
     */
    @Override
    public String toString() {
        return this.message;
    }

    //Getters
    public int getNewLocation() {
        return newLocation;
    }

    public int getFeeReward() {
        return feeReward;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getIsLocationCard() {
        return isLocationCard;
    }

}
