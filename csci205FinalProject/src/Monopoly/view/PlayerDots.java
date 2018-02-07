/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 23, 2016
 * Time: 6:01:32 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.view
 * File: PlayerDots
 * Description:
 * A file that contains the drawing for the player dots
 * ****************************************
 */
package Monopoly.view;

/**
 *
 * @author slm053
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 * component class for the traffic light
 *
 * @author slm053
 */
public class PlayerDots extends JComponent {
    private final Color color;

    /**
     * constructor class for playerDots. Basically takes in what number the
     * player is to set what the color is going to be
     *
     * @param playerNum
     */
    public PlayerDots(int playerNum) {
        if (playerNum == 1) {
            this.color = Color.RED;
        } else if (playerNum == 2) {
            this.color = Color.CYAN;
        } else if (playerNum == 3) {
            this.color = Color.GREEN;
        } else {
            this.color = Color.YELLOW;

        }
    }

    /**
     * method that overrides the paintComponent in order to color the component
     * and construct it
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        //how to get the graphics, and
        Graphics2D graphics = (Graphics2D) g;

        Ellipse2D.Double dot = new Ellipse2D.Double(0, 0, 10, 10);

        graphics.setColor(this.color);
        graphics.fill(dot);

    }

}
