package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.*;
import by.it.yarmolenka.jd03_02.crud.*;

import java.sql.SQLException;
import java.sql.Timestamp;

public class CrudTester {
    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role admin = new Role(0, "admin");
        if (roleCRUD.create(admin)) System.out.println("Role created OK: " + admin);
        Role readRole = roleCRUD.read(admin.getId());
        System.out.println("Role read: " + readRole);
        readRole.setRole("new admin");
        if (roleCRUD.update(readRole)) System.out.println("Role updated OK: " + readRole);
        if (roleCRUD.delete(readRole)) System.out.println("Role deleted: " + readRole);


        UserCRUD userCRUD = new UserCRUD();
        User administrator = new User(0, "adm", "adm@mail.ru", "pass", 0, 1);
        if (userCRUD.create(administrator)) System.out.println("User created: " + administrator);
        User readUser = userCRUD.read(administrator.getId());
        System.out.println("User read: " + readUser);
        readUser.setLogin("adminis");
        if (userCRUD.update(readUser)) System.out.println("User updated: " + readUser);
        if (userCRUD.delete(readUser)) System.out.println("User deleted: " + readUser);


        RaceCRUD raceCRUD = new RaceCRUD();
        Timestamp time = Timestamp.valueOf("2019-03-03 19:00:00");
        Race race = new Race(0, time, "track", "race");
        if (raceCRUD.create(race)) System.out.println("Race created: " + race);
        Race readRace = raceCRUD.read(race.getId());
        System.out.println("Race read: " + readRace);
        Timestamp time2 = Timestamp.valueOf("2019-03-02 19:00:00");
        readRace.setDate(time2);
        if (raceCRUD.update(readRace)) System.out.println("Race updated: " + readRace);
        if (raceCRUD.delete(readRace)) System.out.println("Race deleted " + readRace);


        EventCRUD eventCRUD = new EventCRUD();
        Event w1 = new Event(0, "1 horse win", 5.2, 1);
        if (eventCRUD.create(w1)) System.out.println("Event created: " + w1);
        Event w2 = eventCRUD.read(w1.getId());
        System.out.println("Event read: " + w2);
        w2.setOdds(7.2);
        if (eventCRUD.update(w2)) System.out.println("Event updated: " + w2);
        if (eventCRUD.delete(w2)) System.out.println("Event deleted: " + w2);


        BetCRUD betCRUD = new BetCRUD();
        Bet bet = new Bet(0, 100, 0, 1, 1);
        if (betCRUD.create(bet)) System.out.println("Bet created: " + bet);
        Bet bet2 = betCRUD.read(bet.getId());
        System.out.println("Bet read: " + bet2);
        bet2.setPayout(200);
        if (betCRUD.update(bet)) System.out.println("Bet updated: " + bet2);
        if (betCRUD.delete(bet2)) System.out.println("Bet deleted: " + bet2);
    }
}
