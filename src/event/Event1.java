/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import clickgame.ClickGame;

/**
 *
 * @author ACER
 */
public class Event1 {
    ClickGame cg;
    public Event1(ClickGame cg) {
        this.cg = cg;
    }
    public void greetCharacter() {
        cg.player.hasRope = true;
        cg.ui.ta.setText("HAYDN: DO I KNOW YOU? GO HANG YOURSELF.");
        cg.playSE(cg.doIKnowYou);
        cg.player.updatePlayerStatus();
    }
    public void saveCharacter() {
        if (cg.player.playerLife != cg.player.playerMaxLife){
            cg.player.playerLife ++;
            cg.ui.ta.setText("HAYDN: YOU CANNOT SAVE ME. ONLY I CAN SAVE YOU!");
            cg.playSE(cg.onlyICan);
            cg.player.updatePlayerStatus();
        } else {
            cg.ui.ta.setText("HAYDN: I HAVE DONE EVERYTHING TO SAVE YOU. GO!");
            cg.playSE(cg.go);
        }
    }
    public void killCharacter() {
        if (cg.player.playerLife != 1) {
            cg.player.playerLife--;
            cg.ui.ta.setText("HAYDN: YOU? KILL ME? HAHAHAHA! \n\nYOU GOT STABBED.");
            cg.playSE(cg.youKillMe);
            cg.player.updatePlayerStatus();  
        }
        else if (cg.player.playerLife == 1) {
            cg.ui.ta.setText("HAYDN: ABSURD!");
            cg.playSE(cg.absurb);
            cg.player.playerLife --;
            cg.player.updatePlayerStatus();
            cg.sceneChanger.showGameOverScene(1);
        }
    }
    
}
