package test;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class Explosion extends Animation {
  private int frameCounter;

  public Explosion() throws IOException {
    super(
      new Sprite( "resources" + File.pathSeparator + "Explosion_small_strip6.png", 32 ),
      100,
      100
    );

    this.frameCounter = 0;
  }

  @Override
  public void update(Observable o, Object arg) {
    this.frameCounter++;

    if( this.frameCounter % 5 == 0 ) {
      currentFrame = (currentFrame + 1) % this.sprite.frameCount();

      if( currentFrame == 0 && frameCounter > 0 ) {
        o.deleteObserver( this );
        this.completed = true;
      }
    }
  }
}
