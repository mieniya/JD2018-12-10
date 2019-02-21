package by.it.subach.jd03_03;

public class Dao {

    private Dao dao;

    public RoleDao role;
    public UserDao user;
    public AdDao ad;

    private Dao(){
        role = new RoleDao();
        user = new UserDao();
        ad = new AdDao();

    }

    public static Dao getDao(){

    }
}
