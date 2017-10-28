package examples.network;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

/**
 * Created by jrob on 4/11/17.
 */
public class ObservableKeyEntry extends Observable implements KeyListener {
  private int lastKey;
  private String lastKeyDescription;

  public int getLastKey() {
    return lastKey;
  }

  public String getLastKeyDescription() {
    return lastKeyDescription;
  }

  @Override
  public void keyTyped( KeyEvent e ) {

  }

  @Override
  public void keyPressed( KeyEvent e ) {
    System.out.println( "Received key " + e.getKeyCode() );
    this.lastKey = e.getKeyCode();

    switch( e.getKeyCode() ) {
      case KeyEvent.VK_LEFT:
        this.lastKeyDescription = "LEFT";
        break;
      case KeyEvent.VK_RIGHT:
        this.lastKeyDescription = "RIGHT";
        break;
      case KeyEvent.VK_UP:
        this.lastKeyDescription = "UP";
        break;
      case KeyEvent.VK_DOWN:
        this.lastKeyDescription = "DOWN";
        break;
    }

    this.setChanged();
    this.notifyObservers();
  }

  @Override
  public void keyReleased( KeyEvent e ) {

  }
}
