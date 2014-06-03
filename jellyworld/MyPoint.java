package jellyworld;
import java.awt.*;

public class MyPoint implements Drawable, Entity{
	private Vector2 pos;
	
	public MyPoint(Vector2 p){
		pos = p.clone();
		World.addEntity(this);
		World.addDrawable(this);
	}
	
	public void update(float time){//@override Entity
		
	}

	public void draw(Graphics g){//@override Drawable
		g.setColor(Color.red);
		g.fillOval((int)(pos.x - 5),(int)(pos.y - 5), 10, 10);
	}

	public boolean isDead(){return false;}//@override Entity
	public boolean isErased(){return false;}//@override Drawable
	public int getZOrder(){return 0;}//for now
}
