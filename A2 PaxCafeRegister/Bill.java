
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Bill extends JPanel
{
    private JTextArea queueArea;    //used to display the order queue data
    private JScrollPane scrollPane; //holds the queueArea to allow scrolling
    
    
    public Bill()
    {
         setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLUE),"Bill",2,1, new Font("Courier",1,16),Color.BLACK)); //The font for this is also Courier but size is 16 and bold.
         setLayout(new FlowLayout());         //The panel will use FlowLayout layout; queueArea size should be
         queueArea = new JTextArea(17,35);    //17 height and 35 width; Font on text is Courier, size is 14, bold.
         queueArea.setFont((new Font("courier",1,14)));  //The panel must have a border with the appropriate title. 
         scrollPane = new JScrollPane(queueArea);
         scrollPane.setPreferredSize(new Dimension(400,200));    //The queueArea in contained in the scrollPane to allow for vertical scrolling only; 
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //No horizontal scrolling should be allowed; size should be 400 x 200
         add(scrollPane);
    }
    
    public void reset()
    {
        queueArea.setText(""); //used to clear the panel; displays column headings only
        
    }
    
    public void displayBill(Order newOrder)
    {
        if (newOrder.getTotal() != 0)
        {
            String bill = "";
            String subtotal = new DecimalFormat("#.00").format(newOrder.getSubTotal());
            String tax = new DecimalFormat("#.00").format(newOrder.getSubTotal()* newOrder.getTax());
            String total = new DecimalFormat("#.00").format(newOrder.getTotal());
            for (int a =0; a < newOrder.getItems().size(); a++ )
            {
                if(newOrder.getQuantities().get(a) != 0)   //uses the items, quantities and other values on the order to make the appropriate display
                {
                    bill += newOrder.getItems().get(a).getName()+ "\t"+newOrder.getQuantities().get(a)+"@"+ new DecimalFormat("#.00").format(newOrder.getItems().get(a).getPrice()) + "\t$" + new DecimalFormat("#.00").format(newOrder.getItems().get(a).getPrice() * newOrder.getQuantities().get(a))+ "\n";
                }
            }
            String TotalBill = "Item\tQty\tTotal\n" + bill + "\n\nSub-Total\t\t" + "$" + new DecimalFormat("#.00").format(newOrder.getSubTotal()) + "\nTax\t\t" + "$" + new DecimalFormat("#.00").format(newOrder.getTax() * newOrder.getSubTotal()) + "\nTotal\t\t$" + new DecimalFormat("#.00").format(newOrder.getTotal());
            queueArea.setText(TotalBill);
          }else{
            queueArea.setText("Item\tQty\tTotal\n");
        }
    }
    
    public void printBill(Order newOrder, int qSize) throws IOException //The exception handler is implemented in this method
    {
        String bill = "";
        for (int a = 0; a < newOrder.getItems().size(); a++)    //uses PrintWriter and FileWriter class  to print the order details to a text file.
        {                                                      //A new file will be output for each to order placed. The file name will have the format:bill_x.txt where x represents the order number in the queue.
            if (newOrder.getQuantities().get(a) != 0) 
            {
            bill += newOrder.getItems().get(a).getName() + "\t" + newOrder.getQuantities().get(a) + "@" + new DecimalFormat("#.00").format(newOrder.getItems().get(a).getPrice()) + "\t" + "$" + new DecimalFormat("#.00").format(newOrder.getItems().get(a).getPrice() * newOrder.getQuantities().get(a)) + "\n";
            }
        }
        bill += "\n\n" + "Sub-total" + "\t\t" + "$" + new DecimalFormat("#.00").format(newOrder.getSubTotal()) + "\n" + "Tax" + "\t\t" + "$" + new DecimalFormat("#.00").format(newOrder.getSubTotal() * newOrder.getTax()) + "\n" + "TOTAL" + "\t\t" + "$" + new DecimalFormat("#.00").format(newOrder.getTotal());
        bill = "PAX Cafe" + "\n" + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date(System.currentTimeMillis())) + "\n\n" + "Order Num: " + qSize + bill + "\n\n" + "Thank you for Dinning with Us!";
        FileWriter writer = new FileWriter("bill_" + qSize + ".txt");
        writer.write(bill);
        writer.close();
        queueArea.setText(bill);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
