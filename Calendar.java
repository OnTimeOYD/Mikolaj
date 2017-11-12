package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar extends JPanel implements ActionListener,MouseListener{
    JLabel monthName,yearNumb;
    JLabel[] dayName = new JLabel[7];
    String[] EngNames = {"M","T","W","T","F","S","S"};
    int numbOfDays = 31;
    JLabel[] dayNumb = new JLabel[31];
    JPanel holder = new JPanel();
    JPanel yearNumbPanel,monthNamePanel;
    static int YEAR=2017;
    static String MONTH_NAME;
    JButton leftYear,rightYear,leftMonth,rightMonth;
    
    public Calendar(){      
        holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
        yearNumbPanel = new JPanel(); 
        yearNumb = new JLabel(""+YEAR); 
        
        leftYear = new JButton("<=");
        rightYear = new JButton("=>");
        yearNumbPanel.add(leftYear);
        yearNumbPanel.add(yearNumb);
        yearNumbPanel.add(rightYear);
        if(YEAR==2017){
            leftYear.setEnabled(false);
        }
        leftYear.addActionListener(this);
        rightYear.addActionListener(this);
        
        
        
        
        yearNumb.setFont(new Font("Courier New",Font.PLAIN,15));
        yearNumb.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel days = new JPanel();
        days.setLayout(new GridLayout(6,7,5,2));
        for(int i=0;i<7;i++){
            JLabel dayName = new JLabel(EngNames[i]);
            dayName.setFont(new Font("Courier New",Font.BOLD,18));
            days.add(dayName);
        }
        
        for(int i = 0; i < numbOfDays;i++){
            if(i<9){
                dayNumb[i] = new JLabel("0"+ (i+1));
                dayNumb[i].setName(""+i);
            }else{
                dayNumb[i] = new JLabel(""+ (i+1));
                dayNumb[i].setName(""+i);
            }
            dayNumb[i].setFont(new Font("Courier New",Font.PLAIN,12));
            days.add(dayNumb[i]);
        }
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        holder.add(yearNumbPanel);
        //holder.add(dayTitle);
        holder.add(days); 
        add(holder);        
        setVisible(true);
    }
    
    public Insets getInsets(){
        return new Insets(30,30,30,30);
    }
    
    public void mouseClicked(MouseEvent event){
    }
    public void mouseEntered(MouseEvent event){
    }
    public void mouseExited(MouseEvent event){
    }
    public void mousePressed(MouseEvent event){        
    }
    public void mouseReleased(MouseEvent event){       
    }   
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if(source == leftYear){
            if(YEAR > 2017){
                YEAR--;
                yearNumb.setText(""+YEAR);
                //MainApp.REPAINT(1);
                if(YEAR == 2017){
                leftYear.setEnabled(false);
                }
            }
    
        }
        if(source == rightYear){
            YEAR++;
            yearNumb.setText(""+YEAR);
            if(YEAR >= 2018){
                leftYear.setEnabled(true);
            }
        }
        
    }
}
