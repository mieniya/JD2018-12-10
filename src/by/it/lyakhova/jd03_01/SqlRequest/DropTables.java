package by.it.lyakhova.jd03_01.SqlRequest;

public interface DropTables {

    String DROP_SCHEMA = "DROP SCHEMA IF EXISTS `lyakhova` ;";

    String DELETE_ROLES = "DROP TABLE IF EXISTS `lyakhova`.`roles` ;";

    String DELETE_USERS = "DROP TABLE IF EXISTS `lyakhova`.`users` ;";

    String DELETE_PLACE = "DROP TABLE IF EXISTS `lyakhova`.`place` ;";

    String DELETE_TRANSPORT = "DROP TABLE IF EXISTS `lyakhova`.`transport` ;";

    String DELETE_HOUSING = "DROP TABLE IF EXISTS `lyakhova`.`housing` ;";

    String DELETE_TOURS = "DROP TABLE IF EXISTS `lyakhova`.`tours` ;";

    String DELETE_TOURS_USERS = "DROP TABLE IF EXISTS `lyakhova`.`tours_has_users` ;";

}
