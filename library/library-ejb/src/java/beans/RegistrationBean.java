/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import java.util.LinkedHashMap;
import java.util.regex.*;
import entity.Users;
import entity.UsersFacade;
import entity.UsersFacadeLocal;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author saurya
 */
@Stateless
public class RegistrationBean implements RegistrationBeanLocal {
    
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private UsersFacadeLocal usersFacade;
   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registerUser(Users user)
    {
        usersFacade.create(user);
    }
    
    @Override
    public boolean isEmailExists(String emailId)
    {
        boolean exists = true;
        Users u = null;
        try{
        u = (entity.Users)em.createNamedQuery("Users.findByEmail").setParameter("email", emailId).getSingleResult();
        }
        catch(Exception e)
        {
        }
        if(u == null){
            exists = false;
        }
        return exists;
    }
}
