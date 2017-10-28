package test;

import javax.swing.*;
import java.io.IOException;

public class TestFrame extends JFrame {
  private final String SPRITE = "resources/Shell_heavy_strip60.png";

  public TestFrame() throws IOException {
    setTitle( "test" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    Animation[] animations = new Animation[ 11 ];

    for( int i = 0; i < 10; i++ ) {
      animations[ i ] = new Animation( new Sprite( SPRITE, 24 ), i*20, i* 20);
    }
    animations[ 10 ] = new Explosion();

    add(
      new TestWorld( animations )
    );

    pack();

    setVisible( true );
    setFocusable( true );
    setResizable( false );
  }

  public static void main( String[] args ) {
    try {
      new TestFrame();
    } catch( IOException e ) {
      e.printStackTrace();
    }
  }
}
