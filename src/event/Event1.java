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
        cg.ui.ta.setText("DO I KNOW YOU?");
    }
    public void saveCharacter() {
        cg.ui.ta.setText("YOU SHOULD NOT SAVE ME. LEAVE NOW!");
    }
    public void killCharacter() {
        cg.ui.ta.setText("YOU? KILL ME? HAHAHAHA!");
    }
    
}
