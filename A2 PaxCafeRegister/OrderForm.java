import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JohannBatson 
 */

public class OrderForm extends JPanel
{
    private Menu menu;    //holds the entire menu
    private ArrayList<Integer> quantities;  //this is an ArrayList of Integers used  to holds the quantity of an item ordered
    private Order order;    //holds the order details
    private JTextField subtotal; //holds the subtotal for the order
    private JTextField tax;      //holds the tax calculated on the subtotal using a rate of 15%
    private ArrayList<JTextField> textboxes;  //this is an ArrayList which holds the JTextField
    private JTextField total; //holds the total bill(subtotal and tax)
    private JLabel LabelSubTotal;
    private JLabel LabelTaxes;    //holds the subtotals, taxes and total in a JLabel
    private JLabel LabelTotal;
    
    public OrderForm ()
    {
        try //using a try catch to catch the errors
        {
          menu = new Menu("menu.txt");
          textboxes = new ArrayList<JTextField>();    //uses argument to initialize menu; instantiates quantities and order etc.
          quantities = new ArrayList<Integer>();      //creates elements and adds them to the panel
          order = new Order();
          
          LabelSubTotal = new JLabel ();
          LabelSubTotal.setFont(new Font("courier",1,14));
          LabelSubTotal.setText("SubTotal");
          
          LabelTaxes = new JLabel ();
          LabelTaxes.setFont(new Font("courier",1,14));
          LabelTaxes.setText("Taxes");
          
          LabelTotal = new JLabel ();
          LabelTotal.setFont(new Font("courier",1,14));    //Font on labels and fields is Courier, size is 14
          LabelTotal.setText("Total");
          
          subtotal = new JTextField();
          subtotal.setFont((new Font("courier",1,14)));
          
          tax = new JTextField();
          tax.setFont((new Font("courier",1,14)));
          
          total = new JTextField();
          total.setFont((new Font("courier",1,14)));
        }
       catch(IOException EX)
       {
           System.out.println(EX);
       }
        setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLUE),"Order Menu",2,1, new Font("Courier",1,16),Color.BLACK)); //The panel must have a border with the appropriate title. The font for this is also Courler but size is 16 and bold.
        setLayout(new GridLayout(menu.size()+ 3,3)); //The panel will use GridLayout.[Hint new GridLayout(menu.size() + 3, 3)]
        for(int h = 0; h < menu.size(); h++)
        {
            JLabel name = new JLabel();        //creates a JLabel to display the name
            JLabel price = new JLabel();       //creates a JLabel to display the price
            JTextField quantity = new JTextField(); //creates a JTextField for the user to enter the quantity they want to order
            name.setFont(new Font("Courier", 1, 14)); //adds these to the panel
            name.setText(menu.getItem(h).getName());
            add(name);
            DecimalFormat format = new DecimalFormat("#.00");    //Prices are to have 2 decimals at all times
            String cost = format.format(menu.getItem(h).getPrice());
            price.setFont(new Font("Courier", 1, 14));
            price.setText(cost);
            add(price);
            quantity.setFont(new Font("Courier", 0, 14));   //Font on labels and fields is Courier, size is 14
            quantity.setText("0");
            textboxes.add(quantity);
            add(quantity);
        }
        
        JLabel Dot1 = new JLabel();
        Dot1.setText(".....");
        Dot1.setFont((new Font("courier",1,14)));
        JLabel Dot2 = new JLabel();
        Dot2.setText(".....");
        Dot2.setFont((new Font("courier",1,14)));  //Font on labels and fields is Courier, size is 14
        JLabel Dot3 = new JLabel();
        Dot3.setText(".....");
        Dot3.setFont((new Font("courier",1,14)));
        add(LabelSubTotal);
        add(Dot1);
        add(subtotal);   //creates a JLabel and a JTextField for each of the calculated fields (subtotal, tax, total)
        add(LabelTaxes);
        add(Dot2);
        add(tax);
        add(LabelTotal);
        add(Dot3);
        add(total);
        
    }
    
    public Order getOrder()
    {
        return order;  //returns the order
    }
    
    public void newOrder()
    {
        order = new Order(); //instantiates a new order and resets the form
        reset();
    }
    
    public void update()
    {
      order = new Order();   //gets all the quantities from the textfields and updates the order, subtotal, tax and total fields with the recalculated ordered values
      quantities = new ArrayList<Integer>();
      for(int f = 0; f < textboxes.size(); f++)
      {
          if(textboxes.get(f).getText().equals(""))
          {
              quantities.add(0);
              
                      
          }else{
              quantities.add(Integer.parseInt(textboxes.get(f).getText()));
          }
      }
      for(int e = 0; e < quantities.size(); e++)
      {
          order.updateOrder(menu.getItem(e), quantities.get(e));
          
      }
      subtotal.setText(new DecimalFormat("#.00").format(order.getSubTotal()));
      tax.setText(new DecimalFormat("#.00").format(order.getSubTotal() * order.getTax()));
      total.setText(new DecimalFormat("#.00").format(order.getTotal()));
    }
    
     public void reset()
   {
    quantities = new ArrayList<Integer> ();             //resets quantities list and field values to 0
    subtotal.setText("");
    tax.setText("");
    total.setText("");
    for(int y =0; y < textboxes.size(); y++)
    {
        textboxes.get(y).setText("");
    }
   }
    
     
}