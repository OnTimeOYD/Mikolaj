package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JPanel {
     JMenuBar menubar = new JMenuBar();
    
    
    public MenuBar(){
       /////////////////////////////////////////////
       JMenu file = new JMenu("File");
       
       JMenuItem neew = new JMenuItem("New");
       JMenuItem load = new JMenuItem("Load");
       JMenuItem save = new JMenuItem("Save");
       JMenuItem share = new JMenuItem("Share");
       JMenuItem delete = new JMenuItem("Delete");
       
       file.add(neew);
       file.add(load);
       file.add(save);
       file.addSeparator();
       file.add(share);
       file.add(delete);
       
       /////////////////////////////////////////////
       JMenu tools = new JMenu("Tools");
       
       JMenuItem style = new JMenuItem("Style");
       JMenuItem options = new JMenuItem("Options");
       
       tools.add(style);
       tools.add(options);
       
       /////////////////////////////////////////////
       JMenu help = new JMenu("Help");
       
       JMenuItem instruction = new JMenuItem("Instruction");
       JMenuItem license = new JMenuItem("License");
       
       help.add(instruction);
       help.add(license);
       
       /////////////////////////////////////////////
       JMenu sync = new JMenu("Sync");
       
       /////////////////////////////////////////////
       JMenu authors = new JMenu("Authors");
       
       /////////////////////////////////////////////
       menubar.add(file);
       menubar.add(tools);
       menubar.add(help);
       menubar.add(sync);
       menubar.add(authors);
    }
}