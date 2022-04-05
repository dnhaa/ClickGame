
package clickgame;

import event.Event1;
import java.net.URL;

public class ClickGame {
    public ActionHandler ah = new ActionHandler(this);
    public UI ui = new UI(this);
    public Event1 characterEvent = new Event1(this);
    public SceneChanger sceneChanger = new SceneChanger(this);
    public Player player = new Player(this);
    Music music = new Music();
    SE se = new SE();
    
    //sound
    public URL fieldMusic1 = getClass().getResource("/sound/bensound-evolution.wav");
    public URL fieldMusic2 = getClass().getResource("/sound/footstep.wav");
    public URL absurb = getClass().getResource("/sound/absurd.wav");
    public URL doIKnowYou = getClass().getResource("/sound/do-i-know-you.wav");
    public URL go = getClass().getResource("/sound/go.wav");
    public URL youKillMe = getClass().getResource("/sound/you-kill-me.wav");
    public URL onlyICan = getClass().getResource("/sound/only-i-can.wav");
    public URL gameOver = getClass().getResource("/sound/game-over.wav");
    public URL currentMusic;
    
    public static void main(String[] args) {
        new ClickGame();
    }

    public ClickGame() {
        currentMusic = fieldMusic2;
        playMusic(currentMusic);
        sceneChanger.showScene1();
        player.setPlayerDefaultStatus();
        
    }
    public void playSE(URL url){
        se.setFile(url);
        se.play(url);
    }
    public void playMusic(URL url){
        music.setFile(url);
        music.play(url);
        music.loop(url);
    }
    public void stopMusic(URL url){
        music.stop(url);
    }
    
}
