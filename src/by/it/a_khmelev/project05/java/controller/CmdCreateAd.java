package by.it.a_khmelev.project05.java.controller;

import by.it.a_khmelev.project05.java.beans.Ad;
import by.it.a_khmelev.project05.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)){
            Ad ad=new Ad();
            ad.setDescription(Form.getString(req, "description"));
            ad.setAddress(Form.getString(req, "address"));
            ad.setUsers_id(3);
            if (Dao.getDao().ad.create(ad))
                return Action.INDEX;

        }
        return Action.CREATEAD;
    }
}
