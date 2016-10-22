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
public interface UserLoanFacadeLocal {

    void create(UserLoan userLoan);

    void edit(UserLoan userLoan);

    void remove(UserLoan userLoan);

    UserLoan find(Object id);

    List<UserLoan> findAll();

    List<UserLoan> findRange(int[] range);

    int count();
    
}
