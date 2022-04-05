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
        
        cg.stopMusic(cg.currentMusic);
        cg.currentMusic = cg.fieldMusic2;
        cg.playMusic(cg.currentMusic);
    }
    public void showScene2() {
        cg.ui.panels[1].setVisible(false);
        cg.ui.panels[2].setVisible(true);
        cg.ui.ta.setText("HAYDN: WAIT, DON'T LEAVE!");
        
        cg.stopMusic(cg.currentMusic);
        cg.currentMusic = cg.fieldMusic2;
        cg.playMusic(cg.currentMusic);
    }
    public void showGameOverScene(int currentBgNum) {
        cg.ui.panels[currentBgNum].setVisible(false);
        cg.ui.titleLabel.setVisible(true);
        cg.ui.titleLabel.setText("YOU DIED");
        cg.ui.restartBtn.setVisible(true);
        cg.ui.restartBtn.setText("RESTART?");
        
        cg.stopMusic(cg.currentMusic);
        cg.playSE(cg.gameOver);
    }
    public void existGameOverScene() {
        cg.ui.titleLabel.setVisible(false);
        cg.ui.restartBtn.setVisible(false);
        cg.player.setPlayerDefaultStatus();
    }
}
