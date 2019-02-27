package by.it.lyakhova.jd03_03;

import by.it.lyakhova.jd03_03.bean.*;
import by.it.lyakhova.jd03_03.dao.Dao;
import by.it.lyakhova.jd03_03.dao.MyUniversalDao;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

//---------------------- USERS  ---------------------------------------------------------
        User user = new User(0, "TestUser", "TestPassword", "TestEmail",
                "TestContacts", 2);

        if (dao.user.create(user)) System.out.println("Create ok " + user);

        user.setLogin("TestUserUpdate");
        if (dao.user.update(user)) System.out.println("update ok " + user);

        user = dao.user.read(user.getId());
        if(user!=null) System.out.println("read ok " + user);

        if (dao.user.delete(user)) System.out.println("delete ok " + user);


        @SuppressWarnings("unchecked") MyUniversalDao<User> doUser = new MyUniversalDao(User.class, "users");
        user = new User(0, "TestUser", "TestPassword", "TestEmail",
                "TestContacts", 1);

        if (doUser.create(user)) System.out.println("UNIVERSAL DAO CREATEGOODSFLOWER " + user);
        user.setLogin("TestUserUpdate");

        if (doUser.update(user)) System.out.println("UNIVERSAL DAO UPDATE " + user);

        user = doUser.read(user.getId());
        if (user!=null) System.out.println("UNIVERSAL DAO DAO READ " + user);

        if (doUser.delete(user)) System.out.println("UNIVERSAL DAO DELETE " + user);



//------------------------ TOURS ------------------------------------------------------
        Tour tour = new Tour(0, "TestTour", 3, 2, 3, 1,
                400000, "10.03.2019", 10, 0, 0);

        if (dao.tour.create(tour)) System.out.println("Create ok " + tour);
        tour.setName("TestTourUpdate");

        if (dao.tour.update(tour)) System.out.println("update ok " + tour);

        tour = dao.tour.read(tour.getId());

        if (tour!=null) System.out.println("read ok " + tour);

        if (dao.tour.delete(tour)) System.out.println("delete ok " + tour);

//----------------------  USERS - TOURS ----------------------------------------------

        TourUser tourUser = new TourUser(0, 1, 1);

        if (dao.tourUser.create(tourUser)) System.out.println("Create ok " + tourUser);
        tourUser.setTours_id(2);

        if (dao.tourUser.update(tourUser)) System.out.println("update ok " + tourUser);

        tourUser = dao.tourUser.read(tourUser.getId());

        if (tourUser!=null) System.out.println("read ok " + tourUser);

        if (dao.tourUser.delete(tourUser)) System.out.println("delete ok " + tourUser);

//-------------------- READ ROLES -----------------------------------------------------

        List<Role> roles = dao.role.getAll();

        for (Role el :
                roles) {
            System.out.println(el);
        }
//-------------------- READ TRANSPORT --------------------------------------------------

        List<Transport> transports = dao.transport.getAll();

        for (Transport el :
                transports) {
            System.out.println(el);
        }


    }
}
