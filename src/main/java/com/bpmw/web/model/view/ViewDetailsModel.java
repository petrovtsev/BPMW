package com.bpmw.web.model.view;

import com.bpmw.persistence.View;
import com.bpmw.services.ValidateService;
import com.bpmw.services.ViewService;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author ppetr
 */

@Named
@RequestScoped
public class ViewDetailsModel {

    @Inject
    private ViewService viewService;

    @Inject
    private UserModel userModel;

    @Inject
    private ValidateService validateService;

    private View selectedView;

    public void init(){
        selectedView = new View();
    }

    public Boolean validate(){
        return validateService.validate(selectedView);
    }

    public void addView(){
        viewService.addView(selectedView);
    }

    public void updView(){
        viewService.updView(selectedView);
    }

    public View getView(Integer id){
        selectedView = viewService.getView(id);
        return selectedView;
    }

    public View getSelectedView() {
        return selectedView;
    }

    public void setSelectedView(View selectedView) {
        this.selectedView = selectedView;
    }
}