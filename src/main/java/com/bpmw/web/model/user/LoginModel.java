package com.bpmw.web.model.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * The class is used for user authentication.
 */
@Named
@RequestScoped
public class LoginModel {

    @Inject
    private UserModel userModel;

    /**
     * Error message
     */
    private String errorMessage;

    /**
     * Error status.
     */
    private Boolean errorStatus = false;

    /**
     * The method used to check the entered data (username and password).
     * In the case of errors in the data it
     * returns a boolean value of "true" and sends a list of errors.
     * As the parameters takes:
     * @param login - user login.
     * @param password - user password.
     * @return
     */
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