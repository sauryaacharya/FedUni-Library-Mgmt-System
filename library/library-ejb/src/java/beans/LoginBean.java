/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Users;
import entity.UsersFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author saurya
 */
@Stateless
public class LoginBean implements LoginBeanLocal {
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private UsersFacadeLocal usersFacade;
    
    private Users user;
    
    @Override 
    public boolean isValidLoginDetails(String userName, String password)
    {
        boolean valid = false;
        
        user = null;
        try{
        Query query = em.createQuery("SELECT u " + "FROM Users u " + "WHERE u.email = :email AND u.password = :password");
        query.setParameter("email", userName);
        query.setParameter("password", password);
        user = (Users)query.getSingleResult();
        }
        catch(NoResultException e)
        {
            
        }
        if(user != null && !user.getIsAdmin()){
            
            valid = true;
        }
        return valid;
    }
    
    @Override
    public void startUserSession(HttpServletRequest request, Users user)
    {
        request.getSession().setAttribute("auth", user.getUserId());
        request.getSession().setAttribute("isAdmin", user.getIsAdmin());
        request.getSession().setAttribute("name", user.getFirstName());
        request.getSession().setMaxInactiveInterval(30*60);
    }
    
    @Override
    public Users getUser()
    {
        return user;
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    

    
}
