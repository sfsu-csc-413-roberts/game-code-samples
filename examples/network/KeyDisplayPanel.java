package examples.network;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jrob on 4/11/17.
 */
public class KeyDisplayPanel extends JPanel implements Observer {
  private String lastKey;

  public KeyDisplayPanel() {
    lastKey = "Press Keys";
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension( 200, 200 );
  }

  @Override
  public void update( Observable o, Object arg ) {
    ObservableKeyEntry observable = (ObservableKeyEntry) o;

    System.out.println( "Observed " + observable.getLastKeyDescription() + " in KeyDisplayPanel" );
    lastKey = observable.getLastKeyDescription();

    this.repaint();
  }

  @Override
  public void paintComponent( Graphics graphics ) {
    super.paintComponent( graphics );

    graphics.drawString( lastKey, 0, 75 );
  }
}