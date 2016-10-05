package com.bpmw.services;

import com.bpmw.persistence.Group;
import com.bpmw.persistence.View;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Named
@ApplicationScoped
public class ViewService{

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;


    public List<View> returnAllViews(){
        List<View> resultList = em.createNamedQuery("View.findAll", View.class).getResultList();
        return resultList;
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

