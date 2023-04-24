import javax.swing.*;

public class ClientVCC {
    JFrame frame = new JFrame("Client Cloud Controller");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JLabel logoLabel;
    private JButton closeWindowButton;
    private JLabel RequestInfo;
    private JLabel status_label;

    ClientVCC() {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updateStatus(String text){
        this.status_label.setText(text);
    }

}
