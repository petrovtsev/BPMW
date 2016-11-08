package com.bpmw.services;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.web.model.user.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * The class will perform a function to create objects from the collection of string values.
 * @author ppetr
 * @version 1.0
 *
 */
@RequestScoped
public class InitializationObjectService {

    @Inject
    private PasswordService passwordService;

    @Inject
    private TaskGroupService taskGroupService;

    @Inject
    private UserModel userModel;

    /**
     * The method takes a set of parameters and the object that needs to be filled.
     * Then it gets an array of fields derived class object. In a series of checks for the parameters
     * of the collection in the class of the object in the case of conformity converts
     * to the desired type and records.
     *
     * @param par - сollection of fields.
     * @param object - object to fill
     * @return - filled object/
     * @throws IllegalAccessException
     * @throws ParseException - if an error occurs during the conversion date.
     * @throws NoSuchFieldException
     */
    public Object createObject(Map par, Object object)
            throws IllegalAccessException, ParseException, NoSuchFieldException {

        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, String[]> parameters = par;

        for (Map.Entry<String, String[]> entry : parameters.entrySet()){

            if (verifyField(entry.getKey(), fields)) {
                Field field = object.getClass().getDeclaredField(entry.getKey());
                field.setAccessible(true);

                if (entry.getKey().hashCode() == "password".hashCode()) {
                    String passHash = passwordService.passwordHash(entry.getValue()[0]);
                    field.set(object, passHash);

                } else if (field.getType().getName().hashCode() == "String".hashCode()){
                    field.set(object, entry.getValue()[0]);

                } else if (field.getType().getSimpleName().hashCode() == "Date".hashCode()) {
                    if (entry.getValue()[0].hashCode() != "".hashCode()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        field.set(object, dateFormat.parse(entry.getValue()[0]));
                    }

                }else if (field.getType().getName().hashCode() == "Integer".hashCode()){
                    field.set(object, Integer.valueOf(entry.getValue()[0]));

                } else if (entry.getKey().hashCode() == "taskGroup".hashCode()) {
                    TaskGroup taskGroup = taskGroupService.getGroup(Integer.valueOf(entry.getValue()[0]));
                    field.set(object, taskGroup);

                } else if (entry.getKey().hashCode() == "user".hashCode()) {
                    User user = userModel.getUser(entry.getValue()[0]);
                    field.set(object, user);

                } else {
                    field.set(object, entry.getValue()[0]);
                }
            }
        }
        return object;
    }

    /**
     * The method takes an array of object parameters and the name of the field from the resulting collection.
     * If the field name of the collection is available in an array returns a boolean 'true'.
     * @param name - field name from the collection.
     * @param fields - an array of class fields.
     * @return - boolean value. In the case that returns 'true'.
     */
    private Boolean verifyField(String name, Field[] fields){
        Boolean b = false;
        for (Field field: fields){
            if (field.getName().hashCode() == name.hashCode()){
                b = true;
                break;
            }
        }
        return b;
    }
}
