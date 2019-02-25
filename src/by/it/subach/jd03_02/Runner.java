package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
//  user
        UserCRUD userCRUD = new UserCRUD();
        User user = new User(0, "TestUser", "testemail", "testpassword", 2);
        if (userCRUD.create(user))
            System.out.println("Create OK " + user);
        if (userCRUD.update(user))
            System.out.println("Update OK " + user);
        user = userCRUD.read(user.getId());
        if (user != null) {
            System.out.println("Read OK " + user);
        }
        if (userCRUD.delete(user))
            System.out.println("Delete OK " + user);

//  role
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role(0, "testRole");
        if (roleCRUD.create(role))
            System.out.println("Create OK " + role);
        if (roleCRUD.update(role))
            System.out.println("Update OK " + role);
        role = roleCRUD.read(role.getId());
        if (role != null) {
            System.out.println("Read OK " + role);
        }
        if (roleCRUD.delete(role)) {
            System.out.println("Delete OK " + role);
        }

//  category

        CategoryCRUD categoryCRUD = new CategoryCRUD();
        Category category = new Category(0, "testCategory", "test description");
        if(categoryCRUD.create(category))
            System.out.println("Create OK " + category);
        if(categoryCRUD.update(category))
            System.out.println("Update OK " + category);
        category = categoryCRUD.read(category.getId());
        if(category != null)
            System.out.println("Read OK " + category);
        if(categoryCRUD.delete(category))
            System.out.println("Delete OK " + category);

//  product

        ProductCRUD productCRUD = new ProductCRUD();
        Product product = new Product(0, "testName", 20.0, "testDescription", 2);
        if(productCRUD.create(product))
            System.out.println("Create OK " + product);
        if(productCRUD.update(product))
            System.out.println("Update OK " + product);
        product = productCRUD.read(product.getId());
        if(product != null)
            System.out.println("Read OK " + product);
        if(productCRUD.delete(product))
            System.out.println("Delete OK " + product);


//  order
        OrderCRUD orderCRUD = new OrderCRUD();
        Order order = new Order(0, 1, 2);
        if(orderCRUD.create(order))
            System.out.println("Create OK " + order);
        if(orderCRUD.update(order))
            System.out.println("Update OK " + order);
        order = orderCRUD.read(order.getId());
        if(order != null)
            System.out.println("Read OK " + order);
        if(orderCRUD.delete(order))
            System.out.println("Delete OK " + order);


//   checkout

        CheckoutCRUD checkoutCRUD = new CheckoutCRUD();
        Checkout checkout = new Checkout(0, 0, 1);
        if(checkoutCRUD.create(checkout))
            System.out.println("Create OK " + checkout);
        if(checkoutCRUD.update(checkout))
            System.out.println("Update OK " + checkout);
        checkout = checkoutCRUD.read(checkout.getId());
        if(checkout != null)
            System.out.println("Read OK " + checkout);
        if(checkoutCRUD.delete(checkout))
            System.out.println("Delete OK " + checkout);

//   blacklist

    }



}
