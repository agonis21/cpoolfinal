//import src.JobRequest;

import javax.swing.*;
import javax.swing.Action;
import java.awt.Desktop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Path;

public class JobDetails implements ActionListener {
    JFrame frame = new JFrame("Job Information");
    DummyUser user;
    //static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JLabel logoLabel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JLabel HaveJobLabel;
    private JPanel Workspace;
    private JLabel MinutesLabel;
    private JTextField MinutesTF;
    private JButton SubmitButton;
    private JComboBox JobType;
    private JButton SelectFilesButton;
    private JLabel DurationLabel;
    private JTextField DurationText;
    private JTextField JobId;
    private JLabel JobIDLabel;
    private JTextField UserId;
    private JLabel SubmissionConfirmLabel;
    private JLabel JobCompletionLabel;

    public JobDetails(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        //connect the client socket to server
       /* Socket socket = null;
        try {
            socket = new Socket("localhost", 4444);
            //client reads a message from Server
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        SelectFilesButton.addActionListener(this);
        HomeButton.addActionListener(this);
        SubmitButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //
        String messageIn = "";
        String messageOut = "";
        //
        Object source = e.getSource();
        if (source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }
        if(source == SelectFilesButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            Action details = fileChooser.getActionMap().get("viewTypeDetails");
            details.actionPerformed(null);
            fileChooser.showOpenDialog(null);
            File[] files = fileChooser.getSelectedFiles();
            System.out.println(files);

            //this section will store the files that the user
            //selected

        }
        if (source== SubmitButton)
        {

            admin job = new admin();
            List<Map<String , String>> oldJobs = null;
            try {
                oldJobs = job.calculateJobDurationTimes("jobs.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            int jobCompletionTime= Integer.parseInt(oldJobs.get(oldJobs.size()-1).get("JobCompletionTime"));

            SubmissionConfirmLabel.setText("Submission Complete!");

            //Random randomizer = new Random();
            int userID = user.getUserID();
            int jobID = Integer.parseInt(JobId.getText());
            String jobType= JobType.getSelectedItem().toString();
            String deadline = DurationText.getText();
            String duration = MinutesTF.getText();
            jobCompletionTime += Integer.parseInt(duration);
            String timeNow = String.valueOf(LocalDateTime.now());
            //JobCompletionLabel.setText(completionTime);

            //String completionTime= ""+b;                        +","+completionTime
            String userEntry = timeNow+","+userID+","+jobID+","+jobType+
                    ","+deadline+","+duration+","+jobCompletionTime;
            System.out.println(userEntry);
            //System.out.println("Time of Submission:"+ LocalDateTime.now());

            try {
                SemClient sc1 = new SemClient(userEntry);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }


            Job dummyJob = new Job(jobID,userID,jobType,deadline,duration);
            try {
                JobDBAccess.insert(dummyJob);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }







            String content = "";
            // just reading and saving




            try {
                File myObj = new File("NewCarpoolUnified/src/db/" + "jobs.txt");
                // Get the absolute path of file f
                String absolute = myObj.getAbsolutePath();
                System.out.println(absolute);
                Scanner myReader = new Scanner(myObj);

                int i = 0;
                String line;



                while (myReader.hasNextLine()) {
                    line = myReader.nextLine();
                    content += line + "\n";
                    //content += "\n";

                    i++;
                }


                System.out.println(content);

                myReader.close();

                // just writing
                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("NewCarpoolUnified/src/db/jobs.txt"), "utf-8"))) {
                    writer.write(content + userEntry);

                    // using socket for client/server, here would be client
                   /* PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    messageIn = inputStream.readUTF();
                    // client prints the message received from server to console
                    System.out.println("message received from server: " + "\"" + messageIn + "\"");
                    // server sends the message (vehicleEntry array) to client
                    // in this case messageOut would be vehicleEntry
                    outputStream.writeUTF(userEntry);
                    outputStream.close();
                    inputStream.close();
                    socket.close();
*/
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            } catch (FileNotFoundException ppp) {
                //System.out.println("An error occurred.");
                ppp.printStackTrace();
            }

            CalculateJobCompletionTime cj = new CalculateJobCompletionTime();


            ArrayList<String> jobSelection = new ArrayList<String>();
            ArrayList<String> timeDuration = new ArrayList<String>();
            ArrayList<String> timeCompletion = new ArrayList<String>();

            /*
            This section will take the job details, store them into
            a job object, stamp the start time, and retrieve stored file information
            to be sent to the CloudController object to assign vehicles to this job
            at the time of submission, the DBAccess object will store the information
            regarding the job into the database. Once a Job is complete, the DB access
            object will be called from the cloud controller to stamp the completion time
            and give a final update to the job
             */

            List<Map<String , String>> newJobs = null;
            try {
                newJobs = job.calculateJobDurationTimes("jobs.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            int newJobCompletionTime= Integer.parseInt(newJobs.get(newJobs.size()-1).get("JobCompletionTime"));

            HaveJobLabel.setText("Your job will be completed in "  + newJobCompletionTime + " minutes.");
            //SubmitButton.setText("Submit");

            //Home homePage = new Home(user);
            //frame.dispose();

        }

    }
}
