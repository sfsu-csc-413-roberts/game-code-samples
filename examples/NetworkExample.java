package examples;

import application.GameFrame;
import application.NetworkPanel;

/**
 * Created by jrob on 4/11/17.
 */
public class NetworkExample {
  public static void main( String[] args ) {
    new GameFrame( new NetworkPanel() );
  }
}
