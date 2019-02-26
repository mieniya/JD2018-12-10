package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

class Utils {
    static StringBuilder getEventsTable(List<Event> events) throws SQLException {
        StringBuilder table = new StringBuilder();
        table.append("<table class=\"table\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">Id</th>\n" +
                "      <th scope=\"col\">Race</th>\n" +
                "      <th scope=\"col\">Description</th>\n" +
                "      <th scope=\"col\">Odds</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>");
        for (Event event : events) {
            long id = event.getId();
            String description = event.getDescription();
            double odds = event.getOdds();
            Dao dao = Dao.getDao();
            Race race = dao.race.read(event.getFk_races());
            String raceDescription = race.getDescription();
            table.append(String.format("<tr >\n" +
                    "      <th scope = \"row\" > %d </th >\n" +
                    "      <td > %s </td >\n" +
                    "      <td > %s </td >\n" +
                    "      <td > %.2f </td >\n" +
                    "    </tr >", id, raceDescription, description, odds));
        }
        table.append("</tbody >\n" +
                "</table >");
        return table;
    }

    static StringBuilder getRacesTable(List<Race> races) {
        StringBuilder table = new StringBuilder();
        table.append("<table class=\"table\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">Id</th>\n" +
                "      <th scope=\"col\">Date</th>\n" +
                "      <th scope=\"col\">Race track</th>\n" +
                "      <th scope=\"col\">Description</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>");
        for (Race race : races) {
            long id = race.getId();
            Timestamp date = race.getDate();
            String race_track = race.getRace_track();
            String raceDescription = race.getDescription();
            table.append(String.format("<tr >\n" +
                    "      <th scope = \"row\" > %d </th >\n" +
                    "      <td > %s </td >\n" +
                    "      <td > %s </td >\n" +
                    "      <td > %s </td >\n" +
                    "    </tr >", id, date.toString(), race_track, raceDescription));
        }
        table.append("</tbody >\n" +
                "</table >");
        return table;
    }

    static StringBuilder getRacesChoise(List<Race> races){
        StringBuilder res = new StringBuilder();
        int size = races.size();
        for (int i = 0; i < size; i++) {
            res.append(String.format("<option value=\"%d\">%s</option>\n", i, races.get(i).getDescription().trim()));
        }
        return res;
    }
}
