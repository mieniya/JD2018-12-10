package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.Kassa;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.controller.cash.CmdDuties;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.KassaDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class CmdPayment1000 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
//        "yyyy-MM-dd"
        String todaySQL = Util.getFormattedLocalDateOnlyDate(date);
        List<Duties> duties = CmdDuties.OpenDutiesUserToday(user, today);
        KassaDao kassaDao = new KassaDao();


        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);

        if (Form.isPost(req)) {
            long[] ids = Form.getLongArray(req, "id");
            long[] summs = Form.getLongArray(req, "summ");

            for (int i = 0; i < ids.length; i++) {
                Kassa kassa = kassaDao.readByCurrencyIdAndDateAndDutiesNumber(ids[i],  Date.valueOf(todaySQL), duties.get(0).getNumber());


            }


//            Long currencyId = Long.parseLong(Form.getString(req, "id","[0-9]{1,}"));
//            String currencySumm = Form.getString(req, "summ", "[0-9]{1,}");

//            for (Currency c : currencyDao.getAll()) {
//                kassaDao.update(new Kassa(0, c.getId(), 0, 0, 0, 0, 0, user.getId(), java.sql.Date.valueOf(date), duties.get(0).getNumber()));
//            }

        }
        Action.PAYMENT1000.setPATH("/cash/operation/payment/");
        return Action.PAYMENT1000;
    }
}
