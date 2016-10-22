/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Users;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author saurya
 */
@Local
public interface LoginBeanLocal {
    
    boolean isValidLoginDetails(String userName, String password);
    
    void startUserSession(HttpServletRequest request, Users u);
    
    Users getUser();
    
}
