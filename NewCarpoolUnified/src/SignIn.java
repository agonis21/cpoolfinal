import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;


public class SignIn implements ActionListener
{
    JFrame frame = new JFrame("Sign In");
    public static ArrayList<DummyUser> users = new ArrayList<DummyUser>();
    private JLabel logoLabel;
    private JTextField usernameTF;
    private JButton createAccountButton;
    private JPasswordField PasswordTF;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton signInButton;
    private JButton forgotPwordButton;
    private JPanel Workspace;
    private JPanel BackgroundPanel;


    public SignIn(){
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Adds Button Functionalities
        signInButton.addActionListener(this);
        createAccountButton.addActionListener(this);
        forgotPwordButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == createAccountButton)
        {
            SignUp signUpPage = new SignUp();
            frame.dispose();
        }
        if (source == signInButton)
        {
            String username = usernameTF.getText();
            String password = String.valueOf(PasswordTF.getPassword());

            //DummyUser user = findUser(username,password);
            DummyUser user = null;
            try {
                user = UserDBAccess.checkCredentials(username,password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if(user != null)
            {
                Home homePage = new Home(user);
                frame.dispose();
            }


        }

    }

    //    method simulates DB query that will check if a user entered information that exists in the table
//    returns that user if they exist. program will store information for that user in a user object
//    once the user enters correct information, this will lessen amount of db interaction, and increase
//    data retrieval speed
    public DummyUser findUser(String username, String password)
    {
        for(int i = 0; i<users.size();i++)
        {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password))
            {
                return users.get(i);
            }
        }
        return null;
    }



}
