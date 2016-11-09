package com.bpmw.services;

import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The class is used to check the data obtained in accordance with the job requirements
 * and displays the information in the case to inadequate.
 * @author ppetr
 * @version 1.0
 */
@RequestScoped
public class ValidateService {

    /**
     * @param errorList - it contains a list of messages.
     */
    private List<String> errorList = new ArrayList<String>();

    /**
     * @param errorStatus - the parameter is used for information
     *                  about the presence of messages to the user.
     */
    private Boolean errorStatus = false;

    /**
     * The method used to check the data obtained in accordance with the requirements specification.
     * It receives as a parameter an object (entity). In the case of detected errors
     * makes any appropriate entry in the error list.
     * Returns A Boolean value of the test result. (False if no errors).
     * As well as changing the value of a parameter error StatusTask.
     * @param object - object (entity)
     * @return - A Boolean value (true if there were errors or false if no errors)
     */
    public Boolean validate (Object object){
        errorList.clear();
        errorStatus = false;
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<Object> cv : constraintViolations){
            errorList.add(cv.getMessage());
        }
        if (errorList.size() > 0){
            errorStatus = true;
            return errorStatus;
        } else return errorStatus;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    public Boolean getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }
}
