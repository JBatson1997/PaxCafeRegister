import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JohannBatson 
 */
public class Order 
{
    private ArrayList<MenuItem> items;     //this is an ArrayList of MenuItem used to hold items ordered
    private ArrayList <Integer> quantities;  //this is an ArrayList of Integes used to hold the quantity of an item ordered
    private float subtotal;      //holds the subtotal for the order
    private float tax;          //holds the tax calculated on the subtotal using a rate of 15%
    private float total;        //holds the total bill (subtotal and tax)
    private int maxPrepTime;    //holds the highest prep time for dthe items on the order
      
    public Order()
    {
        items = new ArrayList<MenuItem> ();     
        quantities = new ArrayList<Integer> ();
        subtotal = 0;                           //instantiates and initializes data members appropriately
        tax =(float) 0.15;
        total = 0;
        maxPrepTime = 0;
    }
    public float getSubTotal()
    {
        return subtotal; //returns subTotal
    }
    public float getTax()
    {
        return tax; //returns Tax
    }
    public float getTotal()
    {
        return total;   //returns Total
    }
    public int getMaxPrepTime()
    {
        return maxPrepTime; //returns maxPrepTime
    }
    public ArrayList<MenuItem> getItems()
    {
        return items;    //returns Items list
    }
    public ArrayList<Integer> getQuantities()
    {
        return quantities;   //returns Quantities list
    }
     public void updateOrder(MenuItem item, int quantity)   //adds item & quantity to the order
     {
         for(int a = 0; a < items.size(); a++)              //If item is on order (items) already, update the quantity
         {                                                  //otherwise, item and quantity are appinded to the lists.
             if(items.get(a).getName() == item.getName())      
             {
                quantities.set(a, quantities.get(a)+ quantity);
                updateCalculations();
                return;
             }
                                                               
         }                                                     
         items.add(item);
    quantities.add(quantity);              //Updates data members with the new calculations 
         updateCalculations();
     }
     public void updateCalculations()
     {
        subtotal = 0;                  //recalculates values (subtotal, maxPrepTime, etc)
        maxPrepTime = 0;
        total = 0;
        for(int b = 0; b < items.size(); b++)
        {
         subtotal += items.get(b).getPrice() * quantities.get(b);
         maxPrepTime += items.get(b).getPrepTime() * quantities.get(b);
         
        }
        total += subtotal + (subtotal * tax);
}
}
    


