/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.BooksCategory;
import entity.BooksCategoryFacadeLocal;
import entity.BooksFacadeLocal;
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
public class AddBookBean implements AddBookBeanLocal {
    
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private BooksCategoryFacadeLocal booksCategoryFacade;
    
    @EJB
    private BooksFacadeLocal booksFacade;
    
    
    

    @Override
    public void addBook(Books book)
    {
        booksFacade.create(book);
    }
    
    @Override 
    public List<BooksCategory> getBookCategory()
    {
        return booksCategoryFacade.findAll();
    }
    
    @Override 
    public Books getBookById(Integer id)
    {
        return booksFacade.find(id);
    }
    
    @Override 
    public void updateBook(Books book)
    {
        booksFacade.edit(book);
    }
    
    @Override
    public void deleteBook(Books book)
    {
        booksFacade.remove(book);
    }
    
    @Override
    public List<Books> getAllBooks()
    {
        return booksFacade.findAll();
    }
    
    @Override
    public List<Books> getNewlyAddedBooks() throws NullPointerException
    {
        List<Books> book_list = null;
        try{
            Query q = em.createQuery("SELECT b FROM Books b ORDER BY b.bookId DESC");
            book_list = (List)q.setMaxResults(5).getResultList();
        }
        catch(NoResultException e){
        }
        return book_list;
    }
    
    
    @Override
    public List<Books> getBookByCategoryId(BooksCategory cat)
    {
        List<Books> book_list = null;
        try{
            Query q = em.createQuery("SELECT b FROM Books b WHERE b.categoryId = :categoryId");
            q.setParameter("categoryId", cat);
            book_list = (List)q.getResultList();
        }
        catch(NoResultException e){
        }
        return book_list;
    }
    
    
            
}
