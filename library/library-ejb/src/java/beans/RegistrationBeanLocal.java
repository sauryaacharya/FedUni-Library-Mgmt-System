/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import entity.Users;

/**
 *
 * @author saurya
 */
@Local
public interface RegistrationBeanLocal {

    
    boolean isEmailExists(String emailId);
    
    void registerUser(Users user);
    
}
