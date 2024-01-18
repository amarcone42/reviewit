package it.amarcone;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

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

        tabbedPane.addTab("OP11", operazione11());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        page.add(tabbedPane);

        setContentPane(page);
        setVisible(true);
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
