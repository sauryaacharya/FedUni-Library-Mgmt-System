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
public interface UserBookmarkFacadeLocal {

    void create(UserBookmark userBookmark);

    void edit(UserBookmark userBookmark);

    void remove(UserBookmark userBookmark);

    UserBookmark find(Object id);

    List<UserBookmark> findAll();

    List<UserBookmark> findRange(int[] range);

    int count();
    
}
