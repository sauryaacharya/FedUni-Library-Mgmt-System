/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import java.util.List;
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
public class SearchBean implements SearchBeanLocal {
    
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Books> searchBook(String searchText)
    {
        List<Books> searchResult = null;
        try{
            Query q = em.createQuery("SELECT b FROM Books b WHERE b.author LIKE :author OR b.title LIKE :title OR b.isbn LIKE :isbn");
            q.setParameter("author", "%" + searchText + "%");
            q.setParameter("title", "%" + searchText + "%");
            q.setParameter("isbn", "%" + searchText + "%");
            searchResult = (List)q.getResultList();
        }
        catch(NoResultException e){
            
        }
        return searchResult;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
