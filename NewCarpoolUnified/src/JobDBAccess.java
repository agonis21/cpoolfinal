
import java.sql.*;
import java.time.LocalDateTime;

//NOT FINISHED, ISSUE WITH CONVERSION FROM DATETIME TO LOCALDATETIME
//AS WELL AS TIMESTAMP
public class JobDBAccess {

    private static Connection conn;

    public static void init() throws ClassNotFoundException {

        DBConnection.init("carpool");
    }

    public static Boolean insert(Job job) throws SQLException {

        conn = DBConnection.getMyConnection();

        String query = "INSERT INTO job(userID,jobId,jobType,jobDeadline,duration, created) VALUES(?,?,?,?,?, current_timestamp());";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, job.getUserId());
        stmt.setInt(2, job.getJobId());
        stmt.setString(3, job.getJobType());
        stmt.setString(4, job.getJobDeadline());
        stmt.setString(5, job.getJobDuration());
        //stmt.setString(7, job.getJobCompletionTime());  // needs to be added and fixed


        int result = stmt.executeUpdate();
        if(result ==0)
        {
            return false;
        }
        else {
            return true;
        }


    }


    private static Job buildJob(ResultSet rs)throws SQLException{
        if(rs.next()){
           int jobId = rs.getInt("jobID");
            int userID = rs.getInt("userID");
            String jobType = rs.getString("jobType");
            String jobDeadline = rs.getString("Deadline");
            String jobDuration = rs.getString("Duration");
            Timestamp timestamp = rs.getTimestamp("created");
            Job job = new Job(jobId,userID, jobType,jobDeadline,jobDuration,timestamp); // add completiontime
            return job;

        }
        else return null;
    }





}
