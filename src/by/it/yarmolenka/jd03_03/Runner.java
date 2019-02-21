package by.it.yarmolenka.jd03_03;

import by.it.yarmolenka.jd03_03.beans.*;
import by.it.yarmolenka.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        //test RolesDao
        List<Role> roles = dao.role.getAll();
        System.out.println("Roles: " + roles);
        Role admin2 = new Role(0, "admin2");
        if (dao.role.create(admin2)) System.out.println("Role created: " + admin2);
        admin2 = dao.role.read(admin2.getId());
        System.out.println("Role read: " + admin2);
        admin2.setRole("updatedAdmin");
        if (dao.role.update(admin2)) System.out.println("Role updated: " + admin2);
        if (dao.role.delete(admin2)) System.out.println("Role deleted: " + admin2);

        //test UsersDao
        List<User> users = dao.user.getAll();
        System.out.println("\n\nUsers: " + users);
        User user = new User(0, "user-login",
                "user-email","user-pass", 0, 1);
        if (dao.user.create(user)) System.out.println("User created: " + user);
        user = dao.user.read(user.getId());
        System.out.println("User read: " + user);
        user.setCashier(500);
        if (dao.user.update(user)) System.out.println("User updated: " + user);
        if (dao.user.delete(user)) System.out.println("User deleted: " + user);

        //test RacesDao
        List<Race> races = dao.race.getAll();
        System.out.println("\n\nRaces: " + races);
        Timestamp time = Timestamp.valueOf("2019-03-03 19:00:00");
        Race race = new Race(0, time, "track1", "big-race");
        if (dao.race.create(race)) System.out.println("Race created: " + race);
        race = dao.race.read(race.getId());
        System.out.println("Race read: " + race);
        race.setDescription("other race");
        if (dao.race.update(race)) System.out.println("Race updated: " + race);
        if (dao.race.delete(race)) System.out.println("Race deleted: " + race);

        //test EventsDao
        List<Event> events = dao.event.getAll();
        System.out.println("\n\nEvents: " + events);
        Event event = new Event(0, "w1", 2.7, 1);
        if (dao.event.create(event)) System.out.println("Event created: " + event);
        event = dao.event.read(event.getId());
        System.out.println("Event read: " + event);
        event.setDescription("other descr");
        if (dao.event.update(event)) System.out.println("Event updated: " + event);
        if (dao.event.delete(event)) System.out.println("Event deleted: " + event);

        //test BetsDao
        List<Bet> bets = dao.bet.getAll();
        System.out.println("\n\nBets: " + bets);
        Bet bet = new Bet(0, 100, 0, 2, 2);
        if (dao.bet.create(bet)) System.out.println("Bet created: " + bet);
        bet = dao.bet.read(bet.getId());
        System.out.println("Bet read: " + bet);
        bet.setPayout(270);
        if (dao.bet.update(bet)) System.out.println("Bet updated: " + bet);
        if (dao.bet.delete(bet)) System.out.println("Bet deleted: " + bet);
    }
}
