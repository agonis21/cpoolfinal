import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disconnect implements ActionListener {
    JFrame frame = new JFrame("Disconnect");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton DisconnectButton;
    private JLabel ThankYouLabel;
    private JLabel DisconnectConfirmationLabel;
    private JPanel Header;
    private JLabel SubmissionCompleteLabel;


    public Disconnect(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        HomeButton.addActionListener(this);
        DisconnectButton.addActionListener(this);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if(source == HomeButton)
    {
        Home homePage = new Home(user);
        frame.dispose();
    }
    if(source == DisconnectButton)
    {
        user.setActive(false);
        Home homePage = new Home(user);
        frame.dispose();
    }


    }
}
