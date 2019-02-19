package by.it.moroz.jd03.jd03_02;

import com.mysql.jdbc.Connection;

public class ConnCreator {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private static volatile Connection connection;
    
    void getConnection(){
        
    }
}
