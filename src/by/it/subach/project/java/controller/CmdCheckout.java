package by.it.subach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdCheckout implements Cmd{


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            String name = Form.getString(req, "name");
            String tel = Form.getString(req, "tel");
            String card = Form.getString(req, "cardnumber");
        }
        return Action.CHECKOUT;
    }
}
