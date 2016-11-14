/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blinkibunti;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class BlinkingButton extends JButton {

    private int blinkfrequency = 300;
    private Color[] Colors;
    private boolean isblinking = false;

    public int getBlinkfrequency() {
        return blinkfrequency;
    }

    public Color[] getColors() {
        return Colors;
    }

    public boolean isIsblinking() {
        return isblinking;
    }

    public void setBlinkfrequency(int blinkfrequency) {
        this.blinkfrequency = blinkfrequency;
    }

    public void setColors(Color... Colors) {
        this.Colors = Colors;
    }

    public void setIsblinking(boolean isblinking) {
        if (this.isblinking == isblinking) {
            return;
        }
        if (isblinking) {
            this.isblinking = true;
            setMeBlinking();
        } else {
            this.isblinking = false;
        }
    }

    private void setMeBlinking() {
        if (Colors == null) {
            setColors(Color.RED, Color.BLUE);
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int indexcounter = 0;
                while (isblinking) {
                    if(indexcounter >= Colors.length)indexcounter = 0;
                    try {
                        BlinkingButton.this.setBackground(Colors[indexcounter++]);
                        Thread.sleep(blinkfrequency);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        t.start();

    }

}
