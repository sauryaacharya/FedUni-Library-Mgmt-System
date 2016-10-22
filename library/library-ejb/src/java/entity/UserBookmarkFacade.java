/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author saurya
 */
@Stateless
public class UserBookmarkFacade extends AbstractFacade<UserBookmark> implements UserBookmarkFacadeLocal {
    @PersistenceContext(unitName = "library-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserBookmarkFacade() {
        super(UserBookmark.class);
    }
    
}
