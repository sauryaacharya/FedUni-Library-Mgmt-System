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
public class AddBookValidator extends Validator{
    
    public AddBookValidator()
    {
        super();
    }
    
    @Override
    public boolean validateForm()
    {
        boolean valid = true;
        
        if(data.get("bookName").equals("")){
            errors.put("bookName", "Please enter the book name.");
            valid = false;
        }
        
        if(data.get("author").equals("")){
            errors.put("author", "Please enter the author name.");
            valid = false;
        }
        
        if(data.get("publisher").equals("")){
            errors.put("publisher", "Please enter the publisher name.");
            valid = false;
        }
        
        if(data.get("publishDate").equals("")){
            errors.put("publishDate", "Please enter the published year.");
            valid = false;    
        } else{
            if(data.get("publishDate").length() != 4){
                errors.put("publishDate", "Please enter a valid year.");
                valid = false;
            } else{
            try {
            Integer year = Integer.parseInt(data.get("publishDate"));
            }
            catch(NumberFormatException e){
                errors.put("publishDate", "Please enter a valid year.");
                valid = false;
            }
            }
        
        }
        
        if(data.get("isbn").equals("")){
            errors.put("isbn", "Please enter the ISBN.");
            valid = false;
        }
        
        if(data.get("description").equals("")){
            errors.put("description", "Please enter the description.");
            valid = false;
        }
        
        if(data.get("category").equals("")){
            errors.put("category", "Please enter the category.");
            valid = false;
        }
        return valid;
    }
    
}
