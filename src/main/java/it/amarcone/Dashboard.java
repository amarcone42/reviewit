package it.amarcone;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

        setVisible(true);
    }
}
