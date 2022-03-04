import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JohannBatson
 */
public class Menu 
{
  private ArrayList<MenuItem> menuList;   //data members of an ArrayList of MenuItem 
                                          //mentList: this is an ArrayList of MenuItem
  
   Menu(String Menu) throws IOException //this throws IOException
   {
   menuList = new ArrayList<MenuItem>();
   Scanner mykeyboard = new Scanner(new File(Menu));//reading the file by using the scanner class, MenuItem objects containing data can be created and added to the menuList
   while(mykeyboard.hasNextLine())              //this will read each line in the file 
   {                                            //any names with - must have those hypens replaced by a single space
       String line = mykeyboard.nextLine();
       String [] item = line.split("\\s+");
       menuList.add(new MenuItem (item[0].replace("-", " "),Float.parseFloat(item[1]),Integer.parseInt(item[2])));
   }
   }
   
   Menu(ArrayList<MenuItem>j)
   {
       menuList = j; //used to initialize menuList
   }
   
   int size()
   {
      return menuList.size(); //returns the size of menuList
   }
   
   public MenuItem getItem(int h)
   {  
       return menuList.get(h); //returns the object from that position in the menuList   
   }

    void setSize(int i, int i0) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
