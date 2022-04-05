/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickgame;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author ACER
 */
public class Music {
    Clip clip;
    public void setFile(URL name) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
            
        } catch (Exception e) {
            
        }    
    }
    public void play(URL name) {
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(URL name) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(URL name) {
        clip.stop();
    }
}
