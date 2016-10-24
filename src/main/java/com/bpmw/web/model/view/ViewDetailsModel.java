package com.bpmw.web.model.view;

import com.bpmw.persistence.View;
import com.bpmw.services.ValidateService;
import com.bpmw.services.ViewService;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;

/**
 * The class is for working with data view
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

    /**
     * Selected view.
     */
    private View selectedView;

    /**
     * The method initializes the object.
     */
    public void init(){
        selectedView = new View();
        Date date = new Date();
        selectedView.setDateStart(date);
        selectedView.setDateEnd(date);
    }

    /**
     * Method to check the data and returns a Boolean value (true, in case of an error)
     * @return - Boolean value.
     */
    public Boolean validate(){
        return validateService.validate(selectedView);
    }


    /**
     * The method create a new view.
     */
    public void addView(){
        viewService.addView(selectedView);
    }


    /**
     * The method updates the view data.
     */
    public void updView(){
        viewService.updView(selectedView);
    }

    /**
     * The method used to obtain the task by ID.
     * @param id = id view.
     * @return - object view.
     */
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