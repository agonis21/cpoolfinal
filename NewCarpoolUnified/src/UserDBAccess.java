import java.sql.*;

public class UserDBAccess {
    private static Connection conn;

    public static void init() throws ClassNotFoundException {

        DBConnection.init("carpool");
    }


    public static Boolean usernameTaken(String username) throws SQLException{

        conn = DBConnection.getMyConnection();
        String query = ("SELECT userID FROM user WHERE username = ?;");
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (rs.next() == false){
            return false;
        }
        else return true;
    }

    public static Boolean insert(DummyUser user) throws SQLException{

        conn = DBConnection.getMyConnection();

        String query = "INSERT INTO user (username, password, firstName, lastName, created) VALUES(?, ?, ?, ?, current_timestamp());";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getFname());
        stmt.setString(4,user.getLname());

        int result = stmt.executeUpdate();
        if(result ==0)
        {
            return false;
        }
        else
            return true;

    }

    public static Boolean updateDonorStatus(Boolean status, int userID) throws SQLException{

        conn = DBConnection.getMyConnection();
        String query = "UPDATE user SET isDonor = ? WHERE userId =?;";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setBoolean(1,status);
        stmt.setInt(2,userID);

        int result = stmt.executeUpdate();
        if(result ==0)
        {
            return false;
        }
        else
            return true;

    }

    public static DummyUser checkCredentials(String username, String password) throws SQLException{

        conn= DBConnection.getMyConnection();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1,username);
        stmt.setString(2,password);

        ResultSet rs = stmt.executeQuery();
        DummyUser user = buildUser(rs);
        return user;
    }











    private static DummyUser buildUser(ResultSet rs) throws SQLException{
        if(rs.next()) {
            int userId = rs.getInt("userID");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            Boolean isDonor = rs.getBoolean("isDonor");
            Boolean hasDonation = rs.getBoolean("hasActiveDonation");
            Timestamp timestamp = rs.getTimestamp("created");
            DummyUser user = new DummyUser(userId,username,password,fname,lname,isDonor,hasDonation,timestamp);
            return user;
        }
        else return null;



    }

}
