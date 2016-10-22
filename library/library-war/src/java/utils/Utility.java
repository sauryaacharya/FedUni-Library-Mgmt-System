/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author saurya
 */
public class Utility {
    
    public Utility()
    {
        
    }
    
    public static boolean isInteger(String num)
    {
        boolean isInteger = false;
        try{
            Integer.parseInt(num);
            isInteger = true;
        }
        catch(NumberFormatException e){
            
        }
        return isInteger;
    }
    
}
