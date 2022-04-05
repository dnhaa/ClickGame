
package clickgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    
    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[5];
    JPanel inventoryPanel;
    JLabel ropeLabel, knifeLabel, eggLabel, torchLabel;
    
    public UI(ClickGame cg) {
        this.cg = cg;
        createFrame();
        createPlayerField();
        generateScreen();
        frame.setVisible(true);
    }
    public void createFrame() {
        frame = new JFrame();
        
        
        ta = new JTextArea("YOU WAKE UP TO A STRANGE GIRL LOOKING AT YOU...");
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
        panels[bgNum].add(labels[bgNum]);
        
        
    }
    public void createArrows(int bgNum, int x, int y, int width, int height, String fileName1, String fileName2, String command) {
        ImageIcon arrowIcon1 = new ImageIcon (getClass().getResource(fileName1));
        JButton bt1 = new JButton();
        bt1.setBounds(x, y, width, height);
        bt1.setIcon(arrowIcon1);
        bt1.setBackground(null);
        bt1.setContentAreaFilled(false);
        bt1.setFocusPainted(false);
        bt1.setBorderPainted(false);
        bt1.addActionListener(cg.ah);
        bt1.setActionCommand(command);
        
        
        
        ImageIcon arrowIcon2 = new ImageIcon (getClass().getResource(fileName2));
        JButton bt2 = new JButton();
        bt2.setBounds(1050 - x, y, width, height);
        bt2.setIcon(arrowIcon2);     
        bt2.setBackground(null);
        bt2.setContentAreaFilled(false);
        bt2.setFocusPainted(false);
        bt2.setBorderPainted(false);
        bt2.addActionListener(cg.ah);
        bt2.setActionCommand(command);
        
        panels[bgNum].add(bt1);
        panels[bgNum].add(bt2);
    }
    public void createPlayerField() {
        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 200, 50);
        lifePanel.setBackground(Color.BLACK);
        lifePanel.setLayout(new GridLayout(1, 5));
        frame.add(lifePanel);
        ImageIcon lifeIcon = new ImageIcon(getClass().getResource("/resource/heart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);
        
        for (JLabel label : lifeLabel) {
            label = new JLabel();
            label.setIcon(lifeIcon);
            lifePanel.add(label);
        }
        
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(900, 0, 160, 50);
        inventoryPanel.setBackground(Color.BLACK);
        inventoryPanel.setLayout(new GridLayout(1, 4));
        frame.add(inventoryPanel);
        ImageIcon eggIcon = new ImageIcon(getClass().getResource("/resource/egg.png"));
        ImageIcon torchIcon = new ImageIcon(getClass().getResource("/resource/torch.png"));
        ImageIcon knifeIcon = new ImageIcon(getClass().getResource("/resource/knife.png"));
        ImageIcon ropeIcon = new ImageIcon(getClass().getResource("/resource/rope.png"));
        eggLabel = new JLabel();
        torchLabel = new JLabel();
        knifeLabel = new JLabel();
        ropeLabel = new JLabel();
        eggLabel.setIcon(eggIcon);
        torchLabel.setIcon(torchIcon);
        knifeLabel.setIcon(knifeIcon);
        ropeLabel.setIcon(ropeIcon);
        inventoryPanel.add(torchLabel);
        inventoryPanel.add(eggLabel);
        inventoryPanel.add(knifeLabel);
        inventoryPanel.add(ropeLabel);
        
        
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
        createArrows(1, 10, 260, 50, 50, "/resource/arrow-left.png", "/resource/arrow-right.png", "toScene02");
        createObject(1, 800, 320, 200, 200, "/resource/question.png", "Greet", "Save", "Kill", "Character");
        
        //SCENE 2
        createBackground(2, "/resource/ice-mountain.png");
        createArrows(2, 10, 260, 50, 50, "/resource/arrow-left.png", "/resource/arrow-right.png", "toScene01");
        createObject(2, 800, 320, 200, 200, "/resource/question.png", "Greet", "Save", "Kill", "Character");
        
    }
    
}
