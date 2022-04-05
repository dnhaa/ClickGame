/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickgame;

/**
 *
 * @author ACER
 */
public class SceneChanger {
    ClickGame cg;

    public SceneChanger(ClickGame cg) {
        this.cg = cg;
    }
    public void showScene1() {
        cg.ui.panels[1].setVisible(true);
        cg.ui.panels[2].setVisible(false);
        cg.ui.ta.setText("HAYDN: YOU ARE BACK. HOW DO YOU FEEL?");
    }
    public void showScene2() {
        cg.ui.panels[1].setVisible(false);
        cg.ui.panels[2].setVisible(true);
        cg.ui.ta.setText("HAYDN: WAIT, DON'T LEAVE!");
    }
}
