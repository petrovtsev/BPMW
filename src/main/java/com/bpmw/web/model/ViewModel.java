package com.bpmw.web.model;

import com.bpmw.persistence.User;
import com.bpmw.persistence.View;
import com.bpmw.services.ViewService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ppetr on 28.09.2016.
 */

@Named
@RequestScoped
public class ViewModel {

    @Inject
    private ViewService viewService;

    @Inject
    private UserModel userModel;

    public List<View> returnViewUser(User user){
        return viewService.returnViewUser(user);
    }

    public List<View> returnAllViews(){
        return viewService.returnAllViews();
    }


    public void addView(String name, String request, String login){
        View view =  new View(name, request, userModel.getUser(login));
        viewService.addView(view);
    }
}
