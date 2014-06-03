package jellyworld;
import java.awt.image.BufferedImage;
import java.awt.*;


public interface Drawable{
	public void draw(Graphics g);
	public int getZOrder();//0 is default, higher numbers are drawn last and go on top
	public boolean isErased();//returns true if needs to be deleted

}
