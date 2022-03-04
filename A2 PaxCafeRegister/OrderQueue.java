
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JohannBatson 
 */
public class OrderQueue extends JPanel
{
    private ArrayList<Order>  orderQueue; //holds the orders
    private JTextArea queueArea;       //used to display the order queue data
    private JScrollPane scrollPane;    //holds the queueArea to allow scrolling
    private int currWaitTime;          //holds cumulative wait (prep) time for orders on queue
    
    
    public OrderQueue()
    {
        setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLUE),"Order Queue",2,1, new Font("Courier",1,16),Color.BLACK)); //The panel must have a border with the appropriate title. The font for this is also Courler but size is 16 and bold.
        setLayout(new FlowLayout());      
       queueArea = new JTextArea(17,35);                 //The panel will use flowLayout; queueArea size should be 17 height and 35 width; font on text is Courier
       queueArea.setFont(new Font("Courier", 1, 14));    //The font for this is courier, size is 14, bold
       queueArea.setText("Num\tTotal\tPrep(m:s)\twait(m:s)");  //The panel must have a border with the appropriate title. The font vertical scrolling only;  
       scrollPane = new JScrollPane(queueArea);                
       scrollPane.setPreferredSize(new Dimension(400,200));   //size is 400 x 200.
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //this prevents the use of horizontal scrolling
       
        orderQueue = new ArrayList<Order> ();
        
        
        currWaitTime = 0;
        add(scrollPane);
    }
    
    public void addOrder(Order newOrder)
    {
        orderQueue.add(newOrder);                        //adds the order to orderQueue; increments currWaitTime using the order's prep time; adds the relevant
        if (!queueArea.getText().equals(""))             //order info to the queueArea; times must be converted from seconds to minutes and seconds (m:s)
        {
            queueArea.setText(queueArea.getText() + "\n" + getQueueSize() + ")\t$" + new DecimalFormat("#.00").format(newOrder.getTotal()) + "\t" + newOrder.getMaxPrepTime() / 60 + ":" + String.format("%02d", newOrder.getMaxPrepTime() % 60) + "\t" + currWaitTime / 60 + ":" + String.format("%02d", currWaitTime % 60));
        }else{
            queueArea.setText("Num\tTotal\tPrep(m:s)\tWait(m:s)" + "\n" + getQueueSize() + ")" + "\t" + "$" + new DecimalFormat("#.00").format(newOrder.getTotal()) + "\t" + newOrder.getMaxPrepTime() / 60 + ":" + String.format("%02d", newOrder.getMaxPrepTime() % 60) + "\t" + currWaitTime / 60 + ":" + String.format("%02d", currWaitTime % 60));
        }
    }
    
  public int getQueueSize()
  {
     return orderQueue.size();   //returns the size of OrderQueue
  }
    
    
    
    
    
    
    
    
    
    
    
    
}
