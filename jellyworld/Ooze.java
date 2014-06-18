package jellyworld;
import java.awt.*;
import java.util.*;

public class Ooze extends MyPoint{
	private double connectRange;
	private double breakLength = 1.2;//multiplier of relaxed length at which it breaks

	public Ooze (Vector2 p, boolean fixed, double connectRange){
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

	public Vector2 getSpringForce(Link l){
		Vector2 tempForce = Vector2.vecSubt(l.other.getPos(),this.pos);

		Vector2 relVel = Vector2.vecSubt(this.velocity, l.other.getVel());
		Vector2 dir = tempForce.clone();
		dir.setLength(1);
		dir.setLength(Vector2.dotProd(dir,relVel));
		relVel.vecSubt(dir);
		relVel.setLength(relVel.length() * relVel.length() * -1 * 1/10);


		float length = tempForce.length();
		float ratio = (float)(tempForce.length() - l.len);
		if(ratio > 0){
			ratio = (float)(ratio+1)/(ratio * ratio + 1); 
		}
		tempForce.setLength((float)(l.k * ratio)); 
		tempForce.vecAdd(relVel);
		return tempForce;
		
	}
	
	public void draw(Graphics g, boolean debug){//@override Drawable
	g.setColor(Color.green);
	g.fillOval((int)(pos.x - (pointSize / 2)),(int)(pos.y - (pointSize / 2)), pointSize, pointSize);

	if(debug){
	    g.setColor(Color.black);
	    for (Link l : neighbors){
		g.drawLine((int) this.pos.x, (int)this.pos.y, (int)l.other.getPos().x, (int)l.other.getPos().y);
	    }
	}
    }
}
