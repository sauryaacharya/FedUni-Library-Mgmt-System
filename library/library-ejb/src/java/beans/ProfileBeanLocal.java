/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.UserBookmark;
import entity.UserLoan;
import entity.Users;
import entity.UsersComment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface ProfileBeanLocal {
    
    Users getUserDetails(Integer id);
    
    List<UserBookmark> getUserBookmark(Users user);
    
    List<UserLoan> getUserLoan(Users user);
    
    List<UsersComment> getUserComment(Users user);
}
