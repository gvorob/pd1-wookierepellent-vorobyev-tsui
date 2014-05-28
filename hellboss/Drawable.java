package hellboss;
import java.awt.image.BufferedImage;


public interface Drawable{
	public void draw(BufferedImage b);
	public int getZOrder();//0 is default, higher numbers are drawn last and go on top
}
