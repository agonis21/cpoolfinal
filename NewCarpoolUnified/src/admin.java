import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class admin {
    private String Username;
    private String Password;
    private String Fname;
    private String Lname;

    public static List<Map<String , String>> calculateJobDurationTimes(String job_filename) throws IOException {
        ConvertTextToHashmapList jobs = new ConvertTextToHashmapList(job_filename);

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

            jobCompletionTimeList.add(jobs.MapList.get(i));
        }

        return jobCompletionTimeList;
    }

}

