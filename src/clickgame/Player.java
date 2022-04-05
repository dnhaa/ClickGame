/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickgame;

import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class Player {
    ClickGame cg;
    
    public int playerMaxLife;
    public int playerLife;
    
    public boolean hasRope;
    public boolean hasTorch;
    public boolean hasEgg;
    public boolean hasKnife;
    

    public Player(ClickGame cg) {
        this.cg = cg;
    }
    public void setPlayerDefaultStatus() {
        playerMaxLife = 5;
        playerLife = 3;
        hasEgg = false;
        hasKnife = false;
        hasEgg = false;
        hasTorch = false;
        
        updatePlayerStatus();
    }
    public void updatePlayerStatus() {
        //remove all life icon
        for (int i = 0; i < 5; i++) {
            cg.ui.lifeLabel[i] = new JLabel();
            cg.ui.lifeLabel[i].setVisible(false);
        }
        int lifeCount = playerLife;
        
        while (lifeCount  != 0) {
//            System.out.println(lifeCount);
            cg.ui.lifeLabel[lifeCount] = new JLabel();
            cg.ui.lifeLabel[lifeCount].setVisible(true);
            lifeCount--;
        }
        
        //check player's items
        if (!hasKnife)
            cg.ui.knifeLabel.setVisible(false);
        if (!hasRope)
            cg.ui.ropeLabel.setVisible(false);
        if (!hasTorch)
            cg.ui.torchLabel.setVisible(false);
        if (!hasEgg)
            cg.ui.eggLabel.setVisible(false);
    }
    
}
