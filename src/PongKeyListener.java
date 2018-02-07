//PongKeyListener

package Pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PongKeyListener implements KeyListener
{
	private boolean[] keys = new boolean[256];
	
	public boolean GetKey(int i)
	{
		return keys[i];
	}
	
	public void SetKey(int i,boolean v)
	{
		keys[i]=v;
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		//keys[e.getKeyCode()]=true;
		SetKey(e.getKeyCode(),true);
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		//keys[e.getKeyCode()]=false;
		SetKey(e.getKeyCode(),false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}
