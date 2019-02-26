package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdGetRaces implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Race> races = dao.race.getAll();
        StringBuilder table = Utils.getRacesTable(races);
        req.setAttribute("races", table.toString());
        return Action.GETRACES;
    }
}
