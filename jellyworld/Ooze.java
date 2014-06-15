package jellyworld;
import java.awt.*;
import java.util.*;

public class Ooze extends MyPoint{
	private double connectRange;
	
    public Ooze (Vector2 p, boolean fixed, double connectRange){
	super(p, fixed,connectRange);
	this.connectRange = connectRange;
    }

    public void update1(float time){//@override Entity
	Vector2 tempForce;
	LinkedList<MyPoint> temp = new LinkedList<MyPoint>();
	for (Link l : neighbors){
	    tempForce = Vector2.vecSubt(l.other.getPos(), this.pos);
	    tempForce.setLength((float)(l.k * (tempForce.length() - l.len)));
	    if (tempForce.length() > connectRange){
		temp.add(l.other);
	    }
	}
	for (MyPoint p : temp){
	    p.removeNeighbor(this);
	    this.removeNeighbor(p);
	}
	
	Link temp2;
	boolean existing = false;
	for (MyPoint p : MyPoint.getNodesWithin(connectRange * 0.75,this.getPos())){
		temp2 = new Link(constant, this.pos.distTo(p.getPos()), p);
		existing = false;
		for (Link l : neighbors){
			if(l.equals(temp2)) existing = true;
		}	
		if (!existing) addLink(p);
	}
	super.update1(time);
    }
}