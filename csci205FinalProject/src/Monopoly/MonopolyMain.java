/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 15, 2016
 * Time: 8:36:13 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly
 * File: MonopolyMain
 * Description: The main class for running the GUI version of monopoly
 *
 * ****************************************
 */
package Monopoly;

import Monopoly.controller.MonopolyController;
import Monopoly.model.MonopolyModel;
import Monopoly.view.MonopolyView;
import javax.swing.UIManager;

/**
 *
 * @author slm053
 */
public class MonopolyMain {
    /**
     * main method that initializes the view and controller
     *
     * @param args
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            //  if ("Nimbus".equals(info.getName())) {
            //    javax.swing.UIManager.setLookAndFeel(info.getClassName());
            //  break;
            //}
            //}
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MonopolyMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonopolyMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonopolyMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonopolyMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        System.out.println("starting up program...");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MonopolyModel theModel = new MonopolyModel();
                //initialize the view (done)
                MonopolyView theView = new MonopolyView();
                //Iitialize controller
                try {
                    MonopolyController theController = new MonopolyController(
                            theView, theModel);
                } catch (Exception exp) {
                    //
                }

                theView.setVisible(true);
            }
        });
    }

}

// FINAL PROJECT -- COMPLETE!!!
