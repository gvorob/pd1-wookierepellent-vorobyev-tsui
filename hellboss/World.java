/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellboss;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

/**
 *
 * @author George Vorobyev <quaffle97@gmail.com>
 */
public class World{
    public static Mouse mouse;
    
    public static final int MODE_PLAY = 0;
    public static final int MODE_MENU = 1;
    
    public static int frames;
    public static float time;
    public static int fps;

	public static LinkedList<Entity> entities;
	public static LinkedList<Drawable> drawables;
    
    public static void init(Mouse m)
    {
        mouse = m;
        startGame();
    }
    
    private static void startGame()
    {
		entities = new LinkedList<Entity>();
		drawables = new LinkedList<Drawable>();
	    //init things
    }
    
    private static void loadLevel(String fileName)
    {
	    //todo
    }
    
    private static void saveLevel()
    {
	    //todo
    }
    
    public static void update(float time, Keyboard keys, Mouse m)//per-frame game updates
    {
            updateWorld(time, keys, m);
    }
    
    public static void updateWorld(float time, Keyboard keys, Mouse m)
    {
		for(Entity e: entities){
			e.update(time);
		}
	    //todo
    }
    
    public static void draw(BufferedImage b)
    {
        drawWorld(b);
         
    }
    
    public static void drawWorld(BufferedImage b)
    {
        
		Graphics2D g = b.createGraphics();
		//Misc.prln("aasf");//Misc.prln is just a convenient shorthand i wrote for system.out.println
		//it doesnt work for everything though, peek inside the class
		for(Drawable d: drawables){
			d.draw(g);
		}
	    //todo
    }

	public static void addEntity(Entity e){entities.add(e);}
	public static void addDrawable(Drawable e){drawables.add(e);}

}
