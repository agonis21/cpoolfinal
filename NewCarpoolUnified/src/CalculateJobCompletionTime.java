import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculateJobCompletionTime {
    public int completionTime = 0;

    public int CalculateJobCompletionTime() throws IOException {
        ConvertTextToHashmapList jobs = new ConvertTextToHashmapList("jobs.txt");

        List<Map<String , String>> jobCompletionTimeList  = new ArrayList<Map<String,String>>();


        for (int i = 0; i < jobs.MapList.size(); i++){
            Map<String , String> jobEntry = jobs.MapList.get(i);

            int jobEntryCompletionTime = 0;
            if (i == 0) {
                jobEntryCompletionTime = Integer.parseInt(jobEntry.get("JobDuration"));
            } else {
                Map<String , String> previousJobEntry = jobs.MapList.get(i - 1);
                jobEntryCompletionTime = Integer.parseInt(previousJobEntry.get("JobCompletionTime"))
                        + Integer.parseInt(jobEntry.get("JobDuration"));
            }

            jobEntry.put("JobCompletionTime", "" + jobEntryCompletionTime);
            this.completionTime = jobEntryCompletionTime;

            jobCompletionTimeList.add(jobs.MapList.get(i));
        }

        for (Map<String, String> job: jobCompletionTimeList){
            //System.out.println(job);

        }

        System.out.println(jobCompletionTimeList.get(jobCompletionTimeList.size()-1));
        return 5;
    }

    public int getCompletionTime(){
        return this.completionTime;
    }

    public static void main (String[] args) throws IOException {

    }
}
