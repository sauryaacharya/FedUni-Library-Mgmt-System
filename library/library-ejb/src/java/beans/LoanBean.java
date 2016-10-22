/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.UserLoan;
import entity.UserLoanFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author saurya
 */
@Stateless
public class LoanBean implements LoanBeanLocal {
    
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;
    
    @EJB
    private UserLoanFacadeLocal userLoanFacade;
    
    @Override
    public void loanBook(UserLoan loan)
    {
        userLoanFacade.create(loan);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
