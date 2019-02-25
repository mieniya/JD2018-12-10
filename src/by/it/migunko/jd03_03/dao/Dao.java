package by.it.migunko.jd03_03.dao;

public class Dao {
    private volatile static Dao dao;

    private Dao(){
        role = new RoleDao();
        user = new UserDao();
        tour = new TourDao();
    }

    public RoleDao role;
    public UserDao user;
    public TourDao tour;

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
