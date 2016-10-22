/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.UserLoan;
import javax.ejb.Local;

/**
 *
 * @author saurya
 */
@Local
public interface LoanBeanLocal {
    
    void loanBook(UserLoan loan);
    
}
