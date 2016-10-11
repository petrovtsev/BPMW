package com.bpmw.web.model;

import com.bpmw.persistence.TaskGroup;
import com.bpmw.persistence.User;
import com.bpmw.persistence.View;
import com.bpmw.services.ViewService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.cdi.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ppetr
 */

@Named
@Transactional
@RequestScoped
public class ViewModel {

    @Inject
    private ViewService viewService;

    @Inject
    private UserModel userModel;

    /**
     * Метод принмает значения переданные сервлетом, преобразует их в объекты и создает новый запрос для пользователя
     * @param login - логин активного пользователя
     * @param nameView - название запроса
     * @param dateStartString - дата начиная с которой ищем задачи
     * @param dateEndString - дата заканчивая которой ищем задачи
     * @param statusComplete - статус задачи (all, completed, not completed).
     *                       C помощью этого значению выводятся выполненные, невыполненные или все задачи.
     * @throws ParseException
     */
    public void addView(String login, String nameView, String dateStartString, String dateEndString, String statusComplete)
            throws ParseException {
        User user = userModel.getUser(login);
        TaskGroup taskGroup = user.getTaskGroup();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = dateFormat.parse(dateStartString);
        Date dateEnd = dateFormat.parse(dateEndString);
        if (statusComplete == "completed") {
            statusComplete = " AND t.t.dateComplet NOT NULL;";
        } else if (statusComplete == "notCompleted") {
            statusComplete = " AND t.t.dateComplet = NULL;";
        } else statusComplete = ";";

        String query = "select t from Task t WHERE t.taskGroup.id = " + taskGroup.getId() +
                " AND  (t.dateIn > " + dateStart + " AND < " + dateEnd + ")" + statusComplete;
        View view = new View(nameView, query, user);
        viewService.addView(view);
    }

    /**
     * Метод принимает объект User и возвращает все запросы этого пользователя.
     * @param user
     * @return
     */
    public List<View> returnViewUser(User user){
        return viewService.returnViewUser(user);
    }

    /**
     * Метод возвращает запросы всех пользователей.
     * @return
     */
    public List<View> returnAllViews(){
        return viewService.returnAllViews();
    }

}
