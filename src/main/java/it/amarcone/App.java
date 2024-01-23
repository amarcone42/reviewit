package it.amarcone;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.SystemInfo;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class App {
    public static void main( String[] args ) {

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                FlatLaf.registerCustomDefaultsSource( "it.amarcone.themes" );
                FlatMacDarkLaf.setup();

                if( SystemInfo.isLinux ) {
                    // enable custom window decorations
                    JFrame.setDefaultLookAndFeelDecorated( true );
                    JDialog.setDefaultLookAndFeelDecorated( true );
                }
                new Dashboard();
            }
        });
    }
}
