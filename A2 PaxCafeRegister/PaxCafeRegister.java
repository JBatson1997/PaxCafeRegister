import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author JohannBatson 
 */
public class PaxCafeRegister extends JFrame implements ActionListener
{
    private OrderForm orderForm;
    private Bill bill;
    private OrderQueue orderQueue;
    private JButton btnCalcBill;
    private JButton btnPlaceOrder;
    private MessagePane messagePane;
    private GridLayout grid;
    
    
    public PaxCafeRegister()
    {
        grid = new GridLayout(2, 3);
        grid.setHgap(10);                             //instantiates panels and buttons, adding them to the frame;
        grid.setVgap(10);                             //this  frame uses GridLayout layout (2 rows, 3 columns with spacings of 10)
        setLayout(grid);                              //title on the frame must be set as seen in the screen of the GUI given
        setTitle("Pax Cafe");
        setSize(1500, 800);                           //Size of this frame is width 1500 and height 800
        orderForm = new OrderForm();
        bill = new Bill();
        orderQueue = new OrderQueue();                      //Buttons use font Courier, size 24, bold; action listeners are added to these buttons.
        messagePane = new MessagePane();
        btnCalcBill = new JButton();
        btnCalcBill.setText("Calculate");                   //If the calculate button is clicked then the order form is updated and the bill is displayed
        btnCalcBill.setForeground(Color.BLACK);             //If the place order button is clicked then order is added to the queue, the bill is printed
        btnCalcBill.setFont(new Font("Courier",1,24));      //the messagePane is updated and the bill and order form panels are reset; ready for a new order.
        btnCalcBill.addActionListener(this);                //Users must not be allowed to place an "empty" order. User-friendly error handling (with appropriate message) should be used if an attempt is amde to do so.
        
        btnPlaceOrder = new JButton();
        btnPlaceOrder .setText("Place Order");
        btnPlaceOrder .setForeground(Color.BLACK);
        btnPlaceOrder .setFont(new Font("Courier",1,24));
        btnPlaceOrder .addActionListener(this);
        
        add(orderForm);
        add(bill);
        add(orderQueue);
        add(btnCalcBill);
        add(btnPlaceOrder);
        add (messagePane);
    }
    
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == btnCalcBill)
        {
            orderForm.update();
            bill.displayBill(orderForm.getOrder());         //If the calculate button is clicked then the order form is updatedand the bill is displayed                                                                                    
        }else{                                              //If the place order button is clicked then order is added to the queue, the bill is printed
            if(orderForm.getOrder().getTotal() != 0)        //the messagePane is updated and the bill and order form panels are reset; ready for a new order.
            {                                                //Users must not be allowed to place an "empty" order. User-friendly error handling.
                orderQueue.addOrder(orderForm.getOrder());   //(with appropriate message) should be used if an attempt is made to do so
                try
                {
                    bill.printBill(orderForm.getOrder(), orderQueue.getQueueSize());
                    
                } catch(IOException EX)    //method throws an IOException;
                {
                    System.out.print(EX);
                }
                orderForm.newOrder();
                bill.reset();
                messagePane.update(orderQueue.getQueueSize());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        PaxCafeRegister Cafe = new PaxCafeRegister(); //instantiates a PAXCafeRegister object
        Cafe.setVisible(true);
        //TODO code application logic here
    }
    
}
