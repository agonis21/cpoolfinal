import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userCRUD {
    public userCRUD(String filename) {
        try {
            File myObj = new File("src/db/" + filename);
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);

            // we are going to store all the users in an array of hashmaps
            List<Map<String , String>> UserMapList  = new ArrayList<Map<String,String>>();

            int i = 0;
            String header;
            String[] header_attributes = {};

            HashMap<String, String> User = new HashMap<String, String>();

            while (myReader.hasNextLine()) {

                if (i == 0) { //header
                    header = myReader.nextLine();
                    header_attributes = header.split(",");

                    // length of attributes
                    // System.out.println(header_attributes.length);

                    // printing out each attribute

                    /*
                    for (String attribute : header_attributes){
                        System.out.println(attribute);
                    }
                    */


                } else { //data
                    String userEntry = myReader.nextLine();
                    String[] user_attributes = userEntry.split(",");

                    // clearing the hashmap before entering data
                    User.clear();

                    // making sure each user has a value for each header attribute
                    for (int k = 0; k < header_attributes.length; k++){
                        User.put(header_attributes[k], user_attributes[k]);
                    }

                    // after putting each user's data into user hash map, put
                    // everything into user hashmap list

                    // adding a new user to the hash map list
                    UserMapList.add(i - 1, User);
                    //System.out.println(userEntry);
                    //System.out.println(User);
                }

                i++;
            }

            System.out.println(UserMapList);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        userCRUD a = new userCRUD("vehicle.txt");
    }
}
