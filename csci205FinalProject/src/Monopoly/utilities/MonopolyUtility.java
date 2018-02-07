/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 15, 2016
 * Time: 9:46:30 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: MonopolyUtility
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author njb011
 */
public class MonopolyUtility {

    /**
     * Checks to see if there is a potential monopoly
     *
     * @return a boolean indicating the status of potential monopolies
     */
    public static boolean potentialMonopoly() {
        Color[] colorList = Color.values();

        for (Color c : colorList) {
            if (c.percentOwned() == 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks to see which colors have a monopoly
     *
     * @return the colors of which a monopoly is owned
     */
    public static ArrayList<Color> findMonopolies() {
        Color[] colorList = Color.values();
        ArrayList<Color> monopolyList = new ArrayList<Color>();

        for (Color c : colorList) {
            if (c.percentOwned() == 1) {
                monopolyList.add(c);
            }
        }
        return monopolyList;
    }

    /**
     * Checks to see which monopolies a specific player has
     *
     * @param player - the player to test
     * @param existingMonopolies - the list of current monopolies by color
     * @return
     */
    public static ArrayList<Property> getPlayerMonopolies(Player player,
                                                          ArrayList<Color> existingMonopolies) {

        ArrayList<Property> playerMonopolies = new ArrayList<Property>();
        ArrayList<Property> eligibleProperties = new ArrayList<Property>();

        for (Space s : player.getPropertiesOwned()) {
            if (s.getType().equals("Prop")) {
                eligibleProperties.add((Property) s);
            } else {
            }
        }

        for (Property p : eligibleProperties) {
            if ((existingMonopolies.contains(p.getColor()))) {
                playerMonopolies.add(p);
            }
        }
        return playerMonopolies;
    }

    public static String buildProperties(ArrayList<Property> propertyList,
                                         Player player) {

        String output = "";
        if (propertyList.isEmpty()) {
            output = String.format("Sorry! You dont have any monopolies!");
        } else {
            output = String.format(
                    "Would you like to build houses on a monopoly? (y or n)");
        }
        return output;
    }

    public static String yesShowProperties(ArrayList<Property> propertyList,
                                           Player player) {
        String output = "";
        int index = 0;
        for (Property p : propertyList) {
            output += String.format(
                    index + ": " + p.getName() + ", " + p.getColor() + ", build price: $" + p.getBuildingPrice() + "\n"
            );
            index++;
        }
        return output;
    }

    public static String noShowProperties(ArrayList<Property> propertyList,
                                          Player player) {
        String output = "OK, build houses later.";
        return output;
    }

    public static String buildHouse(ArrayList<Property> propertyList,
                                    Player player, int propertyIndex) throws IndexOutOfBoundsException, InsufficientFundsException, MaxHousesException {
        Property propToBuild = propertyList.get(
                propertyIndex);
        String output;

        output = "Build house properly purchased, rent incremented";
        player.getBankAccount().withdraw(
                propToBuild.getBuildingPrice());
        propToBuild.incrementNumHouses();
        propToBuild.incrementCurrentRent();

        return output;
    }

}
