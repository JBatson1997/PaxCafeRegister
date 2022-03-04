/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JohannBatson
 */
public class MenuItem 
{
   private String name;    //data members
   private float price;
   private int prepTime;   //prepTime represents the number of seconds that an item takes to prepare
   
   public MenuItem(String n, float p, int pt)
   {
       name = n;     //constructor MenuItem used to initialize data members
       price = p;
       prepTime = pt;
   }
   public String getName()
   {
       return name;     //returns name
   }
   public float getPrice()
   {
       return price;   //returns price
   }
   public int getPrepTime()
   {
       return prepTime;   //returns PrepTime
   }
   public void setName (String n)
   {  
     name = n;          //sets name
   }
   public void setPrice(float p)
   {
     price = p;  //sets price
   }
   public void setPrepTime(int pt)
   {
     prepTime = pt;   //sets PrepTime
   }
}
