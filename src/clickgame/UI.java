
package clickgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class UI {
    public JFrame frame;
    public ClickGame cg;
    public JTextArea ta;
    public JPanel panels[] = new JPanel[10];
    public JLabel labels[] = new JLabel[10];
    public UI(ClickGame cg) {
        this.cg = cg;
        createFrame();
//        createBackground();
//        createObject();
        generateScreen();
        frame.setVisible(true);
    }
    public void createFrame() {
        frame = new JFrame();
        
        
        ta = new JTextArea("I WANT TO DIE...");
        ta.setBounds(50, 520, 1100, 150);
        ta.setBackground(Color.white);
        ta.setForeground(Color.black);
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(new Font("Osaka", Font.BOLD, 28));
        frame.add(ta);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1200, 740);
        frame.getContentPane().setBackground(Color.black);
        
    }
    
    public void createBackground(int bgNum, String fileName) {
        panels[bgNum]= new JPanel();
        panels[bgNum].setBounds(50, 50, 1100, 520);
        panels[bgNum].setBackground(Color.CYAN);
        panels[bgNum].setLayout(null);
        frame.add(panels[bgNum]);
        
        
        labels[bgNum] = new JLabel();
        labels[bgNum].setBounds(0, 0, 1100, 520);
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
                                                  //  "/resource/Seirai-Island.png"
        labels[bgNum].setIcon(icon);
        panels[bgNum].add(labels[1]);
        
        
    }
    public void createObject(int bgNum, int x, int y, int width, int height, String fileName, String choice1, String choice2, String choice3, String obj) {
        JPopupMenu popMenu = new JPopupMenu();
        
        JMenuItem menuItem[] = new JMenuItem[3];
        
        menuItem[0] = new JMenuItem(choice1);      
        menuItem[1] = new JMenuItem(choice2);
        menuItem[2] = new JMenuItem(choice3);
        
        for (JMenuItem menuItem1 : menuItem) {
            menuItem1.addActionListener(cg.ah);
            menuItem1.setActionCommand(menuItem1.getText() + obj);
            popMenu.add(menuItem1);
        }
        
        
        JLabel objLabel = new JLabel();
        objLabel.setBounds(x, y, width, height);  //800, 320, 200, 200
        ImageIcon objIcon = new ImageIcon(getClass().getResource(fileName));
                                                            //    "/resource/question.png"
        objLabel.setIcon(objIcon);
        
        objLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        panels[bgNum].add(objLabel);
        panels[bgNum].add(labels[bgNum]);
    }
    public void generateScreen() {
        // SCREEN 1
        createBackground(1, "/resource/Seirai-Island.png");
        createObject(1, 800, 320, 200, 200, "/resource/question.png", "Greet", "Save", "Kill", "Character");
    }
}
