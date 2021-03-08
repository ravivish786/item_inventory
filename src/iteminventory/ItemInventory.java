/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteminventory;

import javax.swing.JOptionPane;

/**
 *
 * @author Neeraj
 */
public class ItemInventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SplashFile splashFile =new SplashFile();
        splashFile.setVisible(true);
        
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
                splashFile.processbar.setValue(i);
                splashFile.progessvalue.setText(i+"/100 %");
                if(i==100)
                {
                    splashFile.dispose();
                    new ItemDetails().setVisible(true);
                }
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }
    
}
