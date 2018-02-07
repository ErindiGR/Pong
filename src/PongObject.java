//PongObject
package Pong;

public class PongObject
{
	protected PongVector2 position;
	private PongBitmap	image;
	private PongRectangle rectangle;
	private String name;

	PongObject()
	{
		position = new PongVector2(0,0);
		name = "BaseObject";
	}

	PongObject(int wh)
	{
		rectangle = new PongRectangle(new PongVector2(wh,wh),new PongVector2(0,0),this);
		image =  new PongBitmap(wh,wh,0xffff00ff,"BaseObject");
		name = "BaseObject";

	}

	public void setImage(PongBitmap img)
	{
		image = img;
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setRectangle(PongRectangle sq)
	{
		rectangle = sq;
	}

	public PongVector2 getPosition()
	{
		return position;
	}

	public String getName()
	{
		return name;
	}

	public PongBitmap getImage()
	{
		return image;
	}

	public PongRectangle getRectangle()
	{
		return rectangle;
	}

	public void Update()
	{
	}
}