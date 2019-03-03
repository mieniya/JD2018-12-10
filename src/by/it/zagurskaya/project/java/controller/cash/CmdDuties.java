package by.it.zagurskaya.project.java.controller.cash;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.Kassa;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.KassaDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdDuties implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        String todaySQL = Util.getFormattedLocalDateOnlyDate(date);
        DutiesDao dutiesDao = new DutiesDao();

        if (Form.isPost(req)) {
            if (req.getParameter("open") != null) {
//                новая запись в duties
                Timestamp now = new Timestamp(System.currentTimeMillis());
                Duties duties = new Duties(0, user.getId(), now, NumberDutiesToday(user, today), false);
                dutiesDao.create(duties);
//                новая запись в kassa
                CurrencyDao currencyDao = new CurrencyDao();
                KassaDao kassaDao = new KassaDao();

                for (Currency c : currencyDao.getAll()) {
                    kassaDao.create(new Kassa(0, c.getId(), 0, 0, 0, 0, 0, user.getId(), java.sql.Date.valueOf(date), duties.getNumber()));
                }

//                currencyDao.getAll().stream()
//                        .forEach(c -> {
//                            try {
//                                kassaDao.create(new Kassa(0, c.getId(), 0, 0, 0, 0, 0, user.getId(), java.sql.Date.valueOf(date), duties.getNumber()));
//                            } catch (SQLException e) {
//                                throw new RuntimeException(e);
//                            }
//                        });

            } else if (req.getParameter("close") != null) {
                long id = OpenDutiesUserToday(user, today).get(0).getId();
                long userId = OpenDutiesUserToday(user, today).get(0).getUserId();
                Timestamp timestamp = OpenDutiesUserToday(user, today).get(0).getTimestamp();
                int number = OpenDutiesUserToday(user, today).get(0).getNumber();
                Duties closeDuties = new Duties(id, userId, timestamp, number, true);
                dutiesDao.update(closeDuties);
            }
        }

        OpenDutiesUserToday(user, today).stream().limit(1).forEach(d -> req.setAttribute("duties", d));
//        List<Duties> openDuties = OpenDutiesUserToday(user, today);
//        if (openDuties.size() > 0) {
//            req.setAttribute("duties", openDuties.get(0));
//        }
        Action.DUTIES.setPATH("/cash/");
        return Action.DUTIES;
    }

    static Integer NumberDutiesToday(User user, String today) throws SQLException {
        DutiesDao dutiesDao = new DutiesDao();

        if (user == null) {
            throw new IllegalArgumentException("пользователь должен быть!!!");
        }


        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`= 1", user.getId(), today);
        List<Duties> closeDutiesList = dutiesDao.getAll(where);

        Integer numberDuties = closeDutiesList.stream().map(Duties::getNumber).max(Integer::compareTo).orElse(0) + 1;
//            if (closeDutiesList.size() != 0) {
//                List<Integer> closeDutiesNumberList = new ArrayList<Integer>();
//                for (Duties duties : closeDutiesList) {
//                    closeDutiesNumberList.add(duties.getNumber());
//                }
//                numberDuties = Integer.parseInt(Collections.max(closeDutiesNumberList).toString()) + 1;
//            } else {
//                numberDuties = 1;
//            }
        return numberDuties;
    }

    static List<Duties> OpenDutiesUserToday(User user, String today) throws SQLException {
        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`=0", user.getId(), today);
        DutiesDao dutiesDao = new DutiesDao();
        List<Duties> duties = dutiesDao.getAll(where);
        return duties;
    }
}
