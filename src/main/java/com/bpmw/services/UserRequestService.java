package com.bpmw.services;

import com.bpmw.persistence.UserRequest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class UserRequestService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;

    public List<UserRequest> returnAllUserRequest(){
        List<UserRequest> resultList = em.createNamedQuery("UserRequest.findAll", UserRequest.class).getResultList();
        return resultList;
    }

    public UserRequest getUserRequest(Integer id){
        return em.find(UserRequest.class, id);
    }
}