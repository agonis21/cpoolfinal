import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home implements ActionListener {
    JFrame frame = new JFrame("Home");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JButton DonateButton;
    private JLabel HaveJobLabel;
    private JButton RentButton;
    private JButton logOutButton;

    public Home(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;


        TutorialButton.addActionListener(this);
        AboutButton.addActionListener(this);
        AccountButton.addActionListener(this);
        DonateButton.addActionListener(this);
        RentButton.addActionListener(this);
        logOutButton.addActionListener(this);

    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source == AboutButton)
        {
            About aboutPage = new About(user);
            frame.dispose();
        }
        if(source == AccountButton)
        {
            Account accountPage = new Account(user);
            frame.dispose();
        }
        if(source == TutorialButton)
        {
            Tutorial tutorialPage = new Tutorial(user);
            frame.dispose();
        }

        if(source == DonateButton)
        {
            if(user.hasActiveDonation)
            {
                Disconnect disconnect = new Disconnect(user);
                frame.dispose();
            }
            else if(user.getIsDonor() == true)
            {
//                HowLong howLongPage = new HowLong(user);
//                frame.dispose();
                VehicleRegistration registration = new VehicleRegistration(user);
                frame.dispose();

            }
            else if(user.getIsDonor()==false)
            {
                VehicleRegistration registration = new VehicleRegistration(user);
                frame.dispose();
            }
        }

        if(source == RentButton)
        {
            JobDetails jobDetailsPage = new JobDetails(user);
            frame.dispose();
        }
        if (source == logOutButton)
        {
            frame.dispose();
            SignIn signInPage = new SignIn();

        }



    }
}
