package Monopoly.view;

/**
 *
 * @author slm053
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @see http://stackoverflow.com/questions/2658663
 */
public class BoardImage extends JLabel {
    private static BufferedImage original;
    private BufferedImage image;
    private int[] player1 = new int[2];
    private int[] player2 = new int[2];
    private int[] player3 = new int[2];
    private int[] player4 = new int[2];

    /**
     * constructor class to gather the image
     */
    public BoardImage() {
        try {
            File boardImage = new File(
                    "./src/Monopoly/view/blankMonopolyBoard.jpg");
            original = ImageIO.read(boardImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player1[0] = 620;
        player1[1] = 620;
        player2[0] = 620;
        player2[1] = 640;
        player3[0] = 620;
        player3[1] = 660;
        player4[0] = 620;
        player4[1] = 680;
        image = process(0, player1);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    /**
     * method to process the old image into the new image
     *
     * @param old
     * @return
     */
    public static BufferedImage process(int playerNum,
                                        int[] move) {

        int w = original.getWidth();
        int h = original.getHeight();

        BufferedImage img = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();

        g2d.drawImage(original, 0, 0, null);

        g2d.setPaint(Color.red);
        g2d.fillOval(move[0], move[1], 10, 10);
        g2d.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

    }

    private static void create() {

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void saveImage() throws IOException {
        String fileName = "cool.jpg";
        File file = new File(fileName);
        ImageIO.write(image, "jpg", file);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BoardImage test = new BoardImage();
                f.add(test);
                f.pack();
                f.setVisible(true);
                int[] arr = new int[2];

                arr[0] = 620 - 64;
                arr[1] = 620;

                test.setImage(process(1, arr));

            }
        });
    }
}
