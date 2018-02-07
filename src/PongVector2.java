package Pong;

public class PongVector2 
{
	public int x,y;
	
	public PongVector2(int a,int b)
	{
		x=a;
		y=b;
	}
	
	public PongVector2(PongVector2 o)
	{
		x=o.x;
		y=o.y;
	}
	
	public PongVector2 add(PongVector2 o)
	{
		return new PongVector2(x+o.x,y+o.y);
	}
	
	public PongVector2 sub(PongVector2 o)
	{
		return new PongVector2(x-o.x,y-o.y);
	}
	
	public static int Dot(PongVector2 a,PongVector2 b)
	{
		return a.x*b.x+a.y*b.y;
	}
}
