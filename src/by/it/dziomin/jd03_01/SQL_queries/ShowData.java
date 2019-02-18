package by.it.dziomin.jd03_01.SQL_queries;

public interface ShowData {
    String SHOW_USERS = "SELECT users.name, roles.role FROM dziomin.users, dziomin.roles  WHERE roles.id=users.roles_id";
}
