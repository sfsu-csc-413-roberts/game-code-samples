package graphics;

import java.awt.*;

/**
 * Created by jrob on 4/11/17.
 */
public class Animation {
  private Sprite sprite;

  private int frameCount;
  private int frameDelay;
  private int currentFrame;
  private int duration;

  private int x;
  private int y;

  private boolean loop;
  private boolean stop;
  private String description;

  public Animation( Sprite sprite, int x, int y, int frameDelay, boolean loop, String description ) {
    this.sprite = sprite;
    this.x = x;
    this.y = y;
    this.frameCount = 0;
    this.frameDelay = frameDelay;
    this.currentFrame = 0;
    this.loop = loop;
    this.stop = false;
    this.description = description;
    this.duration = 0;
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isStopped() {
    return this.stop;
  }

  public int totalTime() {
    return this.frameDelay * sprite.frameCount();
  }

  public void repaint( Graphics graphics ) {
    if( ! stop ) {
      duration++;
      frameCount++;

      if ( frameCount > frameDelay ) {
        frameCount = 0;
        stop = ( duration > this.totalTime() ) && ! loop;
        currentFrame = ( currentFrame + 1 ) % sprite.frameCount();
      }

      graphics.drawImage(
        sprite.getFrame( currentFrame ),
        x, y,
        null
      );
    }
  }
}
