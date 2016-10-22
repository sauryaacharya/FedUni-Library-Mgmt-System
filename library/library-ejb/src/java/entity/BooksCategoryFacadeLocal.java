/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface BooksCategoryFacadeLocal {

    void create(BooksCategory booksCategory);

    void edit(BooksCategory booksCategory);

    void remove(BooksCategory booksCategory);

    BooksCategory find(Object id);

    List<BooksCategory> findAll();

    List<BooksCategory> findRange(int[] range);

    int count();
    
}
