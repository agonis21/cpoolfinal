import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial implements ActionListener {
    JFrame frame = new JFrame("Tutorial");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JLabel DonorTutorialLabel;
    private JLabel DStep1Label;
    private JLabel DStep2Label;
    private JLabel DStep3Label;
    private JLabel DStep4Label;
    private JLabel RenterTutorialLabel;
    private JLabel RStep1;
    private JLabel RStep2;
    private JLabel RStep3;
    private JPanel RStep4;
    private JLabel RStep4Label;
    private JButton logOutButton;

    public Tutorial(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        HomeButton.addActionListener(this);
        AboutButton.addActionListener(this);
        AccountButton.addActionListener(this);
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
        if(source == AccountButton)
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
