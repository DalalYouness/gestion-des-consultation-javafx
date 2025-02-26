package ma.enset.gestion_consultations.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcoonectionSettings {
    private static Connection connection;

    // on a utliser le design pattern Singleton
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cabinet", "root", "");
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }
}
