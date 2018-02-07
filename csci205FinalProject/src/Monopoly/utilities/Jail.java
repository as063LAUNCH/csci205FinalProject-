/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 14, 2016
 * Time: 7:24:25 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Jail
 * Description:
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author emo006
 */
public class Jail extends Space {
    /**
     * represents the actual Jail space constructor
     *
     * @param type
     * @param name
     * @param location
     */
    public Jail(String type, String name, int location) {
        super(name, location, type);
    }

    /**
     * represents the unfortunate action for players currently on this space.
     *
     * @param players
     * @param index
     * @return
     */
    public String landOnJail(ArrayList<Player> players, int index) {
        String output = String.format("%s is just passing through jail.\n",
                                      players.get(
                                              index).getPlayerName());
        return output;
    }

}
