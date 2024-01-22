package it.amarcone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.painter.AbstractLayoutPainter.VerticalAlignment;

public class Dashboard extends JFrame {
    DatabaseManager database;
    JPanel page;
    JTextArea console;
    
    public Dashboard() {
        super("Reviewit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(1000, 600);
        setResizable(true);
        setMinimumSize(new Dimension(1000, 600));

        database = new DatabaseManager();

        page = new JPanel();
        page.setLayout(new BoxLayout(page,BoxLayout.X_AXIS));

        //Fake console to show query output
        console = new JTextArea(25,50);
        console.setEditable(false);
        JScrollPane scrollableTextArea = new JScrollPane(console);

        JTabbedPane tabbedPane = new JTabbedPane(1);
        tabbedPane.setForeground(getForeground());

        tabbedPane.addTab("OP4", operazione04());
        tabbedPane.addTab("OP5", operazione05());
        tabbedPane.addTab("OP6", operazione06());
        tabbedPane.addTab("OP7", operazione07());
        tabbedPane.addTab("OP8", operazione08());
        tabbedPane.addTab("OP9", operazione09());
        tabbedPane.addTab("OP11", operazione11());

        page.add(tabbedPane);
        
        page.add(scrollableTextArea);

        setContentPane(page);
        setVisible(true);
    }

    public JPanel operazione04(){
        JPanel panel = new JPanel();

        JLabel label_titolo = new JLabel("Recuperare le opere viste da un utente tramite le recensioni");

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewOpereViewdByUtente(field_username.getText());
                database.closeConnection();
            }
            System.out.println("Opere viste da " + field_username.getText() + ":");
            System.out.println(result);
            console.setText("Opere viste da " + field_username.getText() + ":\n" + result);
        });
        panel.add(label_titolo);

        panel.add(label_username);
        panel.add(field_username);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione05(){
        JPanel panel = new JPanel();

        JLabel label_titolo = new JLabel("Recuperare da una lista tutte le opere che sono state già visualizzate e non");

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JLabel label_listaId = new JLabel("Id lista");
        JTextField field_listaId = new JTextField(10);

        JRadioButton visto = new JRadioButton("Opere visualizzate");
        visto.setActionCommand("true");
        visto.setSelected(true);

        JRadioButton nonvisto = new JRadioButton("Opere non visualizzate");
        nonvisto.setActionCommand("false");

        ButtonGroup group = new ButtonGroup();
        group.add(visto);
        group.add(nonvisto);   

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_username.getText().equals("") || field_listaId.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewOperefromListaViewed(field_username.getText(), Integer.parseInt(field_listaId.getText()), visto.isSelected());
                database.closeConnection();
            }
            System.out.println("Opere della lista " + field_listaId.getText() +" di " + field_username.getText() + ":");
            System.out.println(result);
            console.setText("Opere della lista " + field_listaId.getText() +" di " + field_username.getText() + ":\n" + result);
        });
        panel.add(label_titolo);

        panel.add(label_username);
        panel.add(field_username);

        panel.add(label_listaId);
        panel.add(field_listaId);

        panel.add(visto);
        panel.add(nonvisto);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione06(){
        JPanel panel = new JPanel();

        JLabel label_titolo = new JLabel("Recuperare tutte le opere a cui ha partecipato un lavoratore");

        JLabel label_nome = new JLabel("Nome");
        JTextField field_nome = new JTextField(10);

        JLabel label_cognome = new JLabel("Cognome");
        JTextField field_cognome = new JTextField(10);

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_nome.getText().equals("") || field_cognome.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewOperaByLavoratore(field_nome.getText(), field_cognome.getText());
                database.closeConnection();
                System.out.println("Opere del lavoratore " + field_nome.getText() +" " + field_cognome.getText() + ":");
            }
            System.out.println(result);
            console.setText(result);
        });
        panel.add(label_titolo);

        panel.add(label_nome);
        panel.add(field_nome);

        panel.add(label_cognome);
        panel.add(field_cognome);

        panel.add(submit);
        return panel;
    }

    public JPanel operazione07() {
        JPanel panel = new JPanel();

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(10);

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewNotizieByUtente(field_username.getText());
                database.closeConnection();
                System.out.println("Notizie dell'utente " + field_username.getText() + ":");
            }
            System.out.println(result);
            console.setText(result);
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
    
        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataMin = desiredFormat.format(pickerDataMin.getDate());
            String dataMax = desiredFormat.format(pickerDataMax.getDate());

            String result;

            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewOpereInDateRange(field_username.getText(), dataMin, dataMax);
                database.closeConnection();
                System.out.println("Opere viste dal "+ dataMin + " al " + dataMax + ": ");
            }
            System.out.println(result);
            console.setText(result);
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

            String result;
            int resultNumber = 0;
            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                resultNumber = database.countOpereInDateRange(field_username.getText(), dataMin, dataMax);
                database.closeConnection();
                //System.out.println("Opere viste dal "+ dataMin + " al " + dataMax + ": ");
                if (resultNumber >=0) {
                    result = "L'utente ha visto " + resultNumber + " opere";
                } else {
                    result = "Errore query";
                }
            }
            System.out.println(result);
            console.setText(result);
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
            String result;
            int resultNumber = 0;
            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                resultNumber = database.countFollowers(field_username.getText());
                database.closeConnection();
                if (resultNumber >=0) {
                    result = "L'utente ha " + resultNumber + " follower";
                } else {
                    result = "Errore query";
                }
            }
            System.out.println(result);
            console.setText(result);
        });
        panel.add(label_username);
        panel.add(field_username);
        panel.add(submit);
        return panel;
    }
}
