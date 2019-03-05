package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdEditRace implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            long race_id = Form.getLong(req, "race_id");
            Dao dao = Dao.getDao();
            String where = String.format("WHERE `id`='%d'", race_id);
            List<Race> races = dao.race.getAll(where);
            if (races.size() > 0) {
                Race race = races.get(0);
                req.setAttribute("race", race);
            }
            return Action.EDITRACE;
        }
        return Action.ERROR;
    }
}
