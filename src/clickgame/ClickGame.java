
package clickgame;

import event.CharacterEvent;

public class ClickGame {
    public ActionHandler ah = new ActionHandler(this);
    public UI ui = new UI(this);
    public CharacterEvent characterEvent = new CharacterEvent(this);
    public static void main(String[] args) {
        new ClickGame();
    }

    public ClickGame() {
    }
    
}
