package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JPanel implements ActionListener{
     JMenuBar menubar = new JMenuBar();
     JMenuItem neew,load,save,share,delete,style,options,instruction,license;
    
    public MenuBar(){
       /////////////////////////////////////////////
       JMenu file = new JMenu("File");
       
       neew = new JMenuItem("New");
       load = new JMenuItem("Load");
       save = new JMenuItem("Save");
       share = new JMenuItem("Share");
       delete = new JMenuItem("Delete");
       
       neew.addActionListener(this);
       
       file.add(neew);
       file.add(load);
       file.add(save);
       file.addSeparator();
       file.add(share);
       file.add(delete);
       
       /////////////////////////////////////////////
       JMenu tools = new JMenu("Tools");
       
       style = new JMenuItem("Style");
       options = new JMenuItem("Options");
       
       tools.add(style);
       tools.add(options);
       
       /////////////////////////////////////////////
       JMenu help = new JMenu("Help");
       
       instruction = new JMenuItem("Instruction");
       license = new JMenuItem("License");
       
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
    
    
    
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        
        if(source == neew){
            NewConsole nc = new NewConsole();

        }
            
        
    }
}