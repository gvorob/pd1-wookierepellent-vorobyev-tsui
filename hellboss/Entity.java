package hellboss;

public interface Entity{
	public void update(float time);
	public boolean isDead();//if true, will be removed from the entitylist before next tick
}
