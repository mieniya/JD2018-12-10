package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        Dao.getDao().resetDatabase();
        return Action.INDEX;
    }
}
