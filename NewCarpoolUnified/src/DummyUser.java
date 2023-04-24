import java.io.Serializable;
import java.sql.Timestamp;

public class DummyUser implements Serializable {

    public int userID;
    public String username;
    public String password;
    public String fname;
    public String lname;
    public Boolean isDonor;
    public Vehicle vehicle;
    public Job job;
    boolean hasActiveDonation;
    Timestamp created;


    //this constructor will be used to generate DummyUser objects from queries
    public DummyUser(int userID, String username, String password, String fname, String lname, boolean isDonor, boolean hasActiveDonation, Timestamp timestamp)
    {
        this.userID=userID;
        this.username=username;
        this.password= password;
        this.fname=fname;
        this.lname=lname;
        this.isDonor = isDonor;
        this.hasActiveDonation=hasActiveDonation;
        this.created = timestamp;
    }
    public DummyUser(String username, String password, String fname, String lname)
    {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;



    }

    public DummyUser(String username, String password)
    {
    this.username = username;
    this.password = password;

    this.fname = "Dummy";
    this.lname = "User";
    this.isDonor = false;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Boolean getIsDonor()
    {
        return this.isDonor;
    }
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }
    public String getFname(){ return this.fname;}
    public String getLname(){return this.lname;}

    public Job getJob()
    {
        return this.job;
    }

    public int getUserID(){return this.userID;}


    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.isDonor = true;
    }

    public void setJob(Job job)
    {
        this.job = job;
        this.isDonor = false;
    }

    public void setActive(Boolean status)
    {
        this.hasActiveDonation = status;
    }

    public void setIsDonor(Boolean status)
    {
        this.isDonor = status;
    }

}
