package Time;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
public class Clock extends JFrame{
    Calendar calendar;
    SimpleDateFormat timeFormat;
    //SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    Clock(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);
  
        timeFormat = new SimpleDateFormat("HH:mm:ss");  //設定時間
        //dayFormat = new SimpleDateFormat("EEEE");  //設定星期幾(限英文)
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");  //設定日期
  
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);  //讓label的設定依照frame的邊界調整並顯示
  
        //dayLabel = new JLabel();
        //dayLabel.setFont(new Font("Verdana",Font.PLAIN,35));
  
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana",Font.PLAIN,25));
  
  
        this.add(timeLabel);
        //this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
  
        setTime();
    }
 
    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime()); //拿取當地時間
            timeLabel.setText(time);
  
            //day = dayFormat.format(Calendar.getInstance().getTime());  //拿取當地星期幾(限英文)
            //dayLabel.setText(day);
  
            date = dateFormat.format(Calendar.getInstance().getTime());  //拿取當地日期
            dateLabel.setText(date);
  
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
