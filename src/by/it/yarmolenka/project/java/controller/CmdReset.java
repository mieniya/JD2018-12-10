package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        Dao.getDao().resetDatabase();
        return Action.INDEX;
    }
}
