package jellyworld;

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

public class World{
	public static Mouse mouse;

	public static final int MODE_PLAY = 0;
	public static final int MODE_MENU = 1;

	public static int frames;
	public static float time;
	public static int fps;

	public static LinkedList<Entity> entities;
	public static LinkedList<Drawable> drawables;

	public static boolean wasmousedown;

	public static String mode;
	public static boolean DEBUG = false;
	public static int connectRange = 10;
	public static int toolMode = 0;


	public static void init(Mouse m)
	{
		mouse = m;
		startGame();
		wasmousedown = false;
	}


	private static void startGame()
	{
		entities = new LinkedList<Entity>();
		drawables = new LinkedList<Drawable>();
		mode = "play";
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

	public static void addPoint(Mouse m, boolean b){//adds a new point at current mouse location
		MyPoint p = new MyPoint(new Vector2(m.getX(),m.getY()), b,connectRange);
		//init things
	}
	public static void addOoze(Mouse m, boolean b){//adds a new point at current mouse location
		Ooze p = new Ooze(new Vector2(m.getX(),m.getY()), b,connectRange);
		//init things
	}



	public static void update(float time, Keyboard keys, Mouse m)//per-frame game updates
	{
		if (!m.getL()){
			wasmousedown = false;
		}

		if(keys.getKeyPressed(KeyEvent.VK_P)){
			if(mode == "pause")
				mode = "play";
			else if(mode == "play")
				mode = "pause";
		}
		if(keys.getKeyPressed(KeyEvent.VK_D)){DEBUG = !DEBUG;}
		if(keys.getKeyPressed(KeyEvent.VK_OPEN_BRACKET)){connectRange -= 10;}
		if(keys.getKeyPressed(KeyEvent.VK_CLOSE_BRACKET)){connectRange += 10;}
		if(connectRange < 1){connectRange = 1;}
		if(keys.getKeyPressed(KeyEvent.VK_EQUALS)){toolMode -= 1;}
		if(keys.getKeyPressed(KeyEvent.VK_MINUS)){toolMode += 1;}

		if(toolMode == -1){toolMode = 2;}
		if(toolMode == 3){toolMode = 0;}

		switch(toolMode){
			case 0:
				if(m.getL() && !wasmousedown){
					if(keys.getKey(KeyEvent.VK_SHIFT)) addPoint(m, true);
					else addPoint(m, false);
					wasmousedown = true;
				}

				break;
			case 1:
				if(m.getL() && !wasmousedown){
					if(keys.getKey(KeyEvent.VK_SHIFT)) addOoze(m, true);
					else addPoint(m, false);
					wasmousedown = true;
				}

				break;
			case 2:

				break;

		}

		if(mode == "play")
			updateWorld(time, keys, m);
	}

	public static String getToolString(){
		switch(toolMode){
			case 0:
				return "adding points";
			case 1:
				return "adding ooze";
			case 2:
				return "tool does nothing";
		}
		return "invalid toolmode";
	}
		


	/*
	   public static void addPoint(Mouse m, boolean b){//adds a new point at current mouse location
	   MyPoint p = new MyPoint(new Vector2(m.getX(),m.getY()), b, connectRange);
	   }
	 */
	public static void updateWorld(float time, Keyboard keys, Mouse m)
	{
		for(Entity e: entities){
			e.update1(time);
		}
		for(Entity e: entities){
			e.update2(time);
		}
		/*Vector2 sumVel = Vector2.Zero();
		  for(MyPoint mp : MyPoint.Nodes){
		  sumVel.add(mp.getVel());
		  }
		  Misc.prln(sumVel.toString());*/
		//todo
	}

	public static void draw(BufferedImage b)
	{
		Graphics2D g = b.createGraphics();
		drawWorld(g);
		g.setColor(Color.black);
		g.drawOval(mouse.getX() - connectRange,mouse.getY() - connectRange,connectRange * 2, connectRange * 2);
		if(mode == "pause"){g.drawString("PAUSED",5,17);}
		if(DEBUG){g.drawString("DEBUG MODE",5,17 + 14);}
		if(DEBUG){g.drawString(getToolString(),5,17 + 14 + 14);}
	}

	public static void drawWorld(Graphics2D g)
	{

		//Misc.prln("aasf");//Misc.prln is just a convenient shorthand i wrote for system.out.println
		//it doesnt work for everything though, peek inside the class
		for(Drawable d: drawables){
			d.draw(g,DEBUG);
		}
		//todo
	}

	public static void addEntity(Entity e){entities.add(e);}
	public static void addDrawable(Drawable e){drawables.add(e);}

}
