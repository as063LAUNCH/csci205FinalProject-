package Monopoly.utilities;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:34:56 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Space
 * Description: a file containing the Space class
 *
 * ****************************************
 */
/**
 *
 * @author njb011
 */
public class Space {
    /**
     * represents the name of the space
     */
    private String spaceName;
    /**
     * represents the name of the space
     */
    private String type;
    /**
     * represents the location of the space on the board
     */
    private int spaceLocation;

    /**
     * constructor for a Space instance
     *
     * @param name
     * @param location
     * @param type
     */
    public Space(String name, int location, String type) {
        this.spaceName = name;
        this.spaceLocation = location;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    Space(String elc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSpaceName() {
        return spaceName;
    }

    public int getSpaceLocation() {
        return spaceLocation;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public void setSpaceLocation(int spaceLocation) {
        this.spaceLocation = spaceLocation;
    }

}
