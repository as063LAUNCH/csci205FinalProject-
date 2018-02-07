/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 15, 2016
 * Time: 8:34:57 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.controller
 * File: MonopolyController
 * Description:  The controller for the monopoly game
 *
 * ****************************************
 */
/*




 */
package Monopoly.controller;

import Monopoly.model.MonopolyModel;
import Monopoly.utilities.AcademicProperty;
import Monopoly.utilities.Chance;
import Monopoly.utilities.Color;
import Monopoly.utilities.CommunityChest;
import Monopoly.utilities.Free;
import Monopoly.utilities.GoELC;
import Monopoly.utilities.GoToJail;
import Monopoly.utilities.InsufficientFundsException;
import Monopoly.utilities.Jail;
import Monopoly.utilities.MaxHousesException;
import Monopoly.utilities.MonopolyUtility;
import Monopoly.utilities.MoveUtility;
import Monopoly.utilities.Property;
import Monopoly.utilities.Tax;
import Monopoly.view.LblBoard;
import Monopoly.view.MonopolyView;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author slm053
 */
public class MonopolyController implements ActionListener {

    /**
     * represents the view
     */
    private MonopolyView theView;

    /**
     * represents the model of the game
     */
    private MonopolyModel theModel;
    /**
     * represents the utility used for the dots
     */
    private MoveUtility moveUtility;

    /**
     * represents the board with moving players
     */
    private LblBoard viewBoard;

    /**
     * The constructor for the Monopoly Controller
     *
     * @param theView the view
     * @param theModel the model
     */
    public MonopolyController(MonopolyView theView,
                              MonopolyModel theModel) throws Exception {
        this.theModel = theModel;
        this.theView = theView;
        this.viewBoard = new LblBoard();
        this.moveUtility = new MoveUtility();
        /*
         Welcome welcomeAnimation = new Welcome();
         welcomeAnimation.mainMethod();
         welcomeAnimation.getAnimation().setVisible(true);
         int response = welcomeAnimation.getResponse();
         if (response == JOptionPane.OK_OPTION) {
         welcomeAnimation.getAnimation().setVisible(false);
         welcomeAnimation.getAnimation();
         }
         */

        theView.getPlayDialog().setLocationRelativeTo(null);
        theView.getPlayDialog().setVisible(true);
        theView.getPlayBtn().addActionListener(this);
        theView.getExitBtn().addActionListener(this);
        theView.getRollDiceButton().addActionListener(this);
        theView.getMakeMoveButton().addActionListener(this);
        theView.getPayRentEndTurnButton().addActionListener(this);
        theView.getPropPurchaseYesButton().addActionListener(this);
        theView.getPropPurchaseNoButton().addActionListener(this);
        theView.getPropPurchaseEndTurnButton().addActionListener(this);
        theView.getGenPopupEndTurnButton().addActionListener(this);
        theView.getEndGameButton().addActionListener(this);
        theView.getQuitGameButton().addActionListener(this);
        theView.getCheckForMonopBttn().addActionListener(this);
        theView.getNoMonopOkBttn().addActionListener(this);
        theView.getMonopYesBttn().addActionListener(this);
        theView.getMonopNoBttn().addActionListener(this);
        theView.getBuildBttn().addActionListener(this);
        updateViewFromModel();
        updateBoard();
    }

    /**
     * method that initializes the game model
     *
     * @throws Monopoly.utilities.InsufficientFundsException
     */
    public void setUpGame() throws InsufficientFundsException {
        theModel.setGame(theModel.getPlayerList().get(0).getPlayerName(),
                         theModel.getPlayerList().get(1).getPlayerName(),
                         theModel.getPlayerList().get(2).getPlayerName(),
                         theModel.getPlayerList().get(3).getPlayerName());
    }

    /**
     * method that updates the view based on the model
     */
    public void updateViewFromModel() {
        if (theModel == null) {
            try {

            } catch (Exception ex) {
                Logger.getLogger(MonopolyController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }
        } //updates the player's stats
    }

    /**
     * method that performs actions based on the action performed
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cards = (CardLayout) theView.getMessagesPanel().getLayout();

        //for when the play button is hit
        if (e.getSource() == theView.getPlayBtn()) {
            theModel.setPlayer1(theView.getTxtP1().getText());
            theModel.setPlayer2(theView.getTxtP2().getText());
            theModel.setPlayer3(theView.getTxtP3().getText());
            theModel.setPlayer4(theView.getTxtP4().getText());
            theView.getP1StatsTitleLbl().setText(theView.getTxtP1().getText());
            theView.getP2StatsTitleLbl().setText(theView.getTxtP2().getText());
            theView.getP3StatsTitleLbl().setText(theView.getTxtP3().getText());
            theView.getP4StatsTitleLbl().setText(theView.getTxtP4().getText());

            String p1 = (theView.getTxtP1().getText());
            String p2 = (theView.getTxtP2().getText());
            String p3 = (theView.getTxtP3().getText());
            String p4 = (theView.getTxtP4().getText());

            theModel.setGame(p1, p2, p3, p4);
            System.out.format(theModel.getGame().getPlayerList().get(
                    theModel.getGame().getCurrPlayerIndex()).getPlayerName());
            theView.getCurrPlayerNameLabel().setText(
                    theModel.getCurrPlayerName());
            theView.getPlayDialog().dispose();

// ==========================================================================================================
        } else if (e.getSource() == theView.getExitBtn()) {
            theView.getPlayDialog().dispose();
            JOptionPane.showMessageDialog(null, "Goodbye!", "Goodbye!",
                                          JOptionPane.INFORMATION_MESSAGE);
            theView.dispose();

// ==========================================================================================================
        } else if (e.getSource() == theView.getCheckForMonopBttn()) {
            //if (MonopolyUtility.potentialMonopoly() == true) {
            ArrayList<Color> existingMonopolies = MonopolyUtility.findMonopolies();
            theView.getMessagesPanel().setVisible(true);
            theModel.setPlayerMonopolies(
                    MonopolyUtility.getPlayerMonopolies(
                            theModel.getGame().getPlayerList().get(
                                    theModel.getGame().getCurrPlayerIndex()),
                            existingMonopolies
                    ));
            String output = MonopolyUtility.buildProperties(
                    theModel.getPlayerMonopolies(),
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()));
            if (theModel.getPlayerMonopolies().isEmpty()) {
                //have just reg popup window here
                theView.getNoMonopLabel().setText(output);
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            } else {
                theView.getMonopLabel().setText(output);
                cards.show(theView.getMessagesPanel(), "checkMonopolyCard");
            }

// ==========================================================================================================
        } else if (e.getSource() == theView.getMonopYesBttn()) {
            //add in yes button popup
            cards.show(theView.getMessagesPanel(), "yesMonopolyCard");
            String output = MonopolyUtility.yesShowProperties(
                    theModel.getPlayerMonopolies(),
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()));
            theView.getYesMonopArea().setText(output);

// ===========================================================================================================
        } else if (e.getSource() == theView.getBuildBttn()) {
            String output = "";
            try {
                int index = Integer.parseInt(
                        theView.getYesMonopField().getText());
                output = MonopolyUtility.buildHouse(
                        theModel.getPlayerMonopolies(),
                        theModel.getGame().getPlayerList().get(
                                theModel.getGame().getCurrPlayerIndex()), index);
                theView.getNoMonopLabel().setText(output);
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            } catch (NumberFormatException ex) {
                theView.getNoMonopLabel().setText("ERROR: Invalid selection");
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            } catch (IndexOutOfBoundsException ex) {
                theView.getNoMonopLabel().setText(
                        "ERROR! Property you selected isn't available.");
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            } catch (InsufficientFundsException ex) {
                theView.getNoMonopLabel().setText(
                        "ERROR! Insufficient funds.  Transaction canceled.");
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            } catch (MaxHousesException ex) {
                theView.getNoMonopLabel().setText(
                        "ERROR: This property already has the max number of houses! Transaction Canceled");
                cards.show(theView.getMessagesPanel(), "noMonopolyCard");
            }
// ============================================================================================================
        } else if (e.getSource() == theView.getMonopNoBttn()) {
            //add in no button popup
            String output = MonopolyUtility.noShowProperties(
                    theModel.getPlayerMonopolies(),
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()));
            theView.getNoMonopLabel().setText(output);
            cards.show(theView.getMessagesPanel(), "noMonopolyCard");

// ==============================================================================================================
        } else if (e.getSource() == theView.getNoMonopOkBttn()) {
            cards.first(theView.getMessagesPanel());
            theView.getMessagesPanel().setVisible(false);

// ==============================================================================================================
        } else if (e.getSource() == theView.getPropPurchaseNoButton()) {
            theView.getGenPopupLabel().setText(
                    "<html>" + "You chose not to buy the property at this time." + "<html>");
            //theView.getPropDialog().setVisible(false);
            cards.show(theView.getMessagesPanel(), "generalPopupCard");

// ================================================================================================================
        } else if (e.getSource() == theView.getPropPurchaseYesButton()) {
            try {
                if (theModel.getGame().getCurrSpace().getType().equals(
                        "Prop")) {
                    ((Property) theModel.getGame().getCurrSpace()).purchaseProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                } else {
                    ((AcademicProperty) theModel.getGame().getCurrSpace()).purchaseACProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                }
                //theView.getPropDialog().setVisible(false);
                cards.show(theView.getMessagesPanel(), "buyPropCard");
            } catch (InsufficientFundsException exception) {
                theView.getGenPopupLabel().setText(
                        "<html>" + "You do not have enough funds to implement this action" + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            }

// =================================================================================================================
        } else if (e.getSource() // End game button
                   == theView.getEndGameButton()) {
            //show popup window for ending the game
            theView.getMessagesPanel().setVisible(true);
            String winner = theModel.getGame().getFinalStats();
            theView.getFirstPlaceLabel().setText(winner);
            cards.last(theView.getMessagesPanel());
            cards.show(theView.getMessagesPanel(), "endGameCard");

// ==================================================================================================================
        } else if (e.getSource() // Quit game button
                   == theView.getQuitGameButton()) {
            cards.show(theView.getMessagesPanel(), "endGameCard");
            theView.getPlayDialog().dispose();
            JOptionPane.showMessageDialog(null, "Goodbye!", "Goodbye!",
                                          JOptionPane.INFORMATION_MESSAGE);
            theView.dispose();

// ===================================================================================================================
        } else if (e.getSource() // Rolling the dice
                   == theView.getRollDiceButton()) {
            theView.getMessagesPanel().setVisible(true);
            theView.getRollDiceButton().setVisible(false);
            theView.getCheckForMonopBttn().setVisible(false);
            cards.show(theView.getMessagesPanel(), "rollDiceCard");
            if (theModel.getGame().getPlayerList().get(
                    theModel.getGame().getCurrPlayerIndex()).isIsBankrupt()) {
                String output = String.format(
                        "ERROR: %s is bankrupt.  Skip their turn.",
                        theModel.getGame().getPlayerList().get(
                                theModel.getGame().getCurrPlayerIndex()).getPlayerName());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
                theModel.setDots(moveUtility.bankruptUodateDots(
                        theModel.getDots(),
                        theModel.getGame().getCurrPlayerIndex()));

            } else {
                try {
                    String output = theModel.getGame().takeTurn();
                    int[] rollAll = theModel.getGame().getCurrDiceRoll();
                    if (rollAll[0] == 1) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice1.jpg"))));
                    } else if (rollAll[0] == 2) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice2.jpg"))));
                    } else if (rollAll[0] == 3) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice3.jpg"))));
                    } else if (rollAll[0] == 4) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice4.jpg"))));
                    } else if (rollAll[0] == 5) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice5.jpg"))));
                    } else if (rollAll[0] == 6) {
                        theView.getDice1Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice6.jpg"))));
                    }
                    if (rollAll[1] == 1) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice1.jpg"))));
                    } else if (rollAll[1] == 2) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice2.jpg"))));
                    } else if (rollAll[1] == 3) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice3.jpg"))));
                    } else if (rollAll[1] == 4) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice4.jpg"))));
                    } else if (rollAll[1] == 5) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice5.jpg"))));
                    } else if (rollAll[1] == 6) {
                        theView.getDice2Lbl().setIcon(new ImageIcon(
                                ImageIO.read(
                                        new File("./src/Monopoly/view/Dice6.jpg"))));
                    }
                    //set the current roller label
                    if (!(theModel.getGame().getPlayerList().get(
                          theModel.getGame().getCurrPlayerIndex()).isIsInJail())) {
                        //set the roll outcome label

                        // ATTEMPT AT UPDATING LOCATION LIST
                        //get rolled
                        int rolled = theModel.getGame().getCurrTotalDiceRoll();
                        //dots --> update the model
                        theModel.setDots(moveUtility.updateDots(rolled,
                                                                theModel.getDots(),
                                                                theModel.getGame().getCurrPlayerIndex()));

                        updateBoard();
                        //end of updating

                    } else {

                        if (!(theModel.getGame().getPlayerList().get(
                              theModel.getGame().getCurrPlayerIndex()).isIsInJail())) {
                        } else {

                            theView.getGenPopupLabel().setText(
                                    "<html>" + output + "<html>");
                            cards.show(theView.getMessagesPanel(),
                                       "generalPopupCard");

                            theModel.setDots(moveUtility.jailUpdateDots(
                                    theModel.getDots(),
                                    theModel.getGame().getCurrPlayerIndex()));
                            updateBoard();

                        }

                    }
                } catch (InsufficientFundsException exception) {
                    String output = String.format(
                            "ERROR! Insufficient funds.  Transaction canceled.");
                    theView.getGenPopupLabel().setText(
                            "<html>" + output + "<html>");
                    cards.show(theView.getMessagesPanel(), "generalPopupCard");
                } catch (IOException ex) {
                    Logger.getLogger(MonopolyController.class.getName()).log(
                            Level.SEVERE,
                            null,
                            ex);
                }
            }

// =====================================================================================================================================
        } else if (e.getSource() // Attempting to move
                   == theView.getMakeMoveButton()) {
            cards.show(theView.getMessagesPanel(), "landOnPropCard");

            if (theModel.getGame().getCurrSpace().getType().equals("Prop")) {
                if (theModel.getGame().getPlayerList().get(
                        theModel.getGame().getCurrPlayerIndex()).getPlayerNumber() == ((Property) theModel.getGame().getCurrSpace()).getOwnerID()) {
                    theView.getGenPopupLabel().setText(
                            "<html>" + "Player already owns this space." + "<html>");
                    cards.show(theView.getMessagesPanel(), "generalPopupCard");
                } else if (((Property) theModel.getGame().getCurrSpace()).isPurchased()) {
                    //property must pay rent on this
                    String output = ((Property) theModel.getGame().getCurrSpace()).payRentOnProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                    //popup window for paying rent
                    System.out.format("%s",
                                      theModel.getGame().getCurrSpace().getSpaceName());
                    String location = String.format("You landed on %s\n",
                                                    theModel.getGame().getCurrSpace().getSpaceName());
                    theView.getPayRentLocationLabel().setText(location);
                    theView.getPayRentOutcomeLabel().setText(output);
                    cards.show(theView.getMessagesPanel(), "payRentCard");
                } else {
                    //show popup window for property
                    theView.getPropNameLabel().setText(
                            theModel.getGame().getCurrSpace().getSpaceName());
                    theView.getPropPriceLabel().setText(String.valueOf(
                            ((Property) theModel.getGame().getCurrSpace()).getPrice()));
                    cards.show(theView.getMessagesPanel(), "landOnPropCard");
                    //theView.getPropDialog().pack();
                }
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "GoToJail")) {
                String output = ((GoToJail) theModel.getGame().getCurrSpace()).sendToJail(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Jail")) {
                String output = ((Jail) theModel.getGame().getCurrSpace()).landOnJail(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "AC")) {
                if (theModel.getGame().getPlayerList().get(
                        theModel.getGame().getCurrPlayerIndex()).getPlayerNumber() == ((AcademicProperty) theModel.getGame().getCurrSpace()).getOwnerID()) {
                    theView.getGenPopupLabel().setText(
                            "<html>" + "Player already owns this space." + "<html>");
                    cards.show(theView.getMessagesPanel(), "generalPopupCard");
                } else if (((AcademicProperty) theModel.getGame().getCurrSpace()).isPurchased()) {
                    String output = ((AcademicProperty) theModel.getGame().getCurrSpace()).payRentOnACProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                    String location = String.format("You landed on %s\n",
                                                    theModel.getGame().getCurrSpace().getSpaceName());
                    theView.getPayRentLocationLabel().setText(location);
                    theView.getPayRentOutcomeLabel().setText(output);
                    cards.show(theView.getMessagesPanel(), "payRentCard");
                } else {
                    theView.getPropNameLabel().setText(
                            theModel.getGame().getCurrSpace().getSpaceName());
                    theView.getPropPriceLabel().setText(String.valueOf(
                            ((AcademicProperty) theModel.getGame().getCurrSpace()).getPrice()));
                    cards.show(theView.getMessagesPanel(), "landOnPropCard");
                }
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Tax")) {
                try {
                    String output = ((Tax) theModel.getGame().getCurrSpace()).landOnTax(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                    String overview = String.format(
                            "You landed on a tax space: %s. %s",
                            theModel.getGame().getCurrSpace().getSpaceName(),
                            output);
                    theView.getGenPopupLabel().setText(
                            "<html>" + overview + "<html>");
                    cards.show(theView.getMessagesPanel(), "generalPopupCard");
                } catch (InsufficientFundsException exception) {
                    String output = String.format(
                            "ERROR! Insufficient funds.  Transaction canceled.");
                    theView.getGenPopupLabel().setText(
                            "<html>" + output + "<html>");
                    cards.show(theView.getMessagesPanel(), "generalPopupCard");
                }
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Chance")) {
                String output = ((Chance) theModel.getGame().getCurrSpace()).landOnChance(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex(),
                        theModel.getGame().getBoard().getAllSpaces());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Chest")) {
                String output = ((CommunityChest) theModel.getGame().getCurrSpace()).landOnCommunityChest(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex(),
                        theModel.getGame().getBoard().getAllSpaces());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Free")) {
                String output = ((Free) theModel.getGame().getCurrSpace()).landOnFree(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            } else if (theModel.getGame().getCurrSpace().getType().equals(
                    "Go")) {
                String output = ((GoELC) theModel.getGame().getCurrSpace()).landOnGo(
                        theModel.getGame().getPlayerList(),
                        theModel.getGame().getCurrPlayerIndex());
                theView.getGenPopupLabel().setText("<html>" + output + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            }

// ==========================================================================================================================
        } else if (e.getSource() // 'NO' response to purchasing a property
                   == theView.getPropPurchaseNoButton()) {
            theView.getGenPopupLabel().setText(
                    "<html>" + "You chose not to purchase this property" + "<html>");
            //theView.getPropDialog().setVisible(false);
            cards.show(theView.getMessagesPanel(), "generalPopupCard");

// ============================================================================================================================
        } else if (e.getSource() // 'YES' response to purchasing a property
                   == theView.getPropPurchaseYesButton()) {
            try {
                if (theModel.getGame().getCurrSpace().getType().equals(
                        "Prop")) {
                    ((Property) theModel.getGame().getCurrSpace()).purchaseProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                } else {
                    ((AcademicProperty) theModel.getGame().getCurrSpace()).purchaseACProperty(
                            theModel.getGame().getPlayerList(),
                            theModel.getGame().getCurrPlayerIndex());
                }
                cards.show(theView.getMessagesPanel(), "buyPropCard");
            } catch (InsufficientFundsException exception) {
                theView.getGenPopupLabel().setText(
                        "<html>" + "You do not have enough funds to implement this action" + "<html>");
                cards.show(theView.getMessagesPanel(), "generalPopupCard");
            }

            // ALL THESE IF STATEMENTS SWAP TO NEXT PLAYER'S TURN
            // THESE ARE VERY IMPORTANT TO END A TURN AND UPDATE PLAYER STATS
// ==================================================================================================================
        } else if (e.getSource()
                   == theView.getGenPopupEndTurnButton()) {
            this.updateStats();
            theView.getMessagesPanel().setVisible(false);
            theView.getRollDiceButton().setVisible(true);
            theView.getCheckForMonopBttn().setVisible(true);
            cards.first(theView.getMessagesPanel());
            theModel.getGame().moveToNextTurn();
            theModel.setCurrPlayerName();
            System.out.format("%s\n",
                              theModel.getGame().getPlayerList().get(
                                      theModel.getGame().getCurrPlayerIndex()).getPlayerName());
            theView.getCurrPlayerNameLabel().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPlayerName());

// =======================================================================================================================
        } else if (e.getSource()
                   == theView.getPropPurchaseEndTurnButton()) {
            this.updateStats();
            theView.getMessagesPanel().setVisible(false);
            theView.getRollDiceButton().setVisible(true);
            theView.getCheckForMonopBttn().setVisible(true);
            cards.first(theView.getMessagesPanel());
            theModel.getGame().moveToNextTurn();
            theModel.setCurrPlayerName();
            System.out.format("%s\n",
                              theModel.getGame().getPlayerList().get(
                                      theModel.getGame().getCurrPlayerIndex()).getPlayerName());
            theView.getCurrPlayerNameLabel().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPlayerName());

// ========================================================================================================================
        } else if (e.getSource()
                   == theView.getPayRentEndTurnButton()) {
            theView.getMessagesPanel().setVisible(false);
            theView.getCheckForMonopBttn().setVisible(true);
            theView.getRollDiceButton().setVisible(true);
            cards.first(theView.getMessagesPanel());
            this.updateStats();
            theModel.getGame().moveToNextTurn();
            theModel.setCurrPlayerName();
            System.out.format("%s\n",
                              theModel.getGame().getPlayerList().get(
                                      theModel.getGame().getCurrPlayerIndex()).getPlayerName());
            theView.getCurrPlayerNameLabel().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPlayerName());
        }

        updateViewFromModel();
    }

    public void updateStats() {
        //update player stats bank account
        theView.getP1BalanceLbl().setText(String.valueOf(
                theModel.getGame().getPlayerList().get(
                        0).getBankAccount().getBalance())
        );
        theView.getP2BalanceLbl().setText(String.valueOf(
                theModel.getGame().getPlayerList().get(
                        1).getBankAccount().getBalance())
        );
        theView.getP3BalanceLbl().setText(String.valueOf(
                theModel.getGame().getPlayerList().get(
                        2).getBankAccount().getBalance())
        );
        theView.getP4BalanceLbl().setText(String.valueOf(
                theModel.getGame().getPlayerList().get(
                        3).getBankAccount().getBalance())
        );

        theView.getP1IsInJailLbl().setText(
                theModel.getGame().getPlayerList().get(0).jailStats());
        theView.getP2IsInJailLbl().setText(
                theModel.getGame().getPlayerList().get(1).jailStats());
        theView.getP3IsInJailLbl().setText(
                theModel.getGame().getPlayerList().get(2).jailStats());
        theView.getP4IsInJailLbl().setText(
                theModel.getGame().getPlayerList().get(3).jailStats());
        //update player stats current space
        if (theModel.getGame().getCurrPlayerIndex() == 0) {
            theView.getP1LocationLbl().setText(
                    theModel.getGame().getCurrSpace().getSpaceName());
        } else if (theModel.getGame().getCurrPlayerIndex() == 1) {
            theView.getP2LocationLbl().setText(
                    theModel.getGame().getCurrSpace().getSpaceName());
        } else if (theModel.getGame().getCurrPlayerIndex() == 2) {
            theView.getP3LocationLbl().setText(
                    theModel.getGame().getCurrSpace().getSpaceName());
        } else if (theModel.getGame().getCurrPlayerIndex() == 3) {
            theView.getP4LocationLbl().setText(
                    theModel.getGame().getCurrSpace().getSpaceName());
        }

        if (theModel.getGame().getCurrPlayerIndex() == 0) {
            theView.getP1PropOwnedArea().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPropOwnedStats());
        } else if (theModel.getGame().getCurrPlayerIndex() == 1) {
            theView.getP2PropOwnedArea().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPropOwnedStats());
        } else if (theModel.getGame().getCurrPlayerIndex() == 2) {
            theView.getP3PropOwnedArea().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPropOwnedStats());
        } else if (theModel.getGame().getCurrPlayerIndex() == 3) {
            theView.getP4PropOwnedArea().setText(
                    theModel.getGame().getPlayerList().get(
                            theModel.getGame().getCurrPlayerIndex()).getPropOwnedStats());
        }

        //update community pot amount
        theView.getCommunityPotAmtLabel().setText(String.valueOf(
                ((Free) theModel.getGame().getBoard().getAllSpaces().get(
                 20)).getAmount()));

    }

    /**
     * method that updates the Board (by extention the view) to reflect the
     * movement of the players
     */
    public void updateBoard() {
        try {
            BufferedImage updated = viewBoard.process(
                    theModel.getDots());
            theView.getBoardImg().setIcon(new ImageIcon(updated));

        } catch (IOException ex) {
            Logger.getLogger(MonopolyController.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
        }

    }
}
