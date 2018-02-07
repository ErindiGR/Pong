//PongBackGround

package Pong;

public class PongBackGround extends PongObject
{
	PongBackGround()
	{
		super();
		this.setImage(new PongBitmap("BackGround.png"));
		this.setRectangle(null);
		this.setName("BackGround");
	}
}