/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface SearchBeanLocal {
    
    List<Books> searchBook(String searchText);
    
}
