package application;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jrob on 4/11/17.
 */
public class NetworkPanel extends AnimationPanel {
  public static final int PORT = 9191;

  private BufferedReader reader;

  public NetworkPanel() {
    super();

    try {
      ServerSocket server = new ServerSocket( PORT );

      System.out.println( "Waiting for connection" );
      Socket connection = server.accept();
      System.out.println( "Accepted connection" );

      reader = new BufferedReader(
        new InputStreamReader( connection.getInputStream() )
      );
    } catch( IOException exception ) {
      exception.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      int input;

      while(( input = reader.read() ) != -1 ) {
        updateTankPosition( input );
      }
    } catch( IOException exception ) {
      exception.printStackTrace();
    }
  }

  private void updateTankPosition( int keyCode ) {
    switch( keyCode ) {
      case KeyEvent.VK_LEFT:
        tank.setX(( tank.getX() - STEP ) % WIDTH );
        break;
      case KeyEvent.VK_RIGHT:
        tank.setX(( tank.getX() + STEP ) % WIDTH );
        break;
      case KeyEvent.VK_UP:
        tank.setY(( tank.getY() - STEP ) % HEIGHT );
        break;
      case KeyEvent.VK_DOWN:
        tank.setY(( tank.getY() + STEP ) % HEIGHT );
        break;
    }

    this.repaint();
  }
}
