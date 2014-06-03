package jellyworld;

import javax.swing.JApplet;

public class HellBoss implements TimerListener, KeyEventListener, MouseEventListener
{
    
    public static HellBoss s;
    
    public static void main(String[] args) {
        
        s = new HellBoss();
        s.initialize();
        //long time = System.currentTimeMillis() - 1;
        //while(true)
        //{
            //long temp = System.currentTimeMillis() - time;
            //time = System.currentTimeMillis();
            //s.run((float)temp / 1000f);
        //}
        s.timer.start();
    }
    
    public Screen screen;
    public Timer timer;
    public Keyboard keys;
    public Mouse mouse;
    
    public HellBoss()
    {}
    
    public void initialize()
    {
        //Sound.init();
        screen = new Screen(500, 500, "Test");
        timer = new Timer(20);
        timer.addListener(this);
        keys = new Keyboard();
        mouse = new Mouse();
        screen.c.addKeyListener(keys);
        screen.c.addMouseListener(mouse);
        screen.c.addMouseMotionListener(mouse);
        mouse.addListener(this);
        
        World.init(mouse);
    }
    
    public void run(float t)
    {
        screen.clear();
        World.update(t, keys, mouse);
        World.draw(screen.buffer);
        screen.flushBuffer();
    }

    @Override
    public void timerEvent() {
        run((float)timer.interval / 1000);
    }

    @Override
    public boolean KeyChange(int index, boolean down) {
        
        return true;
    }

    @Override
    public boolean mouseClicked(int x, int y, boolean left, boolean down) {
        
        return true;
    }

    @Override
    public boolean mouseMoved(int oldX, int oldY, int x, int y, boolean left, boolean right) {
        
        return true;
    }
}
