package examples;

import application.NetworkPanel;
import examples.network.KeyBroadcaster;
import examples.network.KeyDisplayPanel;
import examples.network.ObservableKeyEntry;

import javax.swing.*;
import java.io.IOException;
import java.util.Observer;

/**
 * Created by jrob on 4/11/17.
 */
public class KeyBroadcastFrame extends JFrame {
  private JPanel panel;
  private ObservableKeyEntry keyListener;
  private KeyBroadcaster broadcaster;

  public KeyBroadcastFrame() {
    setTitle( "Single Buffer Example" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setVisible( true );
    setResizable( false );
    setFocusable( true );

    keyListener = new ObservableKeyEntry();

    try {
      broadcaster = new KeyBroadcaster( NetworkPanel.PORT );
    } catch( IOException exception ) {
      System.err.println( "Failed to establish connection" );
    }

    panel = new KeyDisplayPanel();
    this.addKeyListener( keyListener );

    keyListener.addObserver( (Observer) panel );
    keyListener.addObserver( broadcaster );

    this.add( panel );
    this.pack();
  }

  public static void main( String[] args ) {
    new KeyBroadcastFrame();
  }
}


