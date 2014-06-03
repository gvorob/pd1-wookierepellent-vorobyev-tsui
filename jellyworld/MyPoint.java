package jellyworld;
import java.awt.*;
import java.util.*;

public class MyPoint implements Drawable, Entity{

	public static LinkedList<MyPoint> Nodes = new LinkedList<MyPoint>();

	private Vector2 pos;
	
	public MyPoint(Vector2 p){
		pos = p.clone();
		World.addEntity(this);
		World.addDrawable(this);
		Nodes.add(this);
	}
	
	public void update(float time){//@override Entity
		
	}

	public void draw(Graphics g){//@override Drawable
		g.setColor(Color.red);
		g.fillOval((int)(pos.x - 5),(int)(pos.y - 5), 10, 10);
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
