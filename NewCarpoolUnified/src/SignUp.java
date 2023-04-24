import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp implements ActionListener {
    JFrame frame = new JFrame("Sign Up");
    private JPanel BackgroundPanel;
    private JLabel logoLabel;
    private JPanel Workspace;
    private JTextField usernameTF;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTF;
    private JButton signUpButton;
    private JButton haveAcctButton;
    private JPasswordField confirmPasswordTF;
    private JLabel ConfirmPasswordLabel;
    private JLabel lnameLabel;
    private JTextField LnameTF;
    private JTextField FnameTF;
    private JLabel FnameLabel;

    public SignUp()
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        haveAcctButton.addActionListener(this);
        signUpButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == haveAcctButton)
        {
            SignIn signInPage = new SignIn();
            frame.dispose();
        }
        if (source == signUpButton)
        {
            String username = usernameTF.getText();
            String password = String.valueOf(passwordTF.getPassword());
            String confirmation = String.valueOf(confirmPasswordTF.getPassword());
            String fname = FnameTF.getText();
            String lname = LnameTF.getText();
            try {
                if(checkSignUp(username,password,confirmation))
                {
                    //arrayList add represents insert into database
                    DummyUser dummy = new DummyUser(username,password,fname,lname);
                    UserDBAccess.insert(dummy);
                    SignIn.users.add(dummy);
                    SignIn signInPage = new SignIn();
                    frame.dispose();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //helper methods

    public boolean checkSignUp(String username, String password, String confirmation) throws SQLException {

        if (UserDBAccess.usernameTaken(username) == false)
        {

            if (password.equals(confirmation) && password.length() >= 4) {
                return true;
            }
            else return false;
        }
        else
        {
            return false;
        }
    }
}

