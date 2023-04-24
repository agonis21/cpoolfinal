import java.io.Serializable;

public class JobRequest implements Serializable{
    public Job jobRequest;

    public int sentinel = 0;

    public JobRequest(Job job){

        if (this.sentinel == 0){
            this.jobRequest = job;
        }

        this.sentinel = 1;
    }
}
