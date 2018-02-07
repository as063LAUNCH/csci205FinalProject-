package Monopoly.utilities;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 7:37:41 PM
 *
 * Project: csci205FinalProject
 * Package:
 * File: Color
 * Description: represents the colors of each possible monopoly as enums
 *
 * ****************************************
 */
/**
 *
 * @author as063
 */
public enum Color {
    LIGHTBLUE(0, 3), DARKBLUE(0, 2), PURPLE(0, 2), RED(0, 3), MAGENTA(0, 3), ORANGE(
            0, 3), YELLOW(0, 3), GREEN(0, 3);

    private int numOwned;
    private final int maxOwned;

    Color(int numOwned, int maxOwned) {
        this.numOwned = numOwned;
        this.maxOwned = maxOwned;
    }

    int percentOwned() {
        return this.numOwned / this.maxOwned;
    }

    void boughtProperty(Color color) {
        color.numOwned += 1;
    }

}
