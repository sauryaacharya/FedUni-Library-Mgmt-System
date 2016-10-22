/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.AdminLoginBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author saurya
 */
public class AdminLoginValidator extends Validator{
    AdminLoginBeanLocal adminLoginBean = lookupAdminLoginBeanLocal();
    
    
    
    public AdminLoginValidator()
    {
        super();
    }
    
    @Override
    public boolean validateForm()
    {
        boolean valid = true;
        
        if(!adminLoginBean.isValidLoginDetails(data.get("userName"), data.get("password")))
        {
            errors.put("error", "Error ! Invalid username / password.");
            valid = false;
        }
        
        return valid;
    }

    private AdminLoginBeanLocal lookupAdminLoginBeanLocal() {
        try {
            Context c = new InitialContext();
            return (AdminLoginBeanLocal) c.lookup("java:global/library/library-ejb/AdminLoginBean!beans.AdminLoginBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
