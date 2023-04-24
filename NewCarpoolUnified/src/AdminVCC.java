import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminVCC {

    JFrame frame = new JFrame("Cloud Controller");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton DiscButton;
    private JLabel logoLabel;
    private JButton AcceptButton;
    public JLabel RequestInfo;
    private JButton DeclineButton;
    private JButton VehicleButton;
    private JButton JobButton;
    private JButton UserButton;
    public JLabel TestLabel;
    private JLabel userIDJ;
    private JLabel jobID;
    private JLabel jobType;
    private JLabel deadline;
    private JLabel userIDV;
    private JLabel compTime;
    private JLabel duraTion;
    private JLabel VechID;
    private JLabel Make;
    private JLabel Model;
    private JLabel Year;
    private JLabel plateNum;
    private JLabel state;
    public Server server;

    AdminVCC() {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //this.server = server;


        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                server.isAccepted(true);
//                server.respond();
            }
        });
        DeclineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                server.isAccepted(false);
//                server.respond();
            }
        });

    }
   // @Override
    /* public void actionPerformed(ActionEvent e) {
         /*
         String messageIn = "";
         String messageOut = "";

         Object source = e.getSource();
         if (source == AcceptButton) {
             server.isAccepted(true);
             server.respond();
             Requests requests = server.recieved;
             //write to database
             //unpack();

             frame.dispose();
         }
         if (source == DeclineButton) {
             server.isAccepted(false);
             server.respond();
             frame.dispose();
         }
     }

 */
    //method for unpack
    public void write(String input) {
        String content = "";

        try {
            File myObj = new File("src/db/" + "jobs.txt");
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

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //method for vehicle to be fixed
    }

    public String unpack(Requests requests){
        if (requests.jobRequest != null){
            int jobID = requests.jobRequest.jobId;
            DummyUser user = requests.jobRequest.user;
            int userID = user.getUserID();
            String jobType = requests.jobRequest.jobType;


            String jobInput = ""+jobID+userID+jobType;
            return jobInput;
            // LocalDateTime jobDeadline;
            // LocalDateTime userDuration;
        }
        if (requests.donRequest != null){
            int vehicleId = requests.donRequest.vehicle.vehicleId;
            String make = requests.donRequest.vehicle.make;
            String model = requests.donRequest.vehicle.model;
            int year = requests.donRequest.vehicle.year;
            String plateNum= requests.donRequest.vehicle.plateNumber;
            String stateRegistered= requests.donRequest.vehicle.stateRegistered;
            String donInput = ""+vehicleId+make+model+year+plateNum+stateRegistered;
            return donInput;
        }
        return null;

    }

    //@Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == UserButton)
        {
            UserLog userlog = new UserLog();
            frame.dispose();
        }
        if (source == JobButton)
        {
            JobLog joblog = new JobLog();
            frame.dispose();
        }
        if(source == VehicleButton)
        {
            VehicleLog vehiclelog = new VehicleLog();
            frame.dispose();
        }

    }

    public void updateRequestInfo(String text)
    {
        //if comma 6, job if comma 7, vehicle
        String[] reqArr = text.split(",");
        System.out.println(reqArr.length);
        if(reqArr.length == 7){
        updateRequestJobInfo(text);
        }
        else{
        updateRequestVehicleInfo(text);
        }

     //  this.TestLabel.setText(text); //sets userEntry on GUI
       frame.setVisible(false);
       frame.setVisible(true);
    }

    public void updateRequestJobInfo(String text){
        String[] jobArr = text.split(",");
        //update labels based on position each category of array
        this.userIDJ.setText(jobArr[1]);
        this.jobID.setText(jobArr[2]);
        this.jobType.setText(jobArr[3]);
        this.deadline.setText(jobArr[4]);
        this.duraTion.setText(jobArr[5]);
        this.compTime.setText(jobArr[6]);

        this.userIDV.setText("");
        this.VechID.setText("");
        this.Make.setText("");
        this.Model.setText("");
        this.Year.setText("");
        this.plateNum.setText("");
        this.state.setText("");
    }
    public void updateRequestVehicleInfo(String text){
    try {
    String[] vecArr = text.split(",");
    //update labels based on position each category of array
    this.userIDV.setText(vecArr[2]);
    this.VechID.setText(vecArr[3]);
    this.Make.setText(vecArr[4]);
    this.Model.setText(vecArr[5]);
    this.Year.setText(vecArr[6]);
    this.plateNum.setText(vecArr[7]);
    this.state.setText(vecArr[8]);

        this.userIDJ.setText("");
        this.jobID.setText("");
        this.jobType.setText("");
        this.deadline.setText("");
        this.duraTion.setText("");
        this.compTime.setText("");
    } catch(ArrayIndexOutOfBoundsException e){
    //throw new ArrayIndexOutOfBoundsException();
    }

    }



}
