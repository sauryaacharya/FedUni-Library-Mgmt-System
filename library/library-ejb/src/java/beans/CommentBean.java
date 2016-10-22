/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.UsersComment;
import entity.UsersCommentFacadeLocal;
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
public class CommentBean implements CommentBeanLocal {
    

    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private UsersCommentFacadeLocal usersCommentFacade;
    
    
    @Override
    public void postComment(UsersComment c)
    {
        usersCommentFacade.create(c);
    }
    
    @Override
    public List<UsersComment> getCommentByBookId(Books book)
    {
        List<UsersComment> comment_list = null;
        try{
            Query q = em.createQuery("SELECT u FROM UsersComment u WHERE u.bookId = :book_id");
            q.setParameter("book_id", book);
            comment_list = (List)q.getResultList();
        }
        catch(NoResultException e){
        
        }
        return comment_list;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
