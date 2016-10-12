package com.bpmw.services;

import com.bpmw.persistence.User;
import com.bpmw.persistence.View;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.transaction.cdi.Transactional;
import java.util.List;

@RequestScoped
@Transactional(value = Transactional.TxType.REQUIRED)
public class ViewService{


    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    public List<View> returnAllViews(){
        List<View> resultList = em.createNamedQuery("View.findAll", View.class).getResultList();
        return resultList;
    }

    public List<View> returnViewUser(User user){
        Query query = em.createQuery("select v from View v WHERE v.user.login = :login");
        query.setParameter("login", user.getLogin());
        return query.getResultList();
    }

    public void addView (View view){
        em.persist(view);
    }

    public void delView (Integer id){
        View view = em.find(View.class, id);
        em.remove(view);
    }

    public View getView(Integer id){
        return em.find(View.class, id);
    }

    public void updView (View view){
        em.merge(view);
    }
}

