package test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TestWorld extends JPanel implements Observer {
  public static final int WIDTH = 640;
  public static final int HEIGHT = 640;

  private GameClock clock;

  private Dimension dimension;

  private ArrayList< Animation > animations;

  public TestWorld( Animation[] animations ) {
    this.dimension = new Dimension( WIDTH, HEIGHT );
    this.clock = new GameClock();


    this.clock.addObserver( this );

    this.animations = new ArrayList<>();

    for( Animation animation : animations ) {
      this.clock.addObserver( animation );
      this.animations.add( animation );
    }

    new Thread( this.clock ).start();
  }

  @Override
  public Dimension getPreferredSize() {
    return this.dimension;
  }

  @Override
  public void update(Observable o, Object arg) {
    this.repaint();
  }

  @Override
  public void paintComponent( Graphics graphics ) {
    super.paintComponent( graphics );

    for( Animation animation : animations ) {
      if( animation.isCompleted() ) {
        animations.remove( animation );
      } else {
        animation.repaint(graphics);
      }
    }
  }
}
