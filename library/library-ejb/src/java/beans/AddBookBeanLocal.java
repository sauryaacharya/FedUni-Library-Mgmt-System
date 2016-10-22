/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.BooksCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface AddBookBeanLocal {
    
    void addBook(Books book);
    
    List<BooksCategory> getBookCategory();
    
    Books getBookById(Integer id);
    
    void updateBook(Books book);
    
    void deleteBook(Books book);
    
    List<Books> getBookByCategoryId(BooksCategory cat);
    
    List<Books> getAllBooks();
    
    List<Books> getNewlyAddedBooks();
    
}
