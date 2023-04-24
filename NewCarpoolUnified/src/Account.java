import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account implements ActionListener {
    JFrame frame = new JFrame("My Account");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JButton terminateJob;
    private JButton logOutButton;

    public Account(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        HomeButton.addActionListener(this);
        TutorialButton.addActionListener(this);
        AboutButton.addActionListener(this);
        logOutButton.addActionListener(this);






    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }
        if (source == AboutButton)
        {
            About aboutPage = new About(user);
            frame.dispose();
        }
        if(source == TutorialButton)
        {
            Tutorial tutorialPage = new Tutorial(user);
            frame.dispose();
        }
        if(source == terminateJob)
        {
            //may have to change later to a diff page?? cancellation report page?
            Donor terminate = new Donor(user);
            frame.dispose();
        }
        if (source == logOutButton)
        {
            frame.dispose();
            SignIn signInPage = new SignIn();

        }
    }
}
