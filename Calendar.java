package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar extends JPanel{
    JLabel monthName;
    JLabel[] dayName = new JLabel[7];
    String[] EngNames = {"M","T","W","T","F","S","S"};
    int numbOfDays = 31;
    JLabel[] dayNumb = new JLabel[31];
    
    
    public Calendar(){      
        JPanel monthTitle = new JPanel(); 
        monthName = new JLabel("monthName");
        monthTitle.add(monthName);
        
        JPanel dayTitle = new JPanel();
        dayTitle.setLayout(new FlowLayout(0,20,0));
        for(int i = 0; i<7;i++){
            dayName[i] = new JLabel(EngNames[i]);
            dayName[i].setFont(new Font("Arial",Font.BOLD,18));
            dayTitle.add(dayName[i]);
        }
        
        JPanel days = new JPanel();
        days.setLayout(new GridLayout(5,7,5,2));
        
        for(int i = 0; i < numbOfDays;i++){
            if(i<9){
                dayNumb[i] = new JLabel("0"+ (i+1));
            }else dayNumb[i] = new JLabel(""+ (i+1));
            dayNumb[i].setFont(new Font("Arial",Font.PLAIN,11));
            days.add(dayNumb[i]);
        }
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(monthTitle);
        add(dayTitle);
        add(days); 
                
        setVisible(true);
    }
    
    public Insets getInsets(){
        return new Insets(30,30,30,30);
    }
}