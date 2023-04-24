import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class ConvertTextToHashmapList {

    List<Map<String , String>> MapList  = new ArrayList<Map<String,String>>();

    public ConvertTextToHashmapList(String filename) throws IOException {

        try {
            File myObj = new File("NewCarpoolUnified/src/db/" + filename);
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);

            // we are going to store all the users in an array of hashmaps

            FileReader fr = new FileReader(myObj);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            String header, userEntry;
            String[] header_attributes = {};
            String[] user_attributes = {};
            // String s = br.readLine();
           // header_attributes = s.split(",");
           // user_attributes = s.split(",");


            while (myReader.hasNextLine()) {
                HashMap<String, String> User = new HashMap<String, String>();

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
                    userEntry = myReader.nextLine();
                    //System.out.println(userEntry);
                    user_attributes = userEntry.split(",");
                    //System.out.println(user_attributes[1]);


                    // clearing the hashmap before entering data
                    User.clear();

                    // making sure each user has a value for each header attribute
                    for (int k = 0; k < header_attributes.length; k++){
                        User.put(header_attributes[k], user_attributes[k]);
                    }
                    /*   UserMapList.add(header_attributes[k],
                               user_attributes[k]);
                      //  UserMapList.add(User.put(header_attributes[k], user_attributes[k]));
                        UserMapList.add(User);
*/

                    // after putting each user's data into user hash map, put
                    // everything into user hashmap list

                    // adding a new user to the hash map list
                    //System.out.println(i);
                    //System.out.println(User);
                    MapList.add(User);


                    //UserMapList.add(User);
                    // UserMapList.add(User);

                    //System.out.println(userEntry);
                    //System.out.println(User);
                }
                i++;
            }

            //System.out.println(UserMapList);

            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public List<Map<String , String>> returnHashmapList(){
        return MapList;
    }
    public static void main(String[] args) throws IOException {



    }
}
