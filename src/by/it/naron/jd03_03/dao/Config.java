package by.it.naron.jd03_03.dao;

public interface Config {
    //поля в интерфейсе автоматически становятся final public
    String URL = "jdbc:mysql://127.0.0.1:2016/"+
            "?useUnicode=true&characterEncoding=UTF-8";
    String DB_URL = "jdbc:mysql://127.0.0.1:2016/naron"+
            "?useUnicode=true&characterEncoding=UTF-8";
    String USER = "root";
    String PASSWORD = "";
}
