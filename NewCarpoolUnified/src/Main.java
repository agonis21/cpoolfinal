import java.util.ArrayList;

// NOTE, ALL COMMENTS REFFERING TO DATABASE WILL BE MANAGED IN
// DBACESS OBJECT IN ORDER TO BE ORGANIZED

public class Main {


    public static void main(String[] args) {

        try {

//            DummyUser presetDummy = new DummyUser("Joey", "balls");
//            Home homePage = new Home(presetDummy);

            UserDBAccess.init();
            VehicleDBAccess.init();
            JobDBAccess.init();
//            DummyUser presetDummy = new DummyUser("Joey", "balls");
//            DummyUser presetDummy1 = new DummyUser("Steven", "password");
//
//            SignIn.users.add(presetDummy);
//
//            //Vehicle dummyCar = new Vehicle(presetDummy1, "Jeep", "Compass Trailhawk", 2022, "ABC123", "NY");
//            //presetDummy1.setVehicle(dummyCar);
//            //presetDummy1.setIsDonor(true);
//            SignIn.users.add(presetDummy1);
//
//
            SignIn signInPage = new SignIn();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}