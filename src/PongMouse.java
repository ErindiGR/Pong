package Pong;

import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;;

public class PongMouse implements MouseListener
{
	public PongVector2 GetMousePosition()
	{
		return new PongVector2(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
	}
	
	//returns the positon of the mouse relative to the canvas position top-left 0-0
	public PongVector2 GetMousePositionRel()
	{
		return new PongVector2(
				MouseInfo.getPointerInfo().getLocation().x-PongWindow.Current.getLocation().x-3,
				MouseInfo.getPointerInfo().getLocation().y-PongWindow.Current.getLocation().y-22);
	}

	public boolean getLeftButton()
	{
		return left;
	}

	boolean left=false;
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			left = true;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			left = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
