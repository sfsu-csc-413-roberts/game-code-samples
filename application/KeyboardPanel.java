package application;

import graphics.Animation;
import graphics.Sprite;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by jrob on 4/10/17.
 */
public class KeyboardPanel extends AnimationPanel implements KeyListener {
  private Sprite explosion;

  public KeyboardPanel() {
    super();

    this.addKeyListener( this );
    this.setFocusable( true );

    try {
      this.explosion = new Sprite( "resources" + File.pathSeparator + "Explosion_small_strip6.png", 32 );
    } catch( IOException exception ) {
      exception.printStackTrace();
    }
  }

  @Override
  public void run() {

  }

  @Override
  public void keyPressed( KeyEvent e ) {
    switch( e.getKeyCode() ) {
      case KeyEvent.VK_LEFT:
        tank.setX(( tank.getX() - STEP ) % WIDTH );
        break;
      case KeyEvent.VK_RIGHT:
        tank.setX(( tank.getX() + STEP ) % WIDTH );
        break;
      case KeyEvent.VK_UP:
        tank.setY(( tank.getY() - STEP ) % HEIGHT );
        break;
      case KeyEvent.VK_DOWN:
        tank.setY(( tank.getY() + STEP ) % HEIGHT );
        break;
      case KeyEvent.VK_F:
        addAnimation( new Animation( this.explosion, tank.getX(), tank.getY(), 3, false, "Explosion") );
        break;
    }

    this.repaint();
  }

  @Override
  public void keyTyped( KeyEvent e ) {

  }

  @Override
  public void keyReleased( KeyEvent e ) {

  }
}
