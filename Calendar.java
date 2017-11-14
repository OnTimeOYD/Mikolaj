package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar extends JPanel implements ActionListener,MouseListener{
    JLabel monthName,yearNumb;
    JLabel[] dayName = new JLabel[7];
    String[] EngNames = {"M","T","W","T","F","S","S"};
    String[] EngMonthName = {" January "," February","  March  ","  April  ","   May   ",
                            "   June  ","   July  ","  August ","September",
                            " October "," November"," December",""};
    int numbOfDays = 31;
    JLabel[] dayNumb = new JLabel[42];
    JPanel holder = new JPanel();
    JPanel yearNumbPanel,monthNamePanel;
    static int YEAR=2017;
    JButton leftYear,rightYear,leftMonth,rightMonth;
    int monthNumb=0;
    JPanel days;
    int lastIndex = 0;
    
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
        
        
        monthNamePanel = new JPanel();
        monthName = new JLabel(EngMonthName[monthNumb]);
        leftMonth = new JButton("<=");
        rightMonth = new JButton("=>");
        if(YEAR == 2017){
            leftYear.setEnabled(false);
        }
        monthName.setFont(new Font("Courier New",Font.BOLD,15));
        leftMonth.addActionListener(this);
        rightMonth.addActionListener(this);
        monthNamePanel.add(leftMonth);
        monthNamePanel.add(monthName);
        monthNamePanel.add(rightMonth);

        days = new JPanel();
        days.setLayout(new GridLayout(7,7,5,2));
        for(int i=0;i<7;i++){
            JLabel dayName = new JLabel(EngNames[i]);
            dayName.setFont(new Font("Courier New",Font.BOLD,18));
            days.add(dayName);
        }
        
        
        for(int i=0;i<dayNumb.length;i++){
            dayNumb[i]=new JLabel();
        }
        
        writeCalendar(monthNumb+1,YEAR);
        
        
        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        holder.add(yearNumbPanel);
        holder.add(monthNamePanel);
        //holder.add(dayTitle);
        holder.add(days); 
        add(holder);        
        setVisible(true);
    }
    
    public int getFirstIndexOfMonth(int Month){
        int indexToReturn = 0 ;
        
        return indexToReturn;
    }
////////////////////////////////////////////////////////////////////////////////    
    public void writeCalendar(int Month, int Year){
        int dayNum = 1;
        numbOfDays = GET_NUMB_OF_DAYS(Month,Year); 
        int FirstIndex = GET_FIRST_INDEX(Month,Year,lastIndex);
        lastIndex = GET_LAST_INDEX(FirstIndex,numbOfDays);
        
        
       // System.out.println(lastIndex);
        
        for(int i=0; i<dayNumb.length;i++){
           dayNumb[i].setText("  ");
           dayNumb[i].addMouseListener(this);
            days.add(dayNumb[i]);            
        } 

        for(int i=0;i<numbOfDays+FirstIndex;i++){
            if(i<FirstIndex){
                continue;
            } else if(i<9+FirstIndex){
                dayNumb[i].setText("0"+dayNum++);
            } else {
                dayNumb[i].setText(""+dayNum++);
            }  
        }
                      
        /*for(int i = 0; i < numbOfDays;i++){
            
            if(i<9){
                dayNumb[i].setText("0"+ dayNum++);
                dayNumb[i].setName(""+i);
            }else{
                dayNumb[i].setText(""+ dayNum++);
                dayNumb[i].setName(""+i);
            }
            dayNumb[i].setFont(new Font("Courier New",Font.PLAIN,12));
            days.add(dayNumb[i]);        
        }*/ 
    }
    
    public static int GET_NUMB_OF_DAYS(int Month, int Year){
        int DayNumb = 0;
        Boolean isLeap;
        
        
        switch(Month){
            case 2: isLeap = LEAP_YEAR(Year);
                    if(isLeap)DayNumb = 29;  
                    else DayNumb = 28;
                    break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: DayNumb = 31;
                     break;
            case 4:
            case 6:
            case 9:
            case 11: DayNumb = 30;
                     break; 
        }
        
        return DayNumb;
    }
    
    public static int GET_FIRST_INDEX(int Month, int Year,int Last){
        int FirstIndex = 6;
        if(Month == 1 && Year == 2017) FirstIndex = 6;
        else if(Month == 1 && Year != 2017){
            if(LEAP_YEAR(Year-1)){
                FirstIndex = (Last+335)%7;
                return FirstIndex;
            }
            else{
                FirstIndex = (Last+334)%7;
                return FirstIndex;
            }
        }else{
            FirstIndex = Last;
            return FirstIndex;
        }
        
        return FirstIndex;
        
    }
    public static int GET_LAST_INDEX(int FirstIndex, int numbOfDays){
        int LastIndex = 0;
        LastIndex = (FirstIndex + numbOfDays)%7;
        return LastIndex;
    }
    
    
    
    
    private static boolean LEAP_YEAR(int Year){
        return ((Year % 4 == 0) && (Year % 100 != 0)) || (Year % 400 == 0);
    }
    
    public Insets getInsets(){
        return new Insets(30,30,30,30);
    }
    
    public void mouseClicked(MouseEvent event){
        Object source = event.getSource();
        System.out.println(source);
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
                if(YEAR == 2017){
                leftYear.setEnabled(false);
                }
            }
            monthNumb = 0;
            monthName.setText(EngMonthName[monthNumb]);
            writeCalendar(monthNumb+1,YEAR);
        }
        
        if(source == rightYear){
            YEAR++;
            yearNumb.setText(""+YEAR);
            leftYear.setEnabled(true);
            leftMonth.setEnabled(true);
            monthNumb = 0;
            monthName.setText(EngMonthName[monthNumb]);  
            writeCalendar(monthNumb+1,YEAR);
        }
        
        if(source == leftMonth){
            if(monthNumb > 0)
            monthNumb--;
            monthName.setText(EngMonthName[monthNumb]);
            if(monthNumb == 0 && YEAR == 2017){
                leftMonth.setEnabled(false);
            }
            if(monthNumb == 0 && YEAR > 2017){
                monthNumb = 11;
                YEAR--;
                yearNumb.setText(""+YEAR);
                if(YEAR == 2017){
                    leftYear.setEnabled(false);
                }
                monthName.setText(EngMonthName[monthNumb]);
            }
            writeCalendar(monthNumb+1,YEAR);
        }
        
        if(source == rightMonth){
            if(monthNumb <= 11){
            monthNumb++;
            
            monthName.setText(EngMonthName[monthNumb]);
            }
//            if(monthNumb >= 1){
//                leftMonth.setEnabled(true);
//            }
            if(monthNumb >= 1){
                leftMonth.setEnabled(true);
            }
            
            
            if(monthNumb > 11){
                YEAR++;
                yearNumb.setText(""+YEAR);
                if(YEAR >= 2018){
                leftYear.setEnabled(true);
                } 
                monthNumb = 0;
                monthName.setText(EngMonthName[monthNumb]);
                leftMonth.setEnabled(true);
            }
            writeCalendar(monthNumb+1,YEAR);
        }
        
    }
}