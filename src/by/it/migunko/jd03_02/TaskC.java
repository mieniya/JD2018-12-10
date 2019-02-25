package by.it.migunko.jd03_02;
import by.it.migunko.jd03_02.beans.Roles;
import by.it.migunko.jd03_02.beans.Tours;
import by.it.migunko.jd03_02.beans.Users;
public class TaskC {
    public static void main(String[] args) {
        Roles testRoles = new Roles(
                0,
                "Administrator");
        Users testUser = new Users(
                0,
                "migunko",
                "jakjla",
                "migunko@gmail.com",
                3);
        Tours testTours = new Tours(
                0,
                "пляжный отдых",
                "Holiday",
                "Анталия",
                "Dogan Hotek",
                7,
                1000.0,
                3);


        System.out.println(testUser);

    }
}
