import java.io.Serializable;

public class Vehicle implements Serializable {
    public DummyUser user;
    public int userId;
    public int vehicleId;
    public String make ;
    public String model ;
    public int year;
    public String plateNumber ;
    public String stateRegistered;


    public Vehicle(DummyUser user, int vehicleId, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.vehicleId=vehicleId;

    }

    //DB constructor
    public Vehicle(int userID, int vehicleId, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.userId = userID;
        this.vehicleId=vehicleId;

    }

    public String getPlateNumber(){return this.plateNumber;}
    public String getStateRegistered(){return this.stateRegistered;}
    public String getMake(){return this.make;}
    public String getModel(){return this.model;}
    public int getYear(){return this.year;}
    public int getUserId(){return this.userId;}
    public int getVehicleId(){return this.vehicleId;}






}
