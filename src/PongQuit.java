//PongQuit

package Pong;

public class PongQuit extends PongObject
{
	PongQuit()
	{
		super();
		this.setImage(new PongBitmap("Quit.png"));
		this.setRectangle(new PongRectangle(new PongVector2(111,24),new PongVector2(0,0),this));
		this.setName("Quit");

		position.x = 66;
		position.y = 105;
	}

	public void Update()
	{
		if(this.getRectangle().Test(PongInput.Mouse.GetMousePositionRel()))
			if(PongInput.Mouse.getLeftButton())
				Pong.Quit();
	}
}