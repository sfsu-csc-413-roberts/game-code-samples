package collisions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CollisionPanel extends JPanel implements KeyListener {
  private Collidable red;
  private Collidable blue;

  private CollidablePolygon green;
  private CollidablePolygon cyan;

  public CollisionPanel() {
    red = new Collidable( 50, 50,Color.red );
    blue = new Collidable( 80, 80, Color.blue );

    green = new CollidablePolygon( 200, 200, Color.green );
    cyan = new CollidablePolygon( 240, 240, Color.cyan );

    this.addKeyListener( this );
    this.setFocusable( true );
  }

  @Override
  public void paintComponent( Graphics graphics ) {
    red.repaint( graphics );
    blue.repaint( graphics );

    String message = blue.collides( red ) ? "YES" : "NO";
    graphics.drawString( message, 20, 20 );

    green.repaint( graphics );
    cyan.repaint( graphics );

    String polyMessage = green.collides( cyan ) ? "YES" : "NO";
    graphics.drawString( polyMessage, 20, 400 );
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension( 500, 500 );
  }

  @Override
  public void keyTyped( KeyEvent e ) {
  }

  @Override
  public void keyPressed( KeyEvent e ) {
    switch ( e.getKeyCode() ) {
      case KeyEvent.VK_LEFT:
        red.moveLeft();
        break;
      case KeyEvent.VK_RIGHT:
        red.moveRight();
        break;
      case KeyEvent.VK_UP:
        red.moveUp();
        break;
      case KeyEvent.VK_DOWN:
        red.moveDown();
        break;
      case KeyEvent.VK_A:
        green.moveLeft();
        break;
      case KeyEvent.VK_D:
        green.moveRight();
        break;
      case KeyEvent.VK_W:
        green.moveUp();
        break;
      case KeyEvent.VK_S:
        green.moveDown();
        break;
      case KeyEvent.VK_Q:
        green.rotateLeft();
        break;
      case KeyEvent.VK_E:
        green.rotateRight();
        break;
    }

    repaint();
  }

  @Override
  public void keyReleased( KeyEvent e ) {
  }
}