import java.io.Serializable;

public class Requests implements Serializable {

    public Job jobRequest;
    public Donation donRequest;

    public int sentinel = 0;

    public Requests(Job job){

        if(this.sentinel == 0){
            this.jobRequest = job;
        }
        this.sentinel = 1;
    }

    public Requests(Donation donation){
        if(this.sentinel == 0){
            this.donRequest = donation;
        }
        this.sentinel = 1;
    }

}
