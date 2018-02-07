//PongPlay

package Pong;

public class PongPlay extends PongObject
{
	PongPlay()
	{
		super();
		this.setImage(new PongBitmap("Play.png"));
		this.setRectangle(new PongRectangle(new PongVector2(111,24),new PongVector2(0,0),this));
		this.setName("Play");

		position.x = 66;
		position.y = 77;
	}

	public void Update()
	{
		if(this.getRectangle().Test(PongInput.Mouse.GetMousePositionRel()))
			if(PongInput.Mouse.getLeftButton())
			{
				PongGame game = new PongGame();
				game.MakeCurrent();
			}
	}
}