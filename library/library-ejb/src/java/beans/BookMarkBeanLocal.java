/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.UserBookmark;
import entity.Users;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface BookMarkBeanLocal {
    
    void postBookMark(UserBookmark b);
    
    boolean isBookMarkExists(Users u, Books b);
    
}
