package application;

import java.awt.*;

public class SimpleAnimationPanel extends AnimationPanel {
  @Override
  public void run() {
    while( true ) {
      tank.setX(( tank.getX() + STEP ) % WIDTH );
      tank.setY(( tank.getY() + STEP ) % HEIGHT );

      this.repaint();

      try {
        Thread.sleep( 10 );
      } catch ( InterruptedException interrupted ) {

      }
    }
  }
}
