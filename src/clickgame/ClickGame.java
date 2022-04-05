
package clickgame;

import event.Event1;

public class ClickGame {
    public ActionHandler ah = new ActionHandler(this);
    public UI ui = new UI(this);
    public Event1 characterEvent = new Event1(this);
    public SceneChanger sceneChanger = new SceneChanger(this);
    public Player player = new Player(this);
    public static void main(String[] args) {
        new ClickGame();
    }

    public ClickGame() {
        player.setPlayerDefaultStatus();
    }
    
}
