package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

public class CmdCreateRace implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")){
            String time = Form.getString(req, "time")
                    .replace('T', ' ')
                    .concat(":00");
            Dao dao = Dao.getDao();
            Timestamp timestamp = Timestamp.valueOf(time);
            Race newRace = new Race();
            newRace.setDate(timestamp);
            newRace.setDescription(Form.getString(req, "description", Patterns.TEXT));
            newRace.setRace_track(Form.getString(req, "racetrack", Patterns.TEXT));
            dao.race.create(newRace);
            return Action.INDEX;
        }

        return Action.CREATERACE;
    }
}
