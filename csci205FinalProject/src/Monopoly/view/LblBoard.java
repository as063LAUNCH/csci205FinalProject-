/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: NAMES of team members
 * Date: Apr 24, 2016
 * Time: 12:18:50 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.view
 * File: LblBoard
 * Description:
 *
 * ****************************************
 */
package Monopoly.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author slm053
 */
public class LblBoard extends JLabel {

    /**
     * represents the original monopoly board
     */
    private static BufferedImage original;
    /**
     * represents the processed image overlay of players on the board
     */
    private BufferedImage image;

    /**
     * represents the x value index
     */
    private final int XVAL = 0;

    /**
     * represents the y value index
     */
    private final int YVAL = 1;

    /**
     * Creates new form boardPnlMonopoly
     */
    public LblBoard() {
        super();

        try {
            File boardImage = new File(
                    "./src/Monopoly/view/blankMonopolyBoard.jpg");
            original = ImageIO.read(boardImage);
            image = ImageIO.read(boardImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    public BufferedImage process(int[][] dots) throws IOException {
        int w = original.getWidth();
        int h = original.getHeight();

        BufferedImage img = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();

        g2d.drawImage(original, 0, 0, null);

        g2d.setPaint(Color.RED);
        g2d.fillOval(dots[0][XVAL], dots[0][YVAL], 10, 10);
        g2d.setPaint(Color.CYAN);
        g2d.fillOval(dots[1][XVAL], dots[1][YVAL], 10, 10);
        g2d.setPaint(Color.GREEN);
        g2d.fillOval(dots[2][XVAL], dots[2][YVAL], 10, 10);
        g2d.setPaint(Color.YELLOW);
        g2d.fillOval(dots[3][XVAL], dots[3][YVAL], 10, 10);
        int[][] temp = dots;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                //System.out.println("in [" + i + "][ " + j + "] : " + temp[i][j]);
            }
        }
        g2d.dispose();
        //saveImage();
        return img;
    }

    /**
     * method that paints the image
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void saveImage() throws IOException {
        String fileName = "./src/Monopoly/view/MonopolyBoard.jpg";
        File file = new File(fileName);
        ImageIO.write(image, "jpg", file);

    }

}
