/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.UserBookmark;
import entity.UserLoan;
import entity.Users;
import entity.UsersComment;
import entity.UsersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saurya
 */
@Stateless
public class ProfileBean implements ProfileBeanLocal {
    

    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private UsersFacadeLocal usersFacade;
    
    @Override
    public Users getUserDetails(Integer id)
    {
        return usersFacade.find(id);
    }
    
    @Override
    public List<UserBookmark> getUserBookmark(Users user)
    {
        List<UserBookmark> bookmarkList = null;
        try{
            Query q = em.createQuery("SELECT u FROM UserBookmark u WHERE u.userId = :userId");
            q.setParameter("userId", user);
            bookmarkList = (List)q.getResultList();
        }
        catch(NoResultException e){
            
        }
        return bookmarkList;
    }
    
    @Override
    public List<UserLoan> getUserLoan(Users user)
    {
        List<UserLoan> loanList = null;
        try{
            Query q = em.createQuery("SELECT u FROM UserLoan u WHERE u.userId = :userId");
            q.setParameter("userId", user);
            loanList = (List)q.getResultList();
        }
        catch(NoResultException e){
        }
        return loanList;
    }
    
    @Override
    public List<UsersComment> getUserComment(Users user)
    {
        List<UsersComment> cmntList = null;
        try{
            Query q = em.createQuery("SELECT u FROM UsersComment u WHERE u.userId = :userId ORDER BY u.commentId DESC");
            q.setParameter("userId", user);
            cmntList = (List)q.getResultList();
        }
        catch(NoResultException e)
        {
            
        }
        return cmntList;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
