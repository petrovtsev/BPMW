package com.bpmw.services;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ppetr on 16.10.2016.
 */

@Stateless
@Named
public class ValidateService {

    private List<String> errorList = new ArrayList<String>();
    private Boolean errorStatus = false;

    @Remove
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
