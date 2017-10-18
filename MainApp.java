package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp extends JFrame {
    
    public MainApp() {
        super("Nazwa");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15,3));

        JButton cButton = new JButton("Środek");
        cButton.setEnabled(false);
 
        
        add(cButton, BorderLayout.CENTER);
        add(new List(), BorderLayout.EAST);
        add(new Calendar(), BorderLayout.WEST);
        
        ////////////////////////////////////////////////////////////////////////
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        float screenHeight = screenSize.height;
        float screenWidth = screenSize.width;
        setLocation((int)(screenWidth / 2.9), (int)(screenHeight / 3.8));
        ////////////////////////////////////////////////////////////////////////
        
        
        MenuBar menu = new MenuBar();       
        setJMenuBar(menu.menubar);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] arguments){
        MainApp mp = new MainApp();
        mp.setMinimumSize(new Dimension(800, 500));
    }
    

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać systemowego wyglądu: " 
                    + e.getMessage());
        }
    }
}