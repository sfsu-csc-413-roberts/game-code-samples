package test;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Animation implements Observer {
  protected Sprite sprite;

  private int x;
  private int y;
  protected int currentFrame;

  protected boolean completed;

  public Animation() {
  }

  public Animation( Sprite sprite, int x, int y ) {
    this.sprite = sprite;
    this.x = x;
    this.y = y;
    this.currentFrame = 0;
    this.completed = false;
  }

  public boolean isCompleted() {
    return this.completed;
  }

  @Override
  public void update(Observable o, Object arg) {
    currentFrame = ( currentFrame + 1 ) % this.sprite.frameCount();
    x = ( x + 1 ) % TestWorld.WIDTH;
    y = ( y + 1 ) % TestWorld.HEIGHT;
  }

  public void repaint( Graphics graphics ) {
    graphics.drawImage(
      this.sprite.getFrame( currentFrame ),
      x, y, null
    );
  }
}
