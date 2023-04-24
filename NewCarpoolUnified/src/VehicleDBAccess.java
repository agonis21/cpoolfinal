import java.sql.*;

public class VehicleDBAccess {

    private static Connection conn;

    public static void init() throws ClassNotFoundException {

        DBConnection.init("carpool");
    }

    public static Boolean insert(Vehicle vehicle) throws SQLException{

        conn = DBConnection.getMyConnection();

        String query = "INSERT INTO vehicle(plateNumber,stateRegistered,year,make,model,created,userID) VALUES(?,?,?,?,?,current_timestamp(), ?);";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1, vehicle.getPlateNumber());
        stmt.setString(2, vehicle.getStateRegistered());
        stmt.setInt(3, vehicle.getYear());
        stmt.setString(4,vehicle.getMake());
        stmt.setString(5,vehicle.getModel());
        stmt.setInt(6,vehicle.getUserId());

        int result = stmt.executeUpdate();
        if(result ==0)
        {
            return false;
        }
        else {
            UserDBAccess.updateDonorStatus(true, vehicle.getUserId());
            return true;
        }


    }



    private static Vehicle buildVehicle(ResultSet rs)throws SQLException{
        if(rs.next()){
            String plateNumber = rs.getString("plateNumber");
            String stateRegistered = rs.getString("stateRegistered");
            int year = rs.getInt("year");
            String make = rs.getString("make");
            String model = rs.getString("model");
            Timestamp timestamp = rs.getTimestamp("created");
            int userID = rs.getInt("userID");
            int vehicleId= rs.getInt("vehicleId");
            Vehicle vehicle = new Vehicle(vehicleId,userID,make,model,year,plateNumber,stateRegistered);
            return vehicle;
        }
        else return null;
    }


}
