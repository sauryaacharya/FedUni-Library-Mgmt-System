/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.UserBookmark;
import entity.UserBookmarkFacadeLocal;
import entity.Users;
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
public class BookMarkBean implements BookMarkBeanLocal {
    @EJB
    private UserBookmarkFacadeLocal userBookmarkFacade;
    
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @Override
    public void postBookMark(UserBookmark b)
    {
        userBookmarkFacade.create(b);
    }
    
    @Override
    public boolean isBookMarkExists(Users u, Books b)
    {
        boolean exists = true;
        UserBookmark bookMark = null;
        try{
            Query q = em.createQuery("SELECT u FROM UserBookmark u WHERE u.userId = :userId AND u.bookId = :bookId");
            q.setParameter("userId", u);
            q.setParameter("bookId", b);
            bookMark = (UserBookmark)q.getSingleResult();
        }
        catch(NoResultException e){
            
        }
        if(bookMark == null){
            exists = false;
        }
        return exists;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
