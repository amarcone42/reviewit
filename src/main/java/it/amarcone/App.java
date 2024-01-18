package it.amarcone;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class App 
{
    public static void main( String[] args )
    {

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {}
                new Dashboard();
            }
        });
    }
}
