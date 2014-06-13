package jellyworld;
import java.awt.*;
import java.util.*;

public class Ooze extends MyPoint{

    public Ooze (Vector2 p, boolean fixed, double connectRange){
	super(p, fixed,connectRange);
    }

    public void update1(float time){//@override Entity
	Vector2 tempForce;
	LinkedList<MyPoint> temp = new LinkedList<MyPoint>();
	for (Link l : neighbors){
	    tempForce = Vector2.vecSubt(l.other.getPos(), this.pos);
	    tempForce.setLength((float)(l.k * (tempForce.length() - l.len)));
	    if (tempForce.length() > 150){
		temp.add(l.other);
	    }
	}
	for (MyPoint p : temp){
	    p.removeNeighbor(this);
	    this.removeNeighbor(p);
	}
	super.update1(time);
    }
}