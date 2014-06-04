package jellyworld;
import java.awt.*;
import java.util.*;

public class MyPoint implements Drawable, Entity{
    private Vector2 pos;
    private Vector2 velocity;
    private Vector2 gravity;
    private double mass;
    private int pointSize;

    private LinkedList<MyPoint> neighbors;
	public static LinkedList<MyPoint> Nodes = new LinkedList<MyPoint>();
	
    public MyPoint(Vector2 p){
	pos = p.clone();
	Nodes.add(this);
	World.addEntity(this);
	World.addDrawable(this);
	pointSize = 10;

	gravity = new Vector2(0,1);
	velocity = new Vector2(0,1);

	mass = 10;
    }
	
    public void update(float time){//@override Entity
	// update for gravity
	velocity.add(gravity);
	pos.add(velocity);
	// update for wall bounce
	if (pos.y >= JellyWorld.s.screen.c.getHeight() - (pointSize / 2)){
	    velocity.y *= -0.9;
	    pos.y = JellyWorld.s.screen.c.getHeight() - (pointSize / 2);
	}
    }

    public void draw(Graphics g){//@override Drawable
	g.setColor(Color.red);
	g.fillOval((int)(pos.x - (pointSize / 2)),(int)(pos.y - (pointSize / 2)), pointSize, pointSize);
    }

	public Vector2 getPos(){
		return pos.clone();
	}

	public boolean isDead(){return false;}//@override Entity
	public boolean isErased(){return false;}//@override Drawable
	public int getZOrder(){return 0;}//for now

	public LinkedList<MyPoint> getNodesWithin(double dist, Vector2 pos){
		LinkedList<MyPoint> temp = new LinkedList();
		for(MyPoint n : Nodes){
			if(n.getPos().distTo(pos) <= dist)
				temp.add(n);
		}
		return n;
	}
}