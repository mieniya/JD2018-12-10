package by.it.skosirskiy.jd03_03;


import by.it.skosirskiy.jd03_03.beans.Role;
import by.it.skosirskiy.jd03_03.beans.User;
import by.it.skosirskiy.jd03_03.dao.Dao;
import by.it.skosirskiy.jd03_03.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    private static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDao().getAll("");
        for (User each:users) System.out.println(each);
    }
    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        Dao dao = Dao.getDao();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }

        showUsers();

        User user = new User(0,"Сергей Иванович", "siivanov", "siivanov@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>25").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
