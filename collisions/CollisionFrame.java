package collisions;

import javax.swing.*;

/**
 * Created by jrob on 4/18/17.
 */
public class CollisionFrame extends JFrame {
  public CollisionFrame() {
    setTitle( "Single Buffer Example" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false );

    CollisionPanel panel = new CollisionPanel();
    panel.setFocusable( true );

    add( panel );
    pack();

    setVisible( true );
  }

  public static void main( String[] args ) {
    new CollisionFrame();
  }
}
