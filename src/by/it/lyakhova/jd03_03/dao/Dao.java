package by.it.lyakhova.jd03_03.dao;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public TourDao tour;
    public TourUserDao tourUser;
    public TourTypeDao tourType;
    public PlaceDao place;
    public TransportDao transport;
    public HousingDao housing;

    private Dao(){
        role = new RoleDao();
        user = new UserDao();
        tour = new TourDao();
        tourUser = new TourUserDao();
        tourType = new TourTypeDao();
        place = new PlaceDao();
        transport = new TransportDao();
        housing = new HousingDao();
    }

    public static Dao getDao(){
        if (dao==null){
            synchronized (Dao.class){
                if (dao==null){
                    dao = new Dao();
                }
            }
        }
        return dao;
    }


}
