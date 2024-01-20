package it.amarcone;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

public class Dashboard extends JFrame {
    DatabaseManager database;
    JPanel page;
    
    public Dashboard() {
        super("Reviewit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(720, 500);
        setResizable(true);
        setMinimumSize(new Dimension(600, 600));

        database = new DatabaseManager();

        page = new JPanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setForeground(getForeground());

        tabbedPane.addTab("OP7", operazione07());
        tabbedPane.addTab("OP8", operazione08());
        tabbedPane.addTab("OP9", operazione09());
        tabbedPane.addTab("OP11", operazione11());

        page.add(tabbedPane);

        setContentPane(page);
        setVisible(true);
    }

    public JPanel operazione07() {
        JPanel panel = new JPanel();

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JButton submit = new JButton("Calcola");
        submit.addActionListener(e -> {
            String result;

            if (field_username.getText().equals("")) {
                System.out.println("Campo vuoto");
            } else {
                database.createConnection();
                result = database.viewNotizieByUtente(field_username.getText());
                database.closeConnection();
                System.out.println("Notizie dell'utente " + field_username.getText() + ":");
                System.out.println(result);
            }
        });
        panel.add(label_username);
        panel.add(field_username);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione08() {
        JPanel panel = new JPanel();

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JLabel label_dataMin = new JLabel("Data inizio");
        JXDatePicker pickerDataMin = new JXDatePicker ();
        pickerDataMin.setDate (Calendar.getInstance ().getTime ());
        pickerDataMin.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_dataMax = new JLabel("Data fine");
        JXDatePicker pickerDataMax = new JXDatePicker ();
        pickerDataMax.setDate (Calendar.getInstance ().getTime ());
        pickerDataMax.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));
    
        JButton submit = new JButton("Calcola");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataMin = desiredFormat.format(pickerDataMin.getDate());
            String dataMax = desiredFormat.format(pickerDataMax.getDate());

            String result;

            if (field_username.getText().equals("")) {
                System.out.println("Campo vuoto");
            } else {
                database.createConnection();
                System.out.println("Opere viste dal "+ dataMin + " al " + dataMax + ": ");
                result = database.viewOpereInDateRange(field_username.getText(), dataMin, dataMax);
                database.closeConnection();
                System.out.println(result);
            }
        });
        panel.add(label_username);
        panel.add(field_username);

        panel.add(label_dataMin);
        panel.add(pickerDataMin);

        panel.add(label_dataMax);
        panel.add(pickerDataMax);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione09() {
        JPanel panel = new JPanel();

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JLabel label_dataMin = new JLabel("Data inizio");
        JXDatePicker pickerDataMin = new JXDatePicker ();
        pickerDataMin.setDate (Calendar.getInstance ().getTime ());
        pickerDataMin.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_dataMax = new JLabel("Data fine");
        JXDatePicker pickerDataMax = new JXDatePicker ();
        pickerDataMax.setDate (Calendar.getInstance ().getTime ());
        pickerDataMax.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));
    
        JButton submit = new JButton("Calcola");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataMin = desiredFormat.format(pickerDataMin.getDate());
            String dataMax = desiredFormat.format(pickerDataMax.getDate());

            if (field_username.getText().equals("")) {
                System.out.println("Campo vuoto");
            } else {
                database.createConnection();
                System.out.println("Opere viste dal "+ dataMin + " al " + dataMax + ": " + database.countOpereInDateRange(field_username.getText(), dataMin, dataMax));
                database.closeConnection();
            }
        });
        panel.add(label_username);
        panel.add(field_username);

        panel.add(label_dataMin);
        panel.add(pickerDataMin);

        panel.add(label_dataMax);
        panel.add(pickerDataMax);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione11() {
        JPanel panel = new JPanel();

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JButton submit = new JButton("Calcola");
        submit.addActionListener(e -> {
            if (field_username.getText().equals("")) {
                System.out.println("Campo vuoto");
            } else {
                database.createConnection();
                System.out.println("followers:" + database.countFollowers(field_username.getText()));
                database.closeConnection();
            }
            
        });
        panel.add(label_username);
        panel.add(field_username);
        panel.add(submit);
        return panel;
    }
}
