package by.it.zagurskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    public void init(Connection connection) throws SQLException {
//        boolean b = true;
//        if (b) {
//            throw new SQLException("hello");
//        }
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zagurskaya` ;");
            statement.executeUpdate(
                    "CREATE SCHEMA IF NOT EXISTS `zagurskaya` " +
                            "DEFAULT CHARACTER SET utf8 ;"
            );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`roles` (" +
                    "  `idRole` INT NOT NULL AUTO_INCREMENT," +
                    "  `roleName` VARCHAR(50) NULL," +
                    "  PRIMARY KEY (`idRole`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`users` (" +
                    "  `idUser` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(50) NULL," +
                    "  `password` VARCHAR(50) NULL," +
                    "  `roleId` INT NOT NULL DEFAULT 2," +
                    "  PRIMARY KEY (`idUser`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roleId` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roleId`)" +
                    "    REFERENCES `zagurskaya`.`roles` (`idRole`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`currencys` (" +
                    "  `idCurrency` INT NOT NULL," +
                    "  `iso` VARCHAR(45) NULL," +
                    "  `nameCurrency` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`idCurrency`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`accaunts` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `accaunt` INT NULL," +
                    "  `accauntSub` INT NULL," +
                    "  `fullAccount` VARCHAR(28) NULL," +
                    "  `currency` INT NULL,\n" +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_accaunts_currencys1_idx` (`currency` ASC)," +
                    "  CONSTRAINT `fk_accaunts_currencys1`" +
                    "    FOREIGN KEY (`currency`)" +
                    "    REFERENCES `zagurskaya`.`currencys` (`idCurrency`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`rateNB` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `rateSum` DOUBLE NULL," +
                    "  `rateDate` DATE NULL," +
                    "  `currency_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_rateNB_currencys1_idx` (`currency_id` ASC)," +
                    "  CONSTRAINT `fk_rateNB_currencys1`" +
                    "    FOREIGN KEY (`currency_id`)" +
                    "    REFERENCES `zagurskaya`.`currencys` (`idCurrency`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`rateCB` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `rateSum` DOUBLE NULL," +
                    "  `isBack` TINYINT(1) NULL," +
                    "  `dateRate` DATE NULL," +
                    "  `currencyComing` INT NOT NULL," +
                    "  `currencSpending` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_rateCB_currencys1_idx` (`currencyComing` ASC)," +
                    "  INDEX `fk_rateCB_currencys2_idx` (`currencSpending` ASC)," +
                    "  CONSTRAINT `fk_rateCB_currencys1`" +
                    "    FOREIGN KEY (`currencyComing`)" +
                    "    REFERENCES `zagurskaya`.`currencys` (`idCurrency`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT `fk_rateCB_currencys2`" +
                    "    FOREIGN KEY (`currencSpending`)" +
                    "    REFERENCES `zagurskaya`.`currencys` (`idCurrency`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`sprEntrys` (" +
                    "  `idEntry` INT NOT NULL," +
                    "  `nameEntry` VARCHAR(100) NULL," +
                    "  `currencyEntry` INT NULL," +
                    "  `accauntDebitEntry` VARCHAR(28) NULL," +
                    "  `accauntKreditEntry` VARCHAR(28) NULL," +
                    "  `sumEntry` DOUBLE NULL," +
                    "  `isSpeting` TINYINT(1) NULL," +
                    "  `rateEntry` DOUBLE NULL," +
                    "  PRIMARY KEY (`idEntry`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`sprOperations` (" +
                    "  `idOperation` INT NOT NULL," +
                    "  `nameOperation` VARCHAR(100) NULL," +
                    "  `printForm` VARCHAR(45) NULL," +
                    "  `skreanForm` VARCHAR(45) NULL," +
                    "  `specification` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`idOperation`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`operation_has_entrys` (" +
                    "  `operation_idOperation` INT NOT NULL," +
                    "  `entry_idEntry` INT NOT NULL," +
                    "  INDEX `fk_operation_has_entrys_entrys1_idx` (`entry_idEntry` ASC)," +
                    "  INDEX `fk_operation_has_entrys_operation1_idx` (`operation_idOperation` ASC)," +
                    "  CONSTRAINT `fk_operation_has_entrys_operation1`" +
                    "    FOREIGN KEY (`operation_idOperation`)" +
                    "    REFERENCES `zagurskaya`.`sprOperations` (`idOperation`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT `fk_operation_has_entrys_entrys1`" +
                    "    FOREIGN KEY (`entry_idEntry`)" +
                    "    REFERENCES `zagurskaya`.`sprEntrys` (`idEntry`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`usersOperations` (" +
                    "  `idUserOperation` INT NOT NULL AUTO_INCREMENT," +
                    "  `dateOperation` DATE NOT NULL," +
                    "  `rateEntry` DOUBLE NOT NULL," +
                    "  `sumEntry` DOUBLE NOT NULL," +
                    "  `currencyOperation` INT NOT NULL," +
                    "  `numberUser` INT NOT NULL," +
                    "  `numberOperation` INT NOT NULL," +
                    "  `specification` VARCHAR(100) NULL," +
                    "  `checkingAccount` VARCHAR(28) NULL," +
                    "  PRIMARY KEY (`idUserOperation`)," +
                    "  INDEX `fk_users_has_operations_users1_idx` (`numberUser` ASC)," +
                    "  CONSTRAINT `fk_users_has_operations_users1`" +
                    "    FOREIGN KEY (`numberUser`)" +
                    "    REFERENCES `zagurskaya`.`users` (`idUser`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`duties` (" +
                    "  `idduties` INT NOT NULL AUTO_INCREMENT," +
                    "  `numberUser` INT NOT NULL," +
                    "  `dateDuties` DATE NULL," +
                    "  `numberDuties` INT NULL," +
                    "  `isClose` TINYINT(1) NULL," +
                    "  PRIMARY KEY (`idduties`)," +
                    "  INDEX `fk_duties_users1_idx` (`numberUser` ASC)," +
                    "  CONSTRAINT `fk_duties_users1`" +
                    "    FOREIGN KEY (`numberUser`)" +
                    "    REFERENCES `zagurskaya`.`users` (`idUser`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`kassa` (" +
                    "  `idCurrency` INT NULL," +
                    "  `receivedCurrency` DOUBLE NULL," +
                    "  `comingCurrency` DOUBLE NULL," +
                    "  `spendingCurrency` DOUBLE NULL," +
                    "  `hendedCurrency` DOUBLE NULL," +
                    "  `balanceCarrency` DOUBLE NULL," +
                    "  `numberUser` INT NOT NULL," +
                    "  `date` DATE NULL," +
                    "  `duties` INT NULL," +
                    "  INDEX `fk_kassa_users1_idx` (`numberUser` ASC)," +
                    "  CONSTRAINT `fk_kassa_users1`" +
                    "    FOREIGN KEY (`numberUser`)" +
                    "    REFERENCES `zagurskaya`.`users` (`idUser`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zagurskaya`.`usersEntrys` (" +
                    "  `idusersEntrys` INT NOT NULL AUTO_INCREMENT," +
                    "  `numberUserOperation` INT NOT NULL," +
                    "  `numberEntry` INT NOT NULL," +
                    "  `currencyEntry` INT NOT NULL," +
                    "  `accauntDebitEntry` VARCHAR(28) NOT NULL," +
                    "  `accauntKreditEntry` VARCHAR(28) NOT NULL," +
                    "  `sumEntry` DOUBLE NOT NULL," +
                    "  `isSpeting` TINYINT(1) NOT NULL," +
                    "  `rateEntry` DOUBLE NOT NULL," +
                    "  PRIMARY KEY (`idusersEntrys`)," +
                    "  INDEX `fk_usersEntrys_usersOperations1_idx` (`numberUserOperation` ASC)," +
                    "  CONSTRAINT `fk_usersEntrys_usersOperations1`" +
                    "    FOREIGN KEY (`numberUserOperation`)" +
                    "    REFERENCES `zagurskaya`.`usersOperations` (`idUserOperation`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`roles` (`idRole`, `roleName`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`roles` (`idRole`, `roleName`) VALUES (DEFAULT, 'kassir');");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`users` (`idUser`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Admin', 'Admin', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`users` (`idUser`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Ivanova', 'Ivanova', 2);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`users` (`idUser`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Petrova', 'Petrova', 2);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`currencys` (`idCurrency`, `iso`, `nameCurrency`) VALUES (840, 'USD', 'Долоры США');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`currencys` (`idCurrency`, `iso`, `nameCurrency`) VALUES (933, 'BUR', 'Белорусский рубль');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`currencys` (`idCurrency`, `iso`, `nameCurrency`) VALUES (978, 'EUR', 'Евро');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`currencys` (`idCurrency`, `iso`, `nameCurrency`) VALUES (643, 'RUR', 'Российский рубль');");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 1010, 933, '1010000000933', 933);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 1010, 840, '1010000000840', 840);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 1010, 978, '1010000000978', 978);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 6901, 840, '6901000000840', 840);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 6901, 978, '6901000000978', 978);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 6901, 643, '6901000000643', 643);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 6911, 933, '6911000000933', 933);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`accaunts` (`id`, `accaunt`, `accauntSub`, `fullAccount`, `currency`) VALUES (DEFAULT, 3819, 998, '3819000000000', 933);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateNB` (`id`, `rateSum`, `rateDate`, `currency_id`) VALUES (DEFAULT, 2.16, '2018-02-01', 840);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateNB` (`id`, `rateSum`, `rateDate`, `currency_id`) VALUES (DEFAULT, 2.44, '2018-02-01', 978);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateNB` (`id`, `rateSum`, `rateDate`, `currency_id`) VALUES (DEFAULT, 0.0324, '2018-02-01', 643);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateNB` (`id`, `rateSum`, `rateDate`, `currency_id`) VALUES (DEFAULT, 1, '2018-02-01', 933);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 2.17, 1, '2018-02-01', 933, 840);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 2.43, 0, '2018-02-01', 978, 933);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 2.45, 1, '2018-02-01', 933, 978);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 0.0321, 0, '2018-02-01', 643, 933);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 0.0328, 1, '2018-02-01', 933, 643);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`rateCB` (`id`, `rateSum`, `isBack`, `dateRate`, `currencyComing`, `currencSpending`) VALUES (DEFAULT, 2.15, 0, '2018-02-01', 840, 933);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (100003, 'Получено валюты', 643, '', '1010000000643', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (100004, 'Получено валюты', 933, '', '1010000000933', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1001, 'Покупка валюты(840)', 840, '1010000000840', '6901000000840', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1002, 'Рублевый эквивалент(840)', 933, '6911000000840', '1010000000933', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1003, 'Покупка валюты(978)', 978, '1010000000978', '6901000000978', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1004, 'Рублевый эквивалент(978)', 933, '6911000000978', '1010000000933', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1005, 'Покупка валюты(643)', 643, '1010000000643', '6901000000643', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (1006, 'Рублевый эквивалент(643)', 933, '6911000000643', '1010000000933', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2001, 'Продажа валюты(840)', 840, '6901000000840', '1010000000840', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2002, 'Рублевый эквивалент(840)', 933, '1010000000840', '6911000000840', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2003, 'Продажа валюты(978)', 978, '6901000000978', '1010000000978', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2004, 'Рублевый эквивалент(978)', 933, '1010000000978', '6911000000978', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2005, 'Продажа валюты(643)', 643, '690100000063', '1010000000643', NULL, 1, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (2006, 'Рублевый эквивалент(643)', 933, '1010000000643', '6911000000643', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (99801, 'Приход денежных средст в кассу', 933, '1010000000933', '3819000000000', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (100001, 'Получено валюты', 840, '', '1010000000840', NULL, 0, NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprEntrys` (`idEntry`, `nameEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (100002, 'Получено валюты', 978, '', '1010000000978', NULL, 0, NULL);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprOperations` (`idOperation`, `nameOperation`, `printForm`, `skreanForm`, `specification`) VALUES (1000, 'Подкрепление', 'order1000', 'prix', '');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprOperations` (`idOperation`, `nameOperation`, `printForm`, `skreanForm`, `specification`) VALUES (10, 'Покупка валюты', 'print10', 'skrean10', '');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprOperations` (`idOperation`, `nameOperation`, `printForm`, `skreanForm`, `specification`) VALUES (20, 'Продажа валюты', 'print20', 'skrean20', '');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprOperations` (`idOperation`, `nameOperation`, `printForm`, `skreanForm`, `specification`) VALUES (998, 'Коммунальный платеж', 'print998', 'skrean998', NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`sprOperations` (`idOperation`, `nameOperation`, `printForm`, `skreanForm`, `specification`) VALUES (1100, 'Инкассация', 'order1100', 'rasx', NULL);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (1000, 100001);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (1000, 100002);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (1000, 100003);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (1000, 100004);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1001);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1002);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1003);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1004);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1005);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (10, 1006);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2001);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2002);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2003);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2004);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2005);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (20, 2006);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`operation_has_entrys` (`operation_idOperation`, `entry_idEntry`) VALUES (998, 99801);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 2.1, 100, 840, 2, 10, 'В личное пользование', NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 1, 56, 933, 2, 998, 'За питание в СД№3', '3012000000005');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 2.1, 1000, 840, 3, 1000, 'Получены денежные средства', NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 2.15, 200, 840, 3, 20, 'В личное пользование', NULL);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 1, 20, 933, 3, 998, 'За мобильный телефор', '3012000000023');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersOperations` (`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`) VALUES (DEFAULT, '2018-02-01', 2.1, 1000, 840, 2, 1000, 'Получены денежные средства', NULL);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`duties` (`idduties`, `numberUser`, `dateDuties`, `numberDuties`, `isClose`) VALUES (DEFAULT, 2, '2018-02-01', 1, 0);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`duties` (`idduties`, `numberUser`, `dateDuties`, `numberDuties`, `isClose`) VALUES (DEFAULT, 3, '2018-02-01', 1, 0);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (643, 0, 0, 0, 0, 0, 2, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (840, 1000, 100, 0, 0, 1100, 2, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (978, 0, 0, 0, 0, 0, 2, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (933, 1000, 100, 210, 0, 690, 2, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (643, 0, 0, 0, 0, 0, 3, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (840, 1000, 0, 200, 0, 800, 3, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (978, 0, 0, 0, 0, 0, 3, '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (933, 1000, 450, 0, 0, 1450, 3, '2018-02-01', 1);");

            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 1, 100001, 840, '', '1010000000840', 1000, 0, 2.1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 1, 100004, 933, '', '1010000000933', 1000, 0, 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 2, 1001, 840, '1010000000840', '6901000000840', 100, 0, 2.1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 2, 1002, 933, '6911000000840', '1010000000933', 210, 1, 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 3, 99801, 933, '1010000000933', '3819000000000', 56, 0, 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 4, 10001, 840, '', '1010000000840', 1000, 0, 2.1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 4, 10004, 933, '', '1010000000933', 1000, 0, 2.1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 5, 2001, 840, '6901000000840', '1010000000840', 200, 1, 2.15);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 5, 2001, 933, '1010000000840', '6911000000840', 430, 0, 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`usersEntrys` (`idusersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`) VALUES (DEFAULT, 6, 99801, 933, '1010000000933', '3819000000000', 20, 0, 1);");


        }
    }

}
