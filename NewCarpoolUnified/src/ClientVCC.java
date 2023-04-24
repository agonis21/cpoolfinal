import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        closeWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void updateStatus(String text){
        this.status_label.setText(text);
    }

    //@Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == closeWindowButton){
            frame.dispose();
        }
    }
}
