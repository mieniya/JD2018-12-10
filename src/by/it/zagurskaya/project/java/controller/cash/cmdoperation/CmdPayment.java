package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.beans.SprOperations;
import by.it.zagurskaya.project.java.controller.*;
import by.it.zagurskaya.project.java.dao.SprOperationsDao;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CmdPayment implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        SprOperationsDao sprOperationsDao = new SprOperationsDao();
//        List<SprOperations> sprOperationsAll = new ArrayList<SprOperations>();
//        sprOperationsAll.addAll(sprOperationsDao.getAll());
        List<SprOperations> sprOperationsAll = sprOperationsDao.getAll();
        req.setAttribute("sprOperationsAll", sprOperationsAll);


        if (Form.isPost(req)) {
            List<SprOperations> selectedOperationFromSprOperationsList = new ArrayList<SprOperations>();
            Long sprOperationsId = Long.parseLong(Form.getString(req, "SprOperationsId"));
            if (sprOperationsId != null) {

                selectedOperationFromSprOperationsList.addAll(sprOperationsDao.getAll(" WHERE id=" + sprOperationsId));
                SprOperations sprOperations = selectedOperationFromSprOperationsList.get(0);
                if (selectedOperationFromSprOperationsList.size() > 0) {
                    req.setAttribute("SprOperations", selectedOperationFromSprOperationsList.get(0));
                }
                switch(sprOperationsId.toString()) {
                    case "10":
                        Action.PAYMENT10.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT10;
                    case "20":
                        Action.PAYMENT20.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT20;
                    case "998":
                        Action.PAYMENT998.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT998;
                    case "1000":
                        Action.PAYMENT1000.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT1000;
                    case "1100":
                        Action.PAYMENT1100.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT1100;
                    default : //необязательно
                        Action.PAYMENT.setPATH("/cash/operation/");
                        return Action.PAYMENT;
                }
            }
        }
        Action.PAYMENT.setPATH("/cash/operation/");
        return Action.PAYMENT;
    }
}
