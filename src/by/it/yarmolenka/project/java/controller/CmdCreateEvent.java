package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdCreateEvent implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            Event event = new Event();
            event.setDescription(Form.getString(req, "description", Patterns.TEXT));
            double odds = Form.getDouble(req, "odds");
            if (odds < 0) return Action.GETEVENTS;
            event.setOdds(odds);
            long fk_roles = Form.getLong(req, "selectrace");
            event.setFk_races(fk_roles);
            Dao dao = Dao.getDao();
            if (event.getFk_races() > 0)
                dao.event.create(event);
            return Action.INDEX;
        }
        Dao dao = Dao.getDao();
        List<Race> races = dao.race.getAll();
        req.setAttribute("racesChoise", Utils.getRacesChoise(races));
        return Action.CREATEEVENT;
    }
}
