package jellyworld;
import java.awt.*;
import java.util.*;

public class MyPoint implements Drawable, Entity{
    protected Vector2 pos;
    protected Vector2 velocity;
    protected Vector2 gravity;
    protected double mass;
    protected int pointSize;
    protected boolean isFixed;
    protected int constant;
    public int id;//used for traversing connected nodes
    protected LinkedList<Link> neighbors;
    public static LinkedList<MyPoint> Nodes = new LinkedList<MyPoint>();

    public MyPoint(Vector2 p, boolean fixed, double connectRange){
	pos = p.clone();
	constant = 400;
	pointSize = (int)(connectRange * 1.5);
	neighbors = new LinkedList<Link>();

	LinkedList<MyPoint> tempNeighbors = new LinkedList<MyPoint>(getNodesWithin(connectRange, this.pos));
	for (MyPoint q : tempNeighbors){
	    this.addLink(q);
	    q.addLink(this);

	}

	Nodes.add(this);
	World.addEntity(this);
	World.addDrawable(this);

	if (World.gravityOn) gravity = new Vector2(0,555);
	else gravity = Vector2.Zero();
	
	velocity = new Vector2(0,1);

	mass = 10;

	isFixed = fixed;
    }

    public void update1(float time){//@override Entity
	// update for net force
	Vector2 netForce = Vector2.Zero();
	Vector2 tempForce;
	for (Link l : neighbors){
	    tempForce = Vector2.vecSubt(l.other.getPos(),this.pos);
	    tempForce.setLength((float)(l.k * (tempForce.length() - l.len))); 
	    netForce.add(tempForce);
	    //Misc.prln("--" + tempForce.toString());
	}
	netForce.add(gravity);
	velocity.scaleAndAdd(time,netForce);
	velocity.vecMult(0.98f);
	if (isFixed) velocity = Vector2.Zero();
    }

    public void update2(float time){

	pos.scaleAndAdd(time,velocity);

	// update for wall bounce
	if (pos.y >= JellyWorld.s.screen.c.getHeight() - (pointSize / 2)){
	    velocity.y *= -.90;
	    pos.y = JellyWorld.s.screen.c.getHeight() - (pointSize / 2);
	}
    }

    public void draw(Graphics g, boolean debug){//@override Drawable
	g.setColor(Color.red);
	g.fillOval((int)(pos.x - (pointSize / 2)),(int)(pos.y - (pointSize / 2)), pointSize, pointSize);

	if(debug){
	    g.setColor(Color.black);
	    for (Link l : neighbors){
		g.drawLine((int) this.pos.x, (int)this.pos.y, (int)l.other.getPos().x, (int)l.other.getPos().y);
	    }
	}
    }

    public static void numberPoints(){
	int count = 0;
	for(MyPoint m : Nodes){
	    m.id = count;
	    count++;
	}
    }

    public Vector2 getPos(){
	return pos.clone();
    }
    public Vector2 getVel(){return velocity.clone();}

    public boolean isDead(){return false;}//@override Entity
    public boolean isErased(){return false;}//@override Drawable
    public int getZOrder(){return 0;}//for now


    public static LinkedList<MyPoint> getNodesWithin(double dist, Vector2 pos){
	LinkedList<MyPoint> temp = new LinkedList<MyPoint>();
	for(MyPoint n : Nodes){
	    if(n.getPos().distTo(pos) <= dist)
		temp.add(n);
	}
	return temp;
    }

    public void addLink(MyPoint p){
	neighbors.add(new Link(constant, this.pos.distTo(p.getPos()), p));
    }
    
    public void switchGravity(){
    	if (gravity.length() != 0){
    	 	gravity = Vector2.Zero();
    	} else {
    		gravity = new Vector2(0,555);
    	}
    }
    
    public void removeNeighbor(MyPoint other){
	Link temp = new Link(0,0,other);
	for (Link l: neighbors){
	    if (l.other.equals(other)){
		temp = l;
	    }
	}
	neighbors.remove(temp);
    }
}
