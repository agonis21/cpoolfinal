import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.HashMap;
import java.util.Scanner;

public class Checkpoint {
    String FILE_NAME = generateFileName();

    String DIVIDER = "-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -";
    String HEADING_STRING = "";
    String TIME_STRING = "";
    String USERS_STRING = "";
    String VEHICLES_STRING = "";
    String JOBS_STRING = "";

    int TOTAL_JOBS = 0;
    int TOTAL_USERS = 0;
    int TOTAL_VEHICLES = 0;

    String FILE_STRING =
            HEADING_STRING
                    + TIME_STRING
                    + USERS_STRING
                    + VEHICLES_STRING
                    + JOBS_STRING;

    public Checkpoint() {
        this.printFile();
    }


    public String captureHeading() {

        this.HEADING_STRING += "CARPOOL (c) 2023";
        this.HEADING_STRING += "\n";
        this.HEADING_STRING += "Created By: Asm, Steven, Maya, Maria, Fairooz";
        this.HEADING_STRING += "\n";
        this.HEADING_STRING += this.DIVIDER;
        this.HEADING_STRING += "\n";

        return this.HEADING_STRING;
    }

    public String generateFileName(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E-MMM-dd-yyyy-HH-mm-ss");
        String formattedDate = myDateObj.format(myFormatObj);

        return "checkpoint-" + formattedDate.toLowerCase() + ".txt";

    }

    public String captureTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        this.TIME_STRING += "Time of Capture: "+ formattedDate;
        this.TIME_STRING += "\n";
        this.TIME_STRING += this.DIVIDER;
        this.TIME_STRING += "\n";

        return this.TIME_STRING;

    }

    public String captureUsers() {
        this.USERS_STRING += "USERS:";
        this.USERS_STRING += "\n";

        //loop through users retrieved from database in the future
        try {
            File myObj = new File("NewCarpoolUnified/src/db/" + "users.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);


            int i = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                this.USERS_STRING += i + ". ";
                this.USERS_STRING += line;
                this.USERS_STRING += "\n";

                i++;
            }

            this.TOTAL_USERS = i;
            this.USERS_STRING += "NewCarpoolUnified/Total number of users: " + this.TOTAL_USERS;
            this.USERS_STRING += "\n";

        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }


        this.USERS_STRING += this.DIVIDER;
        this.USERS_STRING += "\n";

        return this.USERS_STRING;
    }

    public String captureVehicles() {
        this.VEHICLES_STRING += "VEHICLES:";
        this.VEHICLES_STRING += "\n";


        try {
            File myObj = new File("NewCarpoolUnified/src/db/" + "vehicle.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);


            int i = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                this.VEHICLES_STRING += i + ". ";
                this.VEHICLES_STRING += line;
                this.VEHICLES_STRING += "\n";

                i++;
            }

            this.TOTAL_VEHICLES = i;
            this.VEHICLES_STRING += "Total number of vehicles: " + this.TOTAL_VEHICLES;
            this.VEHICLES_STRING += "\n";

        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }




        this.VEHICLES_STRING += this.DIVIDER;
        this.VEHICLES_STRING += "\n";

        return this.VEHICLES_STRING;
    }

    public String captureJobs() {
        this.JOBS_STRING += "JOBS:";
        this.JOBS_STRING += "\n";


        //loop through vehicles retrieved from database in the future
        try {
            File myObj = new File("NewCarpoolUnified/src/db/" + "jobs.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);


            int i = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                this.JOBS_STRING += i + ". ";
                this.JOBS_STRING += line;
                this.JOBS_STRING += "\n";

                i++;
            }

            this.TOTAL_JOBS = i;
            this.JOBS_STRING += "Total number of jobs: " + this.TOTAL_JOBS;
            this.JOBS_STRING += "\n";

        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }



        this.JOBS_STRING += this.DIVIDER;
        this.JOBS_STRING += "\n";

        return this.JOBS_STRING;
    }

    public String capture() {
        String c_heading = captureHeading();
        String c_time = captureTime();
        String c_users = captureUsers();
        String c_vehicles = captureVehicles();
        String c_jobs = captureJobs();

        String c_output = c_heading + c_time + c_users + c_vehicles + c_jobs;


        this.FILE_STRING = c_output;
        return c_output;
    }

    public String printFile() {
        capture();
        System.out.println(this.FILE_STRING);

        return this.FILE_STRING;
    }

    public void exportFile() throws IOException {

        //check if folder exists, if not, create it
//        File theDir = new File("/checkpoints");
//        if (!theDir.exists()){
//            theDir.mkdirs();
//        }

        //Path path = Paths.get("checkpoints/" + this.FILE_NAME);
        String contents = this.FILE_STRING;


        try(FileWriter writer = new FileWriter(this.FILE_NAME)) {
            writer.write(contents);
            writer.close();
            System.out.println("Exported to: " + this.FILE_NAME);

        }

        catch(IOException e){
            // Handle the exception
            e.printStackTrace();

        }

//        try {
//            Files.writeString(path, contents, StandardCharsets.UTF_8);
//
//            File output = new File("checkpoints/" + this.FILE_NAME);
//            FileWriter writer = new FileWriter(output);
//
//            writer.write("This text was written with a FileWriter");
//            writer.flush();
//            writer.close();
//        } catch (IOException ex) {
//            // Handle exception
//
//
//        }
    }

    public static void main(String[] args) throws IOException {


    }
}