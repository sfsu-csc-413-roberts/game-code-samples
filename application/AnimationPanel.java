package application;

import graphics.Animation;
import graphics.GameObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jrob on 4/9/17.
 */
public abstract class AnimationPanel extends JPanel implements Runnable {
  protected final int WIDTH = 640;
  protected final int HEIGHT = 640;
  protected final int STEP = 10;
  protected final String BACKGROUND_IMAGE = "resources/Background.png";
  protected final String TANK_IMAGE = "resources/Tank_grey_basic.png";

  protected Dimension dimension;

  protected GameObject tank;
  protected GameObject background;

  protected ArrayList< Animation > animations;

  public AnimationPanel() {
    try {
      this.tank = new GameObject( TANK_IMAGE );
      this.background = new GameObject( BACKGROUND_IMAGE );
    } catch( IOException exception ) {
      System.err.println( "Failed to load sprite." );
      exception.printStackTrace();
    }

    this.animations = new ArrayList<>();
    this.dimension = new Dimension( WIDTH, HEIGHT );
  }

  @Override
  public Dimension getPreferredSize() {
    return this.dimension;
  }

  @Override
  public void paintComponent( Graphics graphics ) {
    super.paintComponent( graphics );

    for( int x = 0; x < WIDTH; x += background.getWidth() ) {
      for( int y = 0; y < HEIGHT; y+= background.getHeight() ) {
        background.setX( x );
        background.setY( y );
        background.repaint( graphics );
      }
    }

    Animation animation;

    for( int counter = 0; counter < animations.size(); counter++ ) {
      animation = animations.get( counter );

      if( animation.isStopped() ) {
        animations.remove( counter );
      } else {
        animation.repaint( graphics );
      }
    }

    tank.repaint( graphics );
  }

  protected void addAnimation( Animation animation ) {
    animations.add( animation );
  }
}
