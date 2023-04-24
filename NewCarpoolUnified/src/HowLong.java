import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowLong implements ActionListener {
    JFrame frame = new JFrame("Duration");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JLabel logoLabel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JLabel HaveJobLabel;
    private JPanel Workspace;
    private JTextField MinutesTF;
    private JLabel MinutesLabel;
    private JButton SubmitButton;

    public HowLong(DummyUser user)
    {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;

        HomeButton.addActionListener(this);
        SubmitButton.addActionListener(this);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if(source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }
        if(source == SubmitButton)
        {
            //this will be inserted into the donation table
            int duration = Integer.parseInt(MinutesTF.getText());
            if(duration>0)
            {
                Donation donation = new Donation(user.vehicle,duration);
                Requests requests = new Requests(donation);
                Client client = new Client();
                client.run(requests);
                user.setActive(true);
                Disconnect disconnect = new Disconnect(user);
                frame.dispose();
            }

        }






    }
}
