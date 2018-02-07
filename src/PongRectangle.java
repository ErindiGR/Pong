//PongSquare

package Pong;


public class PongRectangle
{
	PongVector2 max, min;
	PongObject obj;

	PongRectangle(PongObject o)
	{
		max=new PongVector2(0,0);
		min=new PongVector2(0,0);
		obj=o;
	}
	PongRectangle(PongVector2 mx,PongVector2 mn,PongObject o)
	{
		max=mx;
		min=mn;
		obj=o;
	}

	//find if Rectangles intersect
	public boolean Test(PongObject o)
	{
		return (
			obj.getPosition().x+min.x<=o.getPosition().x+o.getRectangle().max.x&&
			obj.getPosition().x+max.x>=o.getPosition().x+o.getRectangle().min.x&&
			obj.getPosition().y+min.y<=o.getPosition().y+o.getRectangle().max.y&&
			obj.getPosition().y+max.y>=o.getPosition().y+o.getRectangle().min.y
			);
	}


	//find if point is inside Rectangle
	public boolean Test(PongVector2 point)
	{
		return (
			obj.getPosition().x+min.x<=point.x&&
			obj.getPosition().y+min.y<=point.y&&
			obj.getPosition().x+max.x>=point.x&&
			obj.getPosition().y+max.y>=point.y
			);
	}
}