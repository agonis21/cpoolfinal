

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Creates and returns a database connection
 *
 */
public class DBConnection {
    private static Connection conn=null;
    private static String dbString = "jdbc:mysql://localhost:3306/";
    private static String userName = "root";
    private static String password = "CUS725";
    public static String winflag = "?useSSL=false";
    public static String dbname;

    /**
     * initialize with the name of the database
     * the rest of the connection information is hardcoded
     * @param dbn database name
     * @throws ClassNotFoundException
     */
    public static void init(String dbn) throws ClassNotFoundException{
        dbname = dbn;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * return a database connection
     * @return
     * @throws SQLException if the connection cannot be created
     */
    public static Connection getMyConnection() throws SQLException{
        if (conn == null) {
            String fullDBString = dbString  + dbname + winflag;
            conn= DriverManager.getConnection(fullDBString,userName, password);
        }
        return conn;
    }


}
