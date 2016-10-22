/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Books;
import entity.BooksFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author saurya
 */
@Stateless
public class AdminDashboardBean implements AdminDashboardBeanLocal {
    @EJB
    private BooksFacadeLocal booksFacade;
    
    @Override
    public List<Books> getAllBook()
    {
        return booksFacade.findAll();
    }
}
