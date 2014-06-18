package jellyworld;
import java.awt.*;
import java.util.*;

public class Node extends MyPoint{
	private double connectRange;
	private double breakLength = 1.2;//multiplier of relaxed length at which it breaks

	public Node (Vector2 p, boolean fixed, double connectRange){
		super(p, fixed,connectRange);
		this.connectRange = connectRange;
	}

	public void update1(float time){//@override Entity
		Vector2 tempForce;
		LinkedList<MyPoint> temp = new LinkedList<MyPoint>();
		for (Link l : neighbors){
			tempForce = Vector2.vecSubt(l.other.getPos(), this.pos);
			if (tempForce.length() > l.len * breakLength){
				temp.add(l.other);
			}
		}
		for (MyPoint p : temp){
			p.removeNeighbor(this);
			this.removeNeighbor(p);
		}

		boolean existing = false;
		for (MyPoint p : MyPoint.getNodesWithin(connectRange * 0.75,this.getPos())){
			if(p.equals(this))break;
			existing = false;
			for (Link l : neighbors){
				if(l.other.equals(p)){
					existing = true;
					break;
				}
			}	
			if (!existing){
				addLink(p);
				p.addLink(this);
			}
		}
		super.update1(time);
	}
}
