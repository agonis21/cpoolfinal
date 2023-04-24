import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {
    JFrame frame = new JFrame("About");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JLabel AboutUSLabel;
    private JLabel carpoolUsersLabel;
    private JLabel DonorsLabel;
    private JLabel freeParkingLabel;
    private JLabel carsComputerLabel;
    private JLabel RentersLabel;
    private JLabel submitInformationLabel;
    private JLabel filesAndJobLabel;
    private JLabel poolOfResourcesLabel;
    private JPanel TextPanel;
    private JButton logOutButton;

    public About (DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        HomeButton.addActionListener(this);
        TutorialButton.addActionListener(this);
        AccountButton.addActionListener(this);
        logOutButton.addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }
        if(source == TutorialButton)
        {
            Tutorial tutorialPage = new Tutorial(user);
            frame.dispose();
        }
        if (source == AccountButton)
        {
            Account accountPage = new Account(user);
            frame.dispose();
        }
        if (source == logOutButton)
        {
            frame.dispose();
            SignIn signInPage = new SignIn();

        }
    }
}
