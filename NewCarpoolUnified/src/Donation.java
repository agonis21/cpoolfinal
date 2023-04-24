import java.io.Serializable;

public class Donation implements Serializable {
    public Vehicle vehicle;
    public int duration;

    public Donation(Vehicle vehicle, int duration){
        this.vehicle = vehicle;
        this.duration= duration;

    }

}