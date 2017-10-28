package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by jrob on 4/11/17.
 */
public class Sprite {
  private int tileSize;
  private String spriteFile;

  private BufferedImage[] images;

  public Sprite( String spriteFile, int tileSize ) throws IOException {
    this.spriteFile = spriteFile;
    this.tileSize = tileSize;

    this.loadImages();
  }

  private void loadImages() throws IOException {
    BufferedImage image = ImageIO.read( new File( spriteFile ));

    this.images = new BufferedImage[ image.getWidth() / tileSize ];

    for( int index = 0; index < this.images.length; index++ ) {
      this.images[ index ] = image.getSubimage(
          index * this.tileSize, 0, this.tileSize, this.tileSize
      );
    }
  }

  public BufferedImage getFrame( int frame ) {
    return this.images[ frame ];
  }

  public int frameCount() {
    return this.images.length;
  }
}
