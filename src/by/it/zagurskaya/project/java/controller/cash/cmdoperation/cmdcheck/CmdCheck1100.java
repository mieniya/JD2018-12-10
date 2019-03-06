package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdcheck;


import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdCheck1100 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        List<Ad> ads = Dao.getDao().ad.getAll();
//        req.setAttribute("ads",ads);
        Action.CHECK1100.setPATH("/cash/operation/check/");
        return Action.CHECK1100;
    }
}
