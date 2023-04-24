import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;

public class JobLog {

    JFrame frame = new JFrame("Job Log");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton DisconnectButton;
    private JButton UserButton;
    private JButton VehicleButton;
    private JLabel logoLabel;
    private JButton RequestButton;
    private JTable jobTable;
    private JScrollPane ScrollPane;
    public Server server;

        JobLog() {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        createTable();
        //this.server = server;
            jobTable.addComponentListener(new ComponentAdapter() {
            });
        }
        //@Override
            public void actionPerformed (ActionEvent e){

            Object source = e.getSource();
            if (source == UserButton) {
                UserLog userlog = new UserLog();
                frame.dispose();
            }

            if (source == VehicleButton) {
                VehicleLog vehiclelog = new VehicleLog();
                frame.dispose();

            }
            if (source == RequestButton) {
                AdminVCC request = new AdminVCC();
                frame.dispose();
            }
    }

    private void createTable(){
        Object [][] data= {
                {"2023-04-02T14:38:33.901484900",111,222,"Conversion",0,0,0},
                {},
                {}};
        jobTable.setModel(new DefaultTableModel(data,
                new String[] {"JobSubmissionTime","userID","jobID","JobType","JobDeadline","JobDuration","JobCompletionTime"}
        ));

    }
    }
