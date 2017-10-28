package collisions;

import java.awt.*;

public class Collidable implements Paintable {
  private final int SIDE = 50;

  private Rectangle rectangle;
  private Color color;

  public Collidable( int x, int y, Color color ) {
    this.rectangle = new Rectangle( x, y, SIDE, SIDE );
    this.color = color;
  }

  public void moveLeft() {
    rectangle.setLocation( rectangle.x - 10, rectangle.y );
  }

  public void moveRight() {
    rectangle.setLocation( rectangle.x + 10, rectangle.y );
  }

  public void moveUp() {
    rectangle.setLocation( rectangle.x, rectangle.y - 10 );
  }

  public void moveDown() {
    rectangle.setLocation( rectangle.x, rectangle.y + 10 );
  }

  public boolean collides( Collidable other ) {
    return rectangle.intersects( other.rectangle );
  }

  @Override
  public void repaint( Graphics graphics ) {
    Graphics2D g2d = (Graphics2D) graphics.create();

    g2d.setColor( color );
    g2d.drawRect( rectangle.x, rectangle.y, SIDE, SIDE );

    Color bg = new Color( color.getRed(), color.getGreen(), color.getBlue(), 100 );
    g2d.setColor( bg );
    g2d.fillRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );

    g2d.dispose();
  }
}
