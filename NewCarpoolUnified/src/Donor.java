import java.awt.event.ActionEvent;
import java.time.LocalTime;

public class Donor  {


    //should get information from vehicle owner, to be stored in file
    //vc controller will get time completion, gui completion time algorithm

    //account page will hold a terminate button
    int donationID;
    DummyUser donor;
    DummyUser renter;
    int userID;
    int vehicleID;
    boolean isActive;
    int priority;

    private java.time.LocalTime LocalTime;
    LocalTime vehicleResidencyTime = LocalTime;

    public Donor (DummyUser user){

    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    void terminateDonation() {
        // detect time user will have


    }

    void update(){

    }

}
