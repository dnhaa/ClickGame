
package clickgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionHandler implements ActionListener{
    ClickGame cg;
    public ActionHandler(ClickGame cg) {
        this.cg = cg;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        switch (choice) {
            case "GreetCharacter":
                cg.characterEvent.greetCharacter();
                break;
            case "SaveCharacter":
                cg.characterEvent.saveCharacter();
                break;
            case "KillCharacter":
                cg.characterEvent.killCharacter();
                break;
        }
    }
    
}
