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
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

public class Dashboard extends JFrame {
    private final static int BORDER_EXT = 15;
    private final static int GAP_BIG = 20;
    private final static int GAP_MID = 10;
    private final static int GAP_SMALL = 5;
    private final static int FIELD_SIZE_XL = 32;
    private final static int FIELD_SIZE_L = 22;
    private final static int FIELD_SIZE_M = 11;
    private final static int FIELD_SIZE_S = 6;

    private DatabaseManager database;
    private JPanel page;
    private JTextArea console;


    public Dashboard() {
        super("Reviewit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(900, 600);
        setResizable(true);
        setMinimumSize(new Dimension(1200, 750));
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);

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

        tabbedPane.addTab("OP1", operazione01());
        tabbedPane.addTab("OP2", operazione02());
        tabbedPane.addTab("OP3", operazione03());
        tabbedPane.addTab("OP4", operazione04());
        tabbedPane.addTab("OP5", operazione05());
        tabbedPane.addTab("OP6", operazione06());
        tabbedPane.addTab("OP7", operazione07());
        tabbedPane.addTab("OP8", operazione08());
        tabbedPane.addTab("OP9", operazione09());
        tabbedPane.addTab("OP10", operazione10());
        tabbedPane.addTab("OP11", operazione11());
        tabbedPane.addTab("OP12", operazione12());
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

    public JButton getShowUsernameButton(){
        JButton submitShowUsername = new JButton("Elenco utenti");
        submitShowUsername.addActionListener(e -> {
            database.createConnection();
            String usernames = database.showUsers();
            database.closeConnection();
            console.setText(usernames);
        });

        return submitShowUsername;
    }

    public JButton getShowOpereButton(){
        JButton submitShowOpere = new JButton("Elenco opere");
        submitShowOpere.addActionListener(e -> {
            database.createConnection();
            String opere = database.showOpere();
            database.closeConnection();
            console.setText(opere);
        });

        return submitShowOpere;
    }

    public JPanel operazione01() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 01");
        JLabel label_descrizione = new JLabel("Inserimento di un film");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_opera = new JLabel("Dati film");
        label_opera.setFont( UIManager.getFont( "h2.font" ) );

        JLabel label_Durata = new JLabel("Durata");
        JTextField field_Durata = new JTextField(FIELD_SIZE_S);
        field_Durata.setText("00:00:00");

        JLabel label_titoloOpera = new JLabel("Titolo opera");
        JTextField field_titoloOpera = new JTextField(FIELD_SIZE_L);

        JLabel label_descrizioneFilm = new JLabel("Descrizione");
        JTextField field_descrizioneFilm = new JTextField(FIELD_SIZE_L + GAP_MID - 1);

        JLabel label_Locandina = new JLabel("Locandina");
        JTextField field_Locandina = new JTextField(FIELD_SIZE_L);

        JLabel label_dataUscita = new JLabel("Data uscita");
        JXDatePicker pickerDataUscita = new JXDatePicker ();
        pickerDataUscita.setDate (Calendar.getInstance ().getTime ());
        pickerDataUscita.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_Classificazione = new JLabel("Classificazione");
        JTextField field_Classificazione = new JTextField(FIELD_SIZE_M);

        JLabel label_Genere = new JLabel("Genere");
        JTextField field_Genere = new JTextField(FIELD_SIZE_L);

        //
        JLabel label_lavoratore = new JLabel("Dati membro crew");
        label_lavoratore.setFont( UIManager.getFont( "h2.font" ) );
        JLabel label_nome = new JLabel("Nome");
        JTextField field_nome = new JTextField(FIELD_SIZE_L);

        JLabel label_cognome = new JLabel("Cognome");
        JTextField field_cognome = new JTextField(FIELD_SIZE_L);

        JLabel label_immagine = new JLabel("Immagine");
        JTextField field_immagine = new JTextField(FIELD_SIZE_L);

        JLabel label_dataNascita = new JLabel("Data di nascita");
        JXDatePicker pickerDataNascita = new JXDatePicker ();
        pickerDataNascita.setDate (Calendar.getInstance ().getTime ());
        pickerDataNascita.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_dataMorte = new JLabel("Data di morte");
        JXDatePicker pickerDataMorte = new JXDatePicker ();
        pickerDataMorte.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_ruolo = new JLabel("Ruolo");
        JTextField field_ruolo = new JTextField(FIELD_SIZE_L);

        JButton submitShowOpere = getShowOpereButton();

        JButton submit = new JButton("Inserisci");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataUscita = "";
            String dataNascita = "";
            String dataMorte = "";

            if(pickerDataUscita.getDate() != null){
                dataUscita = desiredFormat.format(pickerDataUscita.getDate());
            }
            if(pickerDataNascita.getDate() != null){
                dataNascita = desiredFormat.format(pickerDataNascita.getDate());
            }
            if(pickerDataMorte.getDate() != null){
                dataMorte = desiredFormat.format(pickerDataMorte.getDate());
            }


            String result = null;

            if (field_Durata.getText().equals("") || field_titoloOpera.getText().equals("") || field_descrizioneFilm.getText().equals("") || field_Locandina.getText().equals("") || dataUscita.equals("") || field_Classificazione.getText().equals("") || field_Genere.getText().equals("") || dataNascita.equals("") || field_nome.getText().equals("") || field_cognome.getText().equals("") || field_immagine.getText().equals("") ||  field_titoloOpera.getText().equals("") ||  field_ruolo.getText().equals("")){
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.insertOpera(field_Durata.getText(), field_titoloOpera.getText(), field_descrizioneFilm.getText(), field_Locandina.getText(), dataUscita, field_Classificazione.getText(), field_Genere.getText(), field_nome.getText(), field_cognome.getText(), field_immagine.getText(), dataNascita, dataMorte, field_ruolo.getText());
                database.closeConnection();
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

        panel.add(label_opera);
        layout.putConstraint(SpringLayout.WEST, label_opera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_opera,GAP_MID,SpringLayout.SOUTH, label_descrizione);

        panel.add(label_Durata);
        panel.add(field_Durata);
        layout.putConstraint(SpringLayout.WEST, label_Durata,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_Durata,GAP_MID,SpringLayout.SOUTH, label_opera);
        layout.putConstraint(SpringLayout.WEST, field_Durata,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_Durata,GAP_SMALL,SpringLayout.SOUTH, label_Durata);

        panel.add(label_titoloOpera);
        panel.add(field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, label_titoloOpera,GAP_MID,SpringLayout.EAST, field_Durata);
        layout.putConstraint(SpringLayout.NORTH, label_titoloOpera,GAP_MID,SpringLayout.SOUTH, label_opera);
        layout.putConstraint(SpringLayout.WEST, field_titoloOpera,BORDER_EXT,SpringLayout.EAST, field_Durata);
        layout.putConstraint(SpringLayout.NORTH, field_titoloOpera,GAP_SMALL,SpringLayout.SOUTH, label_titoloOpera);

        panel.add(label_descrizioneFilm);
        panel.add(field_descrizioneFilm);
        layout.putConstraint(SpringLayout.WEST, label_descrizioneFilm,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizioneFilm,GAP_MID,SpringLayout.SOUTH, field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, field_descrizioneFilm,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_descrizioneFilm,GAP_SMALL,SpringLayout.SOUTH, label_descrizioneFilm);

        panel.add(label_Locandina);
        panel.add(field_Locandina);
        layout.putConstraint(SpringLayout.WEST, label_Locandina,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_Locandina,GAP_MID,SpringLayout.SOUTH, field_descrizioneFilm);
        layout.putConstraint(SpringLayout.WEST, field_Locandina,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_Locandina,GAP_SMALL,SpringLayout.SOUTH, label_Locandina);

        panel.add(label_dataUscita);
        panel.add(pickerDataUscita);
        layout.putConstraint(SpringLayout.WEST, label_dataUscita,GAP_MID,SpringLayout.EAST, field_Locandina);
        layout.putConstraint(SpringLayout.NORTH, label_dataUscita,GAP_MID,SpringLayout.SOUTH, field_descrizioneFilm);
        layout.putConstraint(SpringLayout.WEST, pickerDataUscita,GAP_MID,SpringLayout.EAST, field_Locandina);
        layout.putConstraint(SpringLayout.NORTH, pickerDataUscita,GAP_SMALL,SpringLayout.SOUTH, label_dataUscita);

        panel.add(label_Classificazione);
        panel.add(field_Classificazione);
        layout.putConstraint(SpringLayout.WEST, label_Classificazione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_Classificazione,GAP_MID,SpringLayout.SOUTH, pickerDataUscita);
        layout.putConstraint(SpringLayout.WEST, field_Classificazione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_Classificazione,GAP_SMALL,SpringLayout.SOUTH, label_Classificazione);
        
        panel.add(label_Genere);
        panel.add(field_Genere);
        layout.putConstraint(SpringLayout.WEST, label_Genere,GAP_MID,SpringLayout.EAST, field_Classificazione);
        layout.putConstraint(SpringLayout.NORTH, label_Genere,GAP_MID,SpringLayout.SOUTH, pickerDataUscita);
        layout.putConstraint(SpringLayout.WEST, field_Genere,GAP_MID,SpringLayout.EAST, field_Classificazione);
        layout.putConstraint(SpringLayout.NORTH, field_Genere,GAP_SMALL,SpringLayout.SOUTH, label_Genere);

        panel.add(label_lavoratore);
        layout.putConstraint(SpringLayout.WEST, label_lavoratore,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_lavoratore,GAP_MID,SpringLayout.SOUTH, field_Genere);

        panel.add(label_nome);
        panel.add(field_nome);
        layout.putConstraint(SpringLayout.WEST, label_nome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_nome,GAP_MID,SpringLayout.SOUTH, label_lavoratore);
        layout.putConstraint(SpringLayout.WEST, field_nome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_nome,GAP_SMALL,SpringLayout.SOUTH, label_nome);

        panel.add(label_cognome);
        panel.add(field_cognome);
        layout.putConstraint(SpringLayout.WEST, label_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_cognome,GAP_MID,SpringLayout.SOUTH, field_nome);
        layout.putConstraint(SpringLayout.WEST, field_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_cognome,GAP_SMALL,SpringLayout.SOUTH, label_cognome);

        panel.add(label_immagine);
        panel.add(field_immagine);
        layout.putConstraint(SpringLayout.WEST, label_immagine,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_immagine,GAP_MID,SpringLayout.SOUTH, field_cognome);
        layout.putConstraint(SpringLayout.WEST, field_immagine,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_immagine,GAP_SMALL,SpringLayout.SOUTH, label_immagine);

        panel.add(label_dataNascita);
        panel.add(pickerDataNascita);
        layout.putConstraint(SpringLayout.WEST, label_dataNascita,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_dataNascita,GAP_MID,SpringLayout.SOUTH, field_immagine);
        layout.putConstraint(SpringLayout.WEST, pickerDataNascita,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pickerDataNascita,GAP_SMALL,SpringLayout.SOUTH, label_dataNascita);

        panel.add(label_dataMorte);
        panel.add(pickerDataMorte);
        layout.putConstraint(SpringLayout.WEST, label_dataMorte,GAP_MID,SpringLayout.EAST, pickerDataNascita);
        layout.putConstraint(SpringLayout.NORTH, label_dataMorte,GAP_MID,SpringLayout.SOUTH, field_immagine);
        layout.putConstraint(SpringLayout.WEST, pickerDataMorte,GAP_MID,SpringLayout.EAST, pickerDataNascita);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMorte,GAP_SMALL,SpringLayout.SOUTH, label_dataMorte);

        panel.add(label_ruolo);
        panel.add(field_ruolo);
        layout.putConstraint(SpringLayout.WEST, label_ruolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_ruolo,GAP_MID,SpringLayout.SOUTH, pickerDataMorte);
        layout.putConstraint(SpringLayout.WEST, field_ruolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_ruolo,GAP_SMALL,SpringLayout.SOUTH, label_ruolo);

        panel.add(submitShowOpere);
        layout.putConstraint(SpringLayout.WEST, submitShowOpere,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitShowOpere,GAP_MID,SpringLayout.SOUTH, field_ruolo);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,GAP_MID,SpringLayout.EAST, submitShowOpere);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_ruolo);
        
        return panel;
    }

    public JPanel operazione02() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 02");
        JLabel label_descrizione = new JLabel("Inserimento di un lavoratore");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_nome = new JLabel("Nome");
        JTextField field_nome = new JTextField(FIELD_SIZE_L);

        JLabel label_cognome = new JLabel("Cognome");
        JTextField field_cognome = new JTextField(FIELD_SIZE_L);

        JLabel label_immagine = new JLabel("Immagine");
        JTextField field_immagine = new JTextField(FIELD_SIZE_L);

        JLabel label_dataNascita = new JLabel("Data nascita");
        JXDatePicker pickerDataNascita = new JXDatePicker ();
        pickerDataNascita.setDate (Calendar.getInstance ().getTime ());
        pickerDataNascita.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_dataMorte = new JLabel("Data morte");
        JXDatePicker pickerDataMorte = new JXDatePicker ();
        pickerDataMorte.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));

        JLabel label_titoloOpera = new JLabel("Titolo opera");
        JTextField field_titoloOpera = new JTextField(FIELD_SIZE_L);

        JLabel label_personaggio = new JLabel("personaggio");
        JTextField field_personaggio = new JTextField(FIELD_SIZE_L);

        JLabel label_ruolo = new JLabel("ruolo");
        JTextField field_ruolo = new JTextField(FIELD_SIZE_L);

        JButton submitShowOpere = getShowOpereButton();

        JButton submit = new JButton("Inserisci");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascita = "";
            String dataMorte = "";

            if(pickerDataNascita.getDate() != null){
                dataNascita = desiredFormat.format(pickerDataNascita.getDate());
            }
            if(pickerDataMorte.getDate() != null){
                dataMorte = desiredFormat.format(pickerDataMorte.getDate());
            }

            String result = null;

            if (dataNascita.equals("") || field_nome.getText().equals("") || field_cognome.getText().equals("") || field_immagine.getText().equals("") ||  field_titoloOpera.getText().equals("") || (field_personaggio.getText().equals("") && field_ruolo.getText().equals(""))){
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.insertLavoratore(field_nome.getText(), field_cognome.getText(), field_immagine.getText(), dataNascita, dataMorte, field_titoloOpera.getText(), field_personaggio.getText(), field_ruolo.getText());
                database.closeConnection();
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
        layout.putConstraint(SpringLayout.NORTH, label_nome,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_nome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_nome,GAP_SMALL,SpringLayout.SOUTH, label_nome);

        panel.add(label_cognome);
        panel.add(field_cognome);
        layout.putConstraint(SpringLayout.WEST, label_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_cognome,GAP_MID,SpringLayout.SOUTH, field_nome);
        layout.putConstraint(SpringLayout.WEST, field_cognome,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_cognome,GAP_SMALL,SpringLayout.SOUTH, label_cognome);

        panel.add(label_immagine);
        panel.add(field_immagine);
        layout.putConstraint(SpringLayout.WEST, label_immagine,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_immagine,GAP_MID,SpringLayout.SOUTH, field_cognome);
        layout.putConstraint(SpringLayout.WEST, field_immagine,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_immagine,GAP_SMALL,SpringLayout.SOUTH, label_immagine);

        panel.add(label_dataNascita);
        panel.add(pickerDataNascita);
        layout.putConstraint(SpringLayout.WEST, label_dataNascita,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_dataNascita,GAP_MID,SpringLayout.SOUTH, field_immagine);
        layout.putConstraint(SpringLayout.WEST, pickerDataNascita,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pickerDataNascita,GAP_SMALL,SpringLayout.SOUTH, label_dataNascita);

        panel.add(label_dataMorte);
        panel.add(pickerDataMorte);
        layout.putConstraint(SpringLayout.WEST, label_dataMorte,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_dataMorte,GAP_MID,SpringLayout.SOUTH, pickerDataNascita);
        layout.putConstraint(SpringLayout.WEST, pickerDataMorte,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMorte,GAP_SMALL,SpringLayout.SOUTH, label_dataMorte);

        panel.add(label_titoloOpera);
        panel.add(field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, label_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titoloOpera,GAP_MID,SpringLayout.SOUTH, pickerDataMorte);
        layout.putConstraint(SpringLayout.WEST, field_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_titoloOpera,GAP_SMALL,SpringLayout.SOUTH, label_titoloOpera);

        panel.add(label_personaggio);
        panel.add(field_personaggio);
        layout.putConstraint(SpringLayout.WEST, label_personaggio,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_personaggio,GAP_MID,SpringLayout.SOUTH, field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, field_personaggio,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_personaggio,GAP_SMALL,SpringLayout.SOUTH, label_personaggio);

        panel.add(label_ruolo);
        panel.add(field_ruolo);
        layout.putConstraint(SpringLayout.WEST, label_ruolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_ruolo,GAP_MID,SpringLayout.SOUTH, field_personaggio);
        layout.putConstraint(SpringLayout.WEST, field_ruolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_ruolo,GAP_SMALL,SpringLayout.SOUTH, label_ruolo);

        panel.add(submitShowOpere);
        layout.putConstraint(SpringLayout.WEST, submitShowOpere,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitShowOpere,GAP_MID,SpringLayout.SOUTH, field_ruolo);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, submitShowOpere);

        return panel;
    }

    public JPanel operazione03() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 03");
        JLabel label_descrizione = new JLabel("Inserimento di una recensione");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_username = new JLabel("Username");
        JTextField field_username = new JTextField(FIELD_SIZE_L);

        JLabel label_titoloOpera = new JLabel("Titolo opera");
        JTextField field_titoloOpera = new JTextField(FIELD_SIZE_L);
        /* 
        JXDatePicker pickerData = new JXDatePicker ();
        pickerData.setDate (Calendar.getInstance ().getTime ());
        pickerData.setFormats (new SimpleDateFormat ("dd/MM/yyyy"));
        */
        JLabel label_voto = new JLabel("Voto");
        JTextField field_voto = new JTextField(FIELD_SIZE_L);

        JLabel label_descrizioneRecensione = new JLabel("Descrizione");
        JTextField field_descrizioneRecensione = new JTextField(FIELD_SIZE_L);

        JLabel label_preferito = new JLabel("Preferito");
        JRadioButton preferitoSi = new JRadioButton("Si");
        preferitoSi.setActionCommand("true");
        JRadioButton preferitoNo = new JRadioButton("No");
        preferitoNo.setActionCommand("false");
        preferitoNo.setSelected(true);

        ButtonGroup preferitoGroup = new ButtonGroup();
        preferitoGroup.add(preferitoSi);
        preferitoGroup.add(preferitoNo);  

        JLabel label_spoiler = new JLabel("Spoiler");
        JRadioButton spoilerSi = new JRadioButton("Si");
        spoilerSi.setActionCommand("true");
        JRadioButton spoilerNo = new JRadioButton("No");
        spoilerNo.setActionCommand("false");
        spoilerNo.setSelected(true);

        ButtonGroup spoilerGroup = new ButtonGroup();
        spoilerGroup.add(spoilerSi);
        spoilerGroup.add(spoilerNo);

        JButton submitShowUsername = getShowUsernameButton();

        JButton submitShowOpere = getShowOpereButton();

        JButton submit = new JButton("Inserisci");
        submit.addActionListener(e -> {
            SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
            String data = desiredFormat.format(Calendar.getInstance ().getTime());
            String result = null;
            Boolean preferito = preferitoSi.isSelected();
            Boolean spoiler = spoilerSi.isSelected();

            if (field_username.getText().equals("") || field_titoloOpera.getText().equals("") || field_voto.getText().equals("") || field_descrizioneRecensione.getText().equals("") ) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.insertRecensione(field_username.getText(), field_titoloOpera.getText(), data, Float.parseFloat(field_voto.getText()), field_descrizioneRecensione.getText(), preferito, spoiler);
                database.closeConnection();
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

        panel.add(label_titoloOpera);
        panel.add(field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, label_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titoloOpera,GAP_MID,SpringLayout.SOUTH, field_username);
        layout.putConstraint(SpringLayout.WEST, field_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_titoloOpera,GAP_SMALL,SpringLayout.SOUTH, label_titoloOpera);

        panel.add(label_voto);
        panel.add(field_voto);
        layout.putConstraint(SpringLayout.WEST, label_voto,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_voto,GAP_MID,SpringLayout.SOUTH, field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, field_voto,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_voto,GAP_SMALL,SpringLayout.SOUTH, label_voto);

        panel.add(label_descrizioneRecensione);
        panel.add(field_descrizioneRecensione);
        layout.putConstraint(SpringLayout.WEST, label_descrizioneRecensione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizioneRecensione,GAP_MID,SpringLayout.SOUTH, field_voto);
        layout.putConstraint(SpringLayout.WEST, field_descrizioneRecensione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_descrizioneRecensione,GAP_SMALL,SpringLayout.SOUTH, label_descrizioneRecensione);

        panel.add(label_preferito);
        panel.add(preferitoSi);
        panel.add(preferitoNo);
        layout.putConstraint(SpringLayout.WEST, label_preferito,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_preferito,GAP_MID,SpringLayout.SOUTH, field_descrizioneRecensione);
        layout.putConstraint(SpringLayout.WEST, preferitoSi,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, preferitoSi,GAP_SMALL,SpringLayout.SOUTH, label_preferito);
        layout.putConstraint(SpringLayout.WEST, preferitoNo,40,SpringLayout.WEST, preferitoSi);
        layout.putConstraint(SpringLayout.NORTH, preferitoNo,GAP_SMALL,SpringLayout.SOUTH, label_preferito);


        panel.add(label_spoiler);
        panel.add(spoilerSi);
        panel.add(spoilerNo);
        layout.putConstraint(SpringLayout.WEST, label_spoiler,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_spoiler,GAP_MID,SpringLayout.SOUTH, preferitoSi);
        layout.putConstraint(SpringLayout.WEST, spoilerSi,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, spoilerSi,GAP_SMALL,SpringLayout.SOUTH, label_spoiler);
        layout.putConstraint(SpringLayout.WEST, spoilerNo,40,SpringLayout.WEST, spoilerSi);
        layout.putConstraint(SpringLayout.NORTH, spoilerNo,GAP_SMALL,SpringLayout.SOUTH, label_spoiler);

        panel.add(submitShowUsername);
        layout.putConstraint(SpringLayout.WEST, submitShowUsername,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitShowUsername,GAP_MID,SpringLayout.SOUTH, spoilerSi);

        panel.add(submitShowOpere);
        layout.putConstraint(SpringLayout.WEST, submitShowOpere,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitShowOpere,GAP_MID,SpringLayout.SOUTH, submitShowUsername);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, submitShowOpere);

        return panel;
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
        layout.putConstraint(SpringLayout.WEST, label_dataMax,100,SpringLayout.EAST, label_dataMin);
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
        layout.putConstraint(SpringLayout.WEST, label_dataMax,100,SpringLayout.EAST, label_dataMin);
        layout.putConstraint(SpringLayout.NORTH, label_dataMax,0,SpringLayout.NORTH, label_dataMin);
        layout.putConstraint(SpringLayout.WEST, pickerDataMax,0,SpringLayout.WEST, label_dataMax);
        layout.putConstraint(SpringLayout.NORTH, pickerDataMax,GAP_SMALL,SpringLayout.SOUTH, label_dataMax);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, pickerDataMin);

        return panel;
    }

    public JPanel operazione10() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 10");
        JLabel label_descrizione = new JLabel("Calcolare il voto medio di un'opera");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_titoloOpera = new JLabel("Titolo");
        JTextField field_titoloOpera = new JTextField(FIELD_SIZE_L);

        JButton submit = new JButton("Cerca");
        submit.addActionListener(e -> {
            String result;

            if (field_titoloOpera.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewVotoMedio(field_titoloOpera.getText());
                database.closeConnection();
            }
            System.out.println("Voto medio dell'opera:\n" + result);
            console.setText("Voto medio dell'opera:\n" + result);
        });
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);

        panel.add(label_titoloOpera);
        panel.add(field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, label_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titoloOpera,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_titoloOpera,GAP_SMALL,SpringLayout.SOUTH, label_titoloOpera);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, field_titoloOpera);

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

    public JPanel operazione12() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel label_titolo = new JLabel("Operazione 12");
        JLabel label_descrizione = new JLabel("Ordinare le recensioni per voto");
        label_titolo.setFont( UIManager.getFont( "h1.font" ) );
        label_descrizione.setFont( UIManager.getFont( "default.font" ) );

        JLabel label_titoloOpera = new JLabel("Titolo");
        JTextField field_titoloOpera = new JTextField(FIELD_SIZE_L);

        JLabel label_ordinamento = new JLabel("Ordinamento");
        JRadioButton ascendente = new JRadioButton("Ascendente");
        ascendente.setActionCommand("true");
        ascendente.setSelected(true);
        JRadioButton discendente = new JRadioButton("Discendente");
        discendente.setActionCommand("false");

        ButtonGroup preferitoGroup = new ButtonGroup();
        preferitoGroup.add(ascendente);
        preferitoGroup.add(discendente);  

        JButton submit = new JButton("Ordina");
        submit.addActionListener(e -> {
            String result;
            if (field_titoloOpera.getText().equals("")) {
                result = "Campo vuoto";
            } else {
                database.createConnection();
                result = database.viewRecensioniOrderedByVoto(field_titoloOpera.getText(), ascendente.isSelected());
                database.closeConnection();
            }
            System.out.println("Le recensioni ordinate sono:\n" + result);
            console.setText("Le recensioni ordinate sono:\n" + result);
        });
        panel.add(label_titolo);
        layout.putConstraint(SpringLayout.WEST, label_titolo,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titolo,BORDER_EXT, SpringLayout.NORTH, panel);
        panel.add(label_descrizione);
        layout.putConstraint(SpringLayout.WEST, label_descrizione,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_descrizione,GAP_MID, SpringLayout.SOUTH, label_titolo);
        
        panel.add(label_titoloOpera);
        panel.add(field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, label_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_titoloOpera,GAP_MID,SpringLayout.SOUTH, label_descrizione);
        layout.putConstraint(SpringLayout.WEST, field_titoloOpera,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field_titoloOpera,GAP_SMALL,SpringLayout.SOUTH, label_titoloOpera);

        panel.add(label_ordinamento);
        panel.add(ascendente);
        panel.add(discendente);
        layout.putConstraint(SpringLayout.WEST, label_ordinamento,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label_ordinamento,GAP_MID,SpringLayout.SOUTH, field_titoloOpera);
        layout.putConstraint(SpringLayout.WEST, ascendente,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ascendente,GAP_SMALL,SpringLayout.SOUTH, label_ordinamento);
        layout.putConstraint(SpringLayout.WEST, discendente,100,SpringLayout.WEST, ascendente);
        layout.putConstraint(SpringLayout.NORTH, discendente,GAP_SMALL,SpringLayout.SOUTH, label_ordinamento);

        panel.add(submit);
        layout.putConstraint(SpringLayout.WEST, submit,BORDER_EXT,SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submit,GAP_MID,SpringLayout.SOUTH, discendente);

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
