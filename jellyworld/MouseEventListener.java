package jellyworld;

public interface MouseEventListener {
    public boolean mouseClicked(int x, int y, boolean  left, boolean down);
    public boolean mouseMoved(int oldX, int oldY, int x, int y, boolean left, boolean right);
}
