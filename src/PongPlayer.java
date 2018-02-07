//PongPlayer

package Pong;

public class PongPlayer extends PongObject
{
	PongPlayer()
	{
		super();
		this.setRectangle(new PongRectangle(new PongVector2(5,25),new PongVector2(0,0),this));
		this.setImage(new PongBitmap("Player.png"));
	}

	private int upKey, downKey;
	private int velocity=3;
	public void setControlls(int up,int down)
	{
		upKey = up;
		downKey = down;
	}

	public void Update()
	{
		if(PongInput.Key.GetKey(upKey))
			MoveY(-velocity);
		if(PongInput.Key.GetKey(downKey))
			MoveY(velocity);

	}

	void MoveY(int v)
	{
		if(PongWindow.Current.getHeight()>position.y+v+this.getRectangle().max.y &&
			0<position.y+v+this.getRectangle().min.y)
		{
			position.y +=v;
		}
	}
}