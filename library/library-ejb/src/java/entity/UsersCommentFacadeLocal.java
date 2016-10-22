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
public interface UsersCommentFacadeLocal {

    void create(UsersComment usersComment);

    void edit(UsersComment usersComment);

    void remove(UsersComment usersComment);

    UsersComment find(Object id);

    List<UsersComment> findAll();

    List<UsersComment> findRange(int[] range);

    int count();
    
}
