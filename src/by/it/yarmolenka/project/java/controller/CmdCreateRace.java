package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

public class CmdCreateRace implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")){
            Timestamp timestamp = Utils.getDateTimestamp(req);
            Dao dao = Dao.getDao();
            Race newRace = new Race();
            newRace.setDate(timestamp);
            newRace.setDescription(Form.getString(req, "description", Patterns.TEXT));
            newRace.setRace_track(Form.getString(req, "racetrack", Patterns.TEXT));
            dao.race.create(newRace);
            return Action.CREATERACE;
        }
        return Action.CREATERACE;
    }
}
