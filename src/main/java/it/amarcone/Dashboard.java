package it.amarcone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

public class Dashboard extends JFrame {
    private final static int BORDER_EXT = 10;
    private final static int GAP_BIG = 20;
    private final static int GAP_MID = 10;
    private final static int GAP_SMALL = 5;
    private final static int FIELD_SIZE_L = 22;
    private final static int FIELD_SIZE_M = 11;

    private DatabaseManager database;
    private JPanel page;
    private JTextArea console;


    public Dashboard() {
        super("Reviewit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(900, 600);
        setResizable(true);
        setMinimumSize(new Dimension(800, 600));

        ImageIcon icon = new ImageIcon("src/main/resources/reviewit.png");
        setIconImage(icon.getImage());

        database = new DatabaseManager();

        page = new JPanel();
        page.setLayout(new BoxLayout(page,BoxLayout.X_AXIS));

        //Fake console to show query output
        console = new JTextArea(25,35);
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
        tabbedPane.addTab("OP13", operazione13());
        tabbedPane.addTab("OP14", operazione14());
        tabbedPane.addTab("OP15", operazione15());

        page.add(tabbedPane);
        
        page.add(scrollableTextArea);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(page, BorderLayout.CENTER);
        setContentPane(content);
        setVisible(true);
    }

    public JPanel operazione04(){
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 4");
        JLabel label_descrizione = new JLabel("Recuperare le opere che ha recensito un utente");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

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
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_username);

        return panel;
    }

    public JPanel operazione05(){
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 5");
        JLabel label_descrizione = new JLabel("Recuperare da una lista tutte le opere che sono state già visualizzate e non");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

        JLabel label_listaId = new JLabel("Id lista");
        JTextField field_listaId = new JTextField(FIELD_SIZE_M);

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
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,0,SpringLayout.WEST, label_descrizione);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(label_listaId);
        panel.add(field_listaId);
        layout.putConstraint(SpringLayout.WEST, label_listaId,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_listaId,GAP_MID,SpringLayout.SOUTH, field_username);
        layout.putConstraint(SpringLayout.WEST, field_listaId,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_listaId,GAP_SMALL,SpringLayout.SOUTH, label_listaId);

        panel.add(visto);
        panel.add(nonvisto);
        layout.putConstraint(SpringLayout.WEST, visto,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, visto,GAP_MID,SpringLayout.SOUTH, field_listaId);
        layout.putConstraint(SpringLayout.WEST, nonvisto,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nonvisto,GAP_SMALL,SpringLayout.SOUTH, visto);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, nonvisto);
        return panel;
    }

    public JPanel operazione06(){
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 6");
        JLabel label_descrizione = new JLabel("Recuperare tutte le opere a cui ha partecipato un lavoratore");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_nome = new JLabel("Nome");
        JTextField field_nome = new JTextField(FIELD_SIZE_L);

        JLabel label_cognome = new JLabel("Cognome");
        JTextField field_cognome = new JTextField(FIELD_SIZE_L);

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
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_nome);
        panel.add(field_nome);
        layout.putConstraint(SpringLayout.WEST, label_nome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_nome,GAP_MID, SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_nome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_nome,GAP_SMALL, SpringLayout.SOUTH, label_nome);

        panel.add(label_cognome);
        panel.add(field_cognome);
        layout.putConstraint(SpringLayout.WEST, label_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_cognome,GAP_MID, SpringLayout.SOUTH, field_nome);
        layout.putConstraint(SpringLayout.WEST, field_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_cognome,GAP_SMALL, SpringLayout.SOUTH, label_cognome);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID, SpringLayout.SOUTH, field_cognome);

        return panel;
    }

    public JPanel operazione07() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 7");
        JLabel label_descrizione = new JLabel("Recuperare le notizie pubblicate da un utente");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

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
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_username);

        return panel;
    }

    public JPanel operazione08() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 8");
        JLabel label_descrizione = new JLabel("Opere viste in un range temporale");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

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
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(label_dataMin);
        panel.add(pickerDataMin);
        layout.putConstraint(SpringLayout.WEST, label_dataMin,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_dataMin,GAP_MID,SpringLayout.SOUTH, field_username);
        layout.putConstraint(SpringLayout.WEST, pickerDataMin,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMin,GAP_SMALL,SpringLayout.SOUTH, label_dataMin);

        panel.add(label_dataMax);
        panel.add(pickerDataMax);
        layout.putConstraint(SpringLayout.WEST, label_dataMax,60,SpringLayout.EAST, label_dataMin);
        layout.putConstraint(SpringLayout.NORTH, label_dataMax,0,SpringLayout.NORTH, label_dataMin);
        layout.putConstraint(SpringLayout.WEST, pickerDataMax,0,SpringLayout.WEST, label_dataMax);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMax,GAP_SMALL,SpringLayout.SOUTH, label_dataMax);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, pickerDataMin);

        return panel;
    }

    public JPanel operazione09() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 9");
        JLabel label_descrizione = new JLabel("Numero opere viste in un range temporale");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

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
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);
        
        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(label_dataMin);
        panel.add(pickerDataMin);
        layout.putConstraint(SpringLayout.WEST, label_dataMin,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_dataMin,GAP_MID,SpringLayout.SOUTH, field_username);
        layout.putConstraint(SpringLayout.WEST, pickerDataMin,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMin,GAP_SMALL,SpringLayout.SOUTH, label_dataMin);

        panel.add(label_dataMax);
        panel.add(pickerDataMax);
        layout.putConstraint(SpringLayout.WEST, label_dataMax,60,SpringLayout.EAST, label_dataMin);
        layout.putConstraint(SpringLayout.NORTH, label_dataMax,0,SpringLayout.NORTH, label_dataMin);
        layout.putConstraint(SpringLayout.WEST, pickerDataMax,0,SpringLayout.WEST, label_dataMax);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMax,GAP_SMALL,SpringLayout.SOUTH, label_dataMax);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, pickerDataMin);

        return panel;
    }

    public JPanel operazione11() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 11");
        JLabel label_descrizione = new JLabel("Numero follower");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

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
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);
        
        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_username);

        return panel;
    }

    public JPanel operazione13() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 13");
        JLabel label_descrizione = new JLabel("Ordina lavoratori per numero di opere");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JButton submit = new JButton("Recupera");
        submit.addActionListener(e -> {
            String result;
            database.createConnection();
            result = database.viewLavoratoriOrderByNumeroOpere();
            database.closeConnection();
            System.out.println("Lista dei lavoratori in ordine di numero di opere: \n" + result);
            console.setText("Lista dei lavoratori in ordine di numero di opere: \n" + result);
        });
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, label_descrizione);

        return panel;
    }

    public JPanel operazione14() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 14");
        JLabel label_descrizione = new JLabel("Opere in cui il registra ha almeno un altro ruolo");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JButton submit = new JButton("Recupera");
        submit.addActionListener(e -> {
            String result;
            database.createConnection();
            result = database.viewOpereWithRegistaMultipleRoles();
            database.closeConnection();
            System.out.println("Opere in cui il registra ha almeno un altro ruolo: \n" + result);
            console.setText("Opere in cui il registra ha almeno un altro ruolo: \n" + result);
        });
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, label_descrizione);

        return panel;
    }

    public JPanel operazione15() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 15");
        JLabel label_descrizione = new JLabel("Report dei dati di un utente");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_username.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.reportUtente(field_username.getText());
                database.closeConnection();
                System.out.println("Report utente " + field_username.getText() + ":");
            }
            System.out.println(result);
            console.setText(result);
        });
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_username);
        panel.add(field_username);
        layout.putConstraint(SpringLayout.WEST, label_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_username,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_username,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_username,GAP_SMALL,SpringLayout.SOUTH, label_username);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_username);

        return panel;
    }
}
