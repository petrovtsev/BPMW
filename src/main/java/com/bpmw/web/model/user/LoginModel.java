package com.bpmw.web.model.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginModel {

    @Inject
    private UserModel userModel;

    private String errorMessage;
    private Boolean errorStatus = false;

    public Boolean validateLogin(String login, String password){
        errorMessage = "";
        errorStatus = false;
        if (userModel.getUser(login) != null){
            if (userModel.getUser(login).getPassword().hashCode() == password.hashCode()){
                errorStatus = false;
            } else {
                errorMessage = "Incorrect password";
                errorStatus = true;
            }
        } else {
            errorMessage = "Incorrect login";
            errorStatus = true;
        }
        return errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }
}