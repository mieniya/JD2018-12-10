package by.it.subach.jd03_03.dao;

public class DAO {

    private volatile static  DAO instance;

    public RoleDao role;
    public UserDao user;
    public CategoryDao category;


    private DAO() {
        role = new RoleDao();
        user = new UserDao();
        category = new CategoryDao();
    }

    public static DAO getInstance(){
        if(instance == null){
            synchronized (DAO.class){
                if(instance == null){
                    instance = new DAO();
//                    user = new UserDao();
//                    role = new RoleDao();
//                    category = new CategoryDao();

                }
            }
        }
        return instance;
    }
}
