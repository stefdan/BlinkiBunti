/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blinkibunti;

import com.sun.corba.se.impl.util.PackagePrefixChecker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class BlinkiBunti extends JFrame{

    private BlinkingButton button;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlinkiBunti form = new BlinkiBunti();
    }
    
    public BlinkiBunti()
    {
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocation(300, 300);
        this.setVisible(true);
    }
    
    private void init(){
        JPanel currentpanel = new JPanel();
        currentpanel.setBackground(Color.red);
        currentpanel.setLayout(null);
        this.add(currentpanel);
        
        button = new BlinkingButton();
        button.setSize(100, 30);
        button.setLocation(10, 10);
        button.setText("Toggle Blink");
        button.setColors(Color.white, Color.ORANGE, Color.PINK);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!button.isIsblinking())
                    button.setIsblinking(true);
                else
                    button.setIsblinking(false);
            }
        });
        currentpanel.add(button);
                
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while(true){
                    try {
                        counter++;
                        switch(counter){
                            case 1:
                                currentpanel.setBackground(Color.red);
                                break;
                            case 2:
                                currentpanel.setBackground(Color.blue);
                                break;
                            case 3:
                                currentpanel.setBackground(Color.green);
                                break;
                            case 4:
                                currentpanel.setBackground(Color.yellow);
                                break;
                        }
                        if(counter >= 4)counter = 0;
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {}
                }
            }
        });
        //t.start();
    }
    
}
