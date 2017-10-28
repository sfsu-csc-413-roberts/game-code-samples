package collisions;

import java.awt.*;
import java.awt.geom.Area;

/**
 * Created by jrob on 4/18/17.
 */
public class CollidablePolygon implements Paintable {
  private final int SIDE = 50;

  private Polygon polygon;
  private int[] xPoints;
  private int[] yPoints;

  private Point center;
  private int angle;

  private Color color;

  public CollidablePolygon( int x, int y, Color color ) {
    xPoints = new int[]{ x, x + SIDE, x + SIDE, x };
    yPoints = new int[]{ y, y, y + SIDE, y + SIDE };
    polygon = new Polygon( xPoints, yPoints, 4 );
    center = new Point( x + SIDE / 2, y + SIDE / 2 );
    angle = 0;

    this.color = color;
  }

  public void moveLeft() {
    polygon.translate( -5, 0 );

    for( int i = 0; i < 4; i++ ) {
      xPoints[ i ] -= 5;
    }

    updateCenter();
  }

  public void moveRight() {
    polygon.translate( 5, 0 );

    for( int i = 0; i < 4; i++ ) {
      xPoints[ i ] += 5;
    }

    updateCenter();
  }

  public void moveUp() {
    polygon.translate( 0, -5 );

    for( int i = 0; i < 4; i++ ) {
      yPoints[ i ] -= 5;
    }

    updateCenter();
  }

  public void moveDown() {
    polygon.translate( 0, 5 );

    for( int i = 0; i < 4; i++ ) {
      yPoints[ i ] += 5;
    }

    updateCenter();
  }

  private void updateCenter() {
    double x = 0;
    double y = 0;

    for( int i = 0; i < 4; i++ ) {
      x += xPoints[ i ];
      y += yPoints[ i ];
    }

    center = new Point( (int)( x / 4 ), (int)( y / 4 ));
  }

  public void rotateLeft() {
    angle -= 1;
    rotatePoints();
  }

  public void rotateRight() {
    angle += 1;
    rotatePoints();
  }

  private void rotatePoints() {
    int[] newXPoints = new int[ 4 ];
    int[] newYPoints = new int[ 4 ];

    for( int i = 0; i < 4; i++ ) {
      Point p = rotatePoint( xPoints[ i ], yPoints[ i ] );
      newXPoints[ i ] = p.x;
      newYPoints[ i ] = p.y;
    }

    polygon = new Polygon( newXPoints, newYPoints, 4 );
  }

  private Point rotatePoint( int x, int y ) {
    double x1 = x - center.x;
    double y1 = y - center.y;

    double temp_x1 = x1 * Math.cos( angle ) - y1 * Math.sin( angle );
    double temp_y1 = x1 * Math.sin( angle ) + y1 * Math.cos( angle );

    return new Point( (int)( temp_x1 + center.x ), (int)( temp_y1 + center.y ));
  }

  public boolean collides( CollidablePolygon other ) {
    Area area = new Area( polygon );
    area.intersect( new Area( other.polygon ));

    return ! area.isEmpty();
  }

  @Override
  public void repaint( Graphics graphics ) {
    Graphics2D g2d = (Graphics2D) graphics.create();

    g2d.setColor( color );
    g2d.drawPolygon( polygon );

    Color bg = new Color( color.getRed(), color.getGreen(), color.getBlue(), 100 );
    g2d.setColor( bg );
    g2d.fillPolygon( polygon );

    g2d.setColor( Color.black );
    g2d.drawOval( center.x, center.y, 3, 3 );

    g2d.dispose();
  }
}
