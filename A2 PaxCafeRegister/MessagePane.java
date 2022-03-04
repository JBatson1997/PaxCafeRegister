
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
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
public class MessagePane extends JPanel
{
    private JTextArea queueArea;   //used to display of customers served etc...
            
    
    public MessagePane()
    {
      setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLUE),"Welcome to Pax Café",2,1, new Font("Courier",1,16),Color.BLACK)); //The panel must have a border with the appropriate title. The font for this is also Courler but size is 16 and bold.
       setLayout(new FlowLayout());
       queueArea = new JTextArea (17, 35);                   //The panel will use FlowLayout layout. queueArea size should be 17 height and 35 width
       queueArea.setFont(new Font("Courier", 1, 14));        //The font on test is Courier, size is 14, bold; panel must have a border with the appropriate title.
       queueArea.setPreferredSize(new Dimension(400, 200));  
       add(queueArea);
       
    }
    
    
   public void reset()
   {
       queueArea.setText("");    //used to clear the panel
   }   
   
   public void update(int numServed)
   {
       queueArea.setText(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date(System.currentTimeMillis())) + "\n\nCustomer serverd today: " + numServed + "\n\nBe at Peace - Be at Pax.");   //updates screen's date/time and customers served
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
