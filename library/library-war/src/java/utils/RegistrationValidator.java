/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

//import beans.RegistrationBean;
import beans.RegistrationBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author saurya
 */
public class RegistrationValidator extends Validator{
    RegistrationBeanLocal registrationBean = lookupRegistrationBeanLocal();
    
    public RegistrationValidator()
    {
        super();
        
    }
    
    @Override
    public boolean validateForm() {
        
        boolean valid = true;
        
        if(data.get("firstName").equals("")){
            errors.put("firstName", "Please enter the firstname.");
            valid = false;
        }
        
        if(data.get("lastName").equals("")){
            errors.put("lastName", "Please enter the lastname.");
            valid = false;
        }
        
        if(data.get("emailId").equals("")){
            errors.put("emailId", "Please enter the email.");
            valid = false;
        } else {
            String pattern = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(data.get("emailId"));
            if(!m.matches()){
                errors.put("emailId", "Please enter the valid email.");
                valid = false;
            } else{
               
                if(registrationBean.isEmailExists(data.get("emailId"))){
                    errors.put("emailId", "Email already exists. Please try different one.");
                    valid = false;
                }
                
            }
        }
        
        if(data.get("phoneNum").equals("")){
            errors.put("phoneNum", "Please enter the phone.");
            valid = false;
        } else{
            if(data.get("phoneNum").length() != 10){
                errors.put("phoneNum", "Please enter the valid phone number.");
                valid = false;
            }else {
                try {
                    long num = Long.parseLong(data.get("phoneNum"));
                }
                catch(NumberFormatException e){
                    errors.put("phoneNum", "Please enter the valid phone number.");
                    valid = false;
                }
            }
        }
        
        if(data.get("password").equals("")){
            errors.put("password", "Please enter the password.");
            valid = false;
        } else {
            if(data.get("password").length() < 8){
                errors.put("password", "Please enter the password of at leas 8 characters.");
                valid = false;
            }
        }
                
        return valid;
    }
   
    private RegistrationBeanLocal lookupRegistrationBeanLocal() {
        try {
            Context c = new InitialContext();
            return (RegistrationBeanLocal) c.lookup("java:global/library/library-ejb/RegistrationBean!beans.RegistrationBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
