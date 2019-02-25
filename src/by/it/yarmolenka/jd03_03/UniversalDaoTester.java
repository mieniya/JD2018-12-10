package by.it.yarmolenka.jd03_03;

import by.it.yarmolenka.jd03_03.beans.*;
import by.it.yarmolenka.jd03_03.dao.UniversalDao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class UniversalDaoTester {
    public static void main(String[] args) throws SQLException {
        
        // test UniversalDao with Role.class
        UniversalDao<Role> roleUniversalDao = new UniversalDao<>(Role.class);
        Role admin = new Role(0, "psssss");
        if (roleUniversalDao.create(admin)) System.out.println("Role created: " + admin);
        Role read = roleUniversalDao.read(admin.getId());
        System.out.println("Role read: " + read);
        admin.setRole("sssszzzzz");
        if (roleUniversalDao.update(admin)) System.out.println("Role updated: " + admin);
        if (roleUniversalDao.delete(admin)) System.out.println("Role deleted: " + admin);

        // test UniversalDao with User.class
        UniversalDao<User> userUniversalDao = new UniversalDao<>(User.class);
        User gamb = new User(0, "gambLogin", "gambEmail", "gambPass", 0, 2);
        if (userUniversalDao.create(gamb)) System.out.println("\n\nUser created: " + gamb);
        User readG = userUniversalDao.read(gamb.getId());
        System.out.println("User read: " + readG);
        gamb.setCashier(100);
        if (userUniversalDao.update(gamb)) System.out.println("User updated: " + gamb);
        if (userUniversalDao.delete(gamb)) System.out.println("User deleted: " + gamb);

        // test UniversalDao with Race.class
        UniversalDao<Race> raceUniversalDao = new UniversalDao<>(Race.class);
        Timestamp time = Timestamp.valueOf("2019-04-04 15:00:00");
        Race godRace = new Race(0, time, "track", "desc");
        if (raceUniversalDao.create(godRace)) System.out.println("\n\nRace created: " + godRace);
        Race readRace = raceUniversalDao.read(godRace.getId());
        System.out.println("Race read: " + readRace);
        godRace.setDescription("newDescription");
        if (raceUniversalDao.update(godRace)) System.out.println("Race updated: " + godRace);
        if (raceUniversalDao.delete(godRace)) System.out.println("Race deleted: " + godRace);

        // test UniversalDao with Event.class
        UniversalDao<Event> eventUniversalDao = new UniversalDao<>(Event.class);
        Event w1 = new Event(0, "w1", 2.4, 2);
        if (eventUniversalDao.create(w1)) System.out.println("\n\nEvent created: " + w1);
        Event readEvent = eventUniversalDao.read(w1.getId());
        System.out.println("Event read: " + readEvent);
        w1.setDescription("newDescriptionForEvent");
        if (eventUniversalDao.update(w1)) System.out.println("Event updated: " + w1);
        if (eventUniversalDao.delete(w1)) System.out.println("Event deleted: " + w1);

        // test UniversalDao with Bet.class
        UniversalDao<Bet> betUniversalDao = new UniversalDao<>(Bet.class);
        Bet goodBet = new Bet(0, 100, 0, 1, 2);
        if (betUniversalDao.create(goodBet)) System.out.println("\n\nBet created: " + goodBet);
        Bet readBet = betUniversalDao.read(goodBet.getId());
        System.out.println("Bet read: " + readBet);
        goodBet.setPayout(500);
        if (betUniversalDao.update(goodBet)) System.out.println("Bet updated: " + goodBet);
        if (betUniversalDao.delete(goodBet)) System.out.println("Bet deleted: " + goodBet);
    }
}
