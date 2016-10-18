package com.bpmw.web.model.view;

import com.bpmw.persistence.View;
import com.bpmw.services.ViewService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author ppetr
 */

@Named
@RequestScoped
public class ListViewsModel {

    @Inject
    private ViewService viewService;

    private List<View> viewsActiveUser;

    public void delView(Integer idView){
        viewService.delView(idView);
    }

    public void returnViewsActiveUser(String login){
        viewsActiveUser = viewService.returnViewUser(login);
    }

    public List<View> getViewsActiveUser() {
        return viewsActiveUser;
    }

    public void setViewsActiveUser(List<View> viewsActiveUser) {
        this.viewsActiveUser = viewsActiveUser;
    }
}