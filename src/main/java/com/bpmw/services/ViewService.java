package com.bpmw.services;

import com.bpmw.persistence.View;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

/**
 * Class to work with a database model.
 * @author ppetr
 * @version 1.0
 */
@Stateless
public class ViewService{

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    /**
     * This method returns all the views of a database.
     * @return - Views list.
     */
    public List<View> returnAllViews(){
        List<View> resultList = em.createNamedQuery("View.findAll", View.class).getResultList();
        return resultList;
    }

    /**
     * This method returns the user views of the database.
     * @param login - user login.
     * @return - Views list.
     */
    public List<View> returnViewUser(String login){
        Query query = em.createQuery("select v from View v WHERE v.user.login = :login");
        query.setParameter("login", login);
        return query.getResultList();
    }

    /**
     * The method is used to add a new viewing. It accepts as a parameter an
     * object View and makes an entry in the database.
     * @param view - object (View).
     */
    public void addView (View view){
        em.persist(view);
    }

    /**
     * The method is used to delete a view.
     * Takes the view ID, search the desired record in the database and deletes.
     * @param id - id view.
     */
    public void delView (Integer id){
        View view = em.find(View.class, id);
        em.remove(view);
    }

    /**
     * The method used to obtain view by id.
     * It takes as a parameter identifier view is looking for the desired item, and returns an object.
     * @param id - id view.
     * @return - object (View).
     */
    public View getView(Integer id){
        return em.find(View.class, id);
    }

    /**
     * The method is used to update the existing view.
     * The parameter takes view object and updates the corresponding record in the database.
     * @param view - object (View).
     */
    public void updView (View view){
        em.merge(view);
    }
}