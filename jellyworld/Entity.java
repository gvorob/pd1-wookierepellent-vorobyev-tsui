package jellyworld;

public interface Entity{
	public void update1(float time);//figure out accelerations
	public void update1b(float time);//do velocity
	public void update2(float time);//do the position
	
	public boolean isDead();//if true, will be removed from the entitylist before next tick
}
