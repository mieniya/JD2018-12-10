package by.it.lyakhova.jd03_01.SqlRequest;

public interface AddData {

    String ADD_ROLES_1 = "INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'administrator', 'all rights');";
    String ADD_ROLES_2 = "INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'editor', 'edit information');";
    String ADD_ROLES_3 =  "INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'user', 'read, wright');";
    String ADD_ROLES_4 = "INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'guess', 'watch');";

    String ADD_USERS_1 = "INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'petrov', 'petrov', 'petrov@mail.ru', 'petrov@mail.ru', 3);";
    String ADD_USERS_2 = "INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'sidorov', 'sidorov', 'sidorov@mail.ru', 'sidorov@mail.ru', 2);";
    String ADD_USERS_3 = "INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'agadjanov', 'agadjanov', 'agadjanov@gmail.com', 'agadjanov@gmail.com', 1);";


    String ADD_PLACE_1 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Vietnam', 'Hanoi');";
    String ADD_PLACE_2 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Sri Lanka', 'Kolombo');";
    String ADD_PLACE_3 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Malaysia', 'Kuala Lumpur');";
    String ADD_PLACE_4 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Russia', 'Moscow');";
    String ADD_PLACE_5 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Poland', 'Warszawa');";
    String ADD_PLACE_6 = "INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Latvia', 'Riga');";

    String ADD_TRANSPORT_1 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'aircraft');";
    String ADD_TRANSPORT_2 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'bus');";
    String ADD_TRANSPORT_3 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'car');";
    String ADD_TRANSPORT_4 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'train');";
    String ADD_TRANSPORT_5 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'boat');";
    String ADD_TRANSPORT_6 = "INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'cruise');";

    String ADD_HOUSING_1 = "INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, NULL);";
    String ADD_HOUSING_2 = "INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'hotel');";
    String ADD_HOUSING_3 = "INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'apartment');";
    String ADD_HOUSING_4 = "INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'house');";

    String ADD_TOURS_1 = "INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 1', '3', 1, 1, 1, 600, '21.12.2019', 10, NULL, NULL);";
    String ADD_TOURS_2 = "INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 2', '1', 6, 2, 3, 100, '03.03.2019', 2, NULL, NULL);";
    String ADD_TOURS_3 = "INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 3', '2', 2, 3, 2, 2000, '01.03.2019', 7, NULL, NULL);";

    String ADD_TOURS_USERS_1 = "INSERT INTO `lyakhova`.`tours_has_users` (`id`, `tours_id`, `users_id`) VALUES (DEFAULT, 1, 1);";
    String ADD_TOURS_USERS_2 = "INSERT INTO `lyakhova`.`tours_has_users` (`id`, `tours_id`, `users_id`) VALUES (DEFAULT, 1, 2);";
    String ADD_TOURS_USERS_3 = "INSERT INTO `lyakhova`.`tours_has_users` (`id`, `tours_id`, `users_id`) VALUES (DEFAULT, 3, 1);";

}
