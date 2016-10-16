package com.bpmw.web.model.view;

import com.bpmw.persistence.User;
import com.bpmw.persistence.UserRequest;
import com.bpmw.persistence.View;
import com.bpmw.services.ViewService;
import com.bpmw.web.model.user.UserModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
@Stateless
public class ViewModel {

    @EJB
    private ViewService viewService;

    @EJB
    private UserModel userModel;

    View selectedView = new View();

    /**
     * Метод принмает значения переданные сервлетом и создает новый запрос для пользователя
     * @param login - логин активного пользователя
     * @param nameView - название запроса
     * @param dateStartString - дата начиная с которой ищем задачи
     * @param dateEndString - дата заканчивая которой ищем задачи
     * @param statusComplete - статус задачи (all, completed, not completed).
     *                       C помощью этого значению выводятся выполненные, невыполненные или все задачи.
     * @throws ParseException - в случае..
     */
    public void addView(String login, String nameView, String dateStartString, String dateEndString, String statusComplete)
            throws ParseException {
        User user = userModel.getUser(login);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = dateFormat.parse(dateStartString);
        Date dateEnd = dateFormat.parse(dateEndString);
        UserRequest userRequest = new UserRequest(dateStart, dateEnd, statusComplete);
        View view = new View(nameView, user, userRequest);
        viewService.addView(view);
    }

    /**
     * Метод принимает Login пользователя и возвращает все его запросы.
     * @param login
     * @return
     */
    public List<View> returnViewUser(String login){
        return viewService.returnViewUser(login);
    }

    /**
     * Метод возвращает запросы всех пользователей.
     * @return
     */
    public List<View> returnAllViews(){
        return viewService.returnAllViews();
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