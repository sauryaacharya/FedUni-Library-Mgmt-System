/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.LoginBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author saurya
 */
public class LoginValidator extends Validator{
    LoginBeanLocal loginBean = lookupLoginBeanLocal();
    
    
    
    public LoginValidator()
    {
        super();
    }
    
    @Override
    public boolean validateForm()
    {
        boolean valid = true;
        if(!loginBean.isValidLoginDetails(data.get("userName"), data.get("password")))
        {
            errors.put("error", "Error ! Invalid email / password.");
            valid = false;
        }
        return valid;
    }

    private LoginBeanLocal lookupLoginBeanLocal() {
        try {
            Context c = new InitialContext();
            return (LoginBeanLocal) c.lookup("java:global/library/library-ejb/LoginBean!beans.LoginBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
