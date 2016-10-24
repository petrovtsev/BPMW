package com.bpmw.web.model.view;

import com.bpmw.persistence.View;
import com.bpmw.services.ViewService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * The class is used to work with a list of views.
 */
@Named
@RequestScoped
public class ListViewsModel {

    @Inject
    private ViewService viewService;

    /**
     * List active user views.
     */
    private List<View> viewsActiveUser;

    /**
     * The method used to remove the view.
     * The parameter accepts:
     * @param idView - id view.
     */
    public void delView(Integer idView){
        viewService.delView(idView);
    }

    /**
     * The method takes all user views.
     * The parameter accepts:
     * @param login - username.
     */
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