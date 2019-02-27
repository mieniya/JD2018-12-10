package by.it.skosirskiy.project.java.controller;

import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdCreateRequest implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if(Form.isPost(req)){
            String type = Form.getString(req, "type");
            Timestamp date_create = Timestamp.valueOf(LocalDateTime.now());
            Timestamp date_complete = new Timestamp(0L);
            date_complete.setTime(date_create.getTime()+259200000L);  // прибавляем 3 дня
            Integer user_id =Form.getInt(req,"user_id");
            Integer address_id = Form.getInt(req,"address_id");
            Integer status_id = Form.getInt(req,"status_id");

            Request request= new Request(0,type,date_create,date_complete,user_id,address_id,status_id);
            Dao dao= Dao.getDao();
            if(dao.request.create(request)){
                return Action.INDEX;
            }
        }
        return Action.CREATEREQUEST;
    }
}
