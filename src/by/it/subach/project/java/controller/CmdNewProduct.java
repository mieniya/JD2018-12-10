package by.it.subach.project.java.controller;


import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdNewProduct implements Cmd{


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            DAO dao = DAO.getInstance();
            String name = Form.getString(req, "name");
            double price = Form.getDouble(req, "price");
            String description = Form.getString(req, "description");
            long category_id = Integer.parseInt(Form.getString(req, "category"));

            Product product = new Product();
            product.setCategories_id(category_id);
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);

            if(dao.product.create(product))
                return Action.INDEX;

        }
        return Action.CREATEPRODUCT;
    }
}
