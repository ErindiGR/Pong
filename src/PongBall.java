//PongBall

package Pong;
import java.util.Random;

public class PongBall extends PongObject
{

	PongVector2 velocity;


	PongObject pl1,pl2;
	PongBall()
	{
		super();

		this.setRectangle(new PongRectangle(new PongVector2(6,6),new PongVector2(0,0),this));
		this.setImage(new PongBitmap("Ball.png"));
		this.setName("Ball");

		Random rand = new Random();

		position.x = PongWindow.Current.getWidth()/2;
		position.y = PongWindow.Current.getHeight()/2;
		
		int vx=1,vy=1;
		int speedy=2,speedx=1;
		switch(rand.nextInt(3))
		{
		case 0:
			vx = rand.nextInt(speedx)+1;
			vy = rand.nextInt(speedy)+1;
		break;
		case 1:
			vx = (rand.nextInt(speedx)+1)*-1;
			vy = rand.nextInt(speedy)+1;
		break;
		case 2:
			vx = rand.nextInt(speedx)+1;
			vy = (rand.nextInt(speedy)+1)*-1;
		break;
		case 3:
			vx = (rand.nextInt(speedx)+1)*-1;
			vy = (rand.nextInt(speedy)+1)*-1;
		break;
		}
		
		velocity = new PongVector2(vx,vy);

	}

	public void Update()
	{
		if(pl1 ==null)pl1 = PongLevel.Current.getObject("Player1");
		if(pl2 ==null)pl2 = PongLevel.Current.getObject("Player2");
		
		
		position = position.add(velocity);

		if(PongWindow.Current.getHeight()<=position.y+this.getRectangle().max.y ||
			0>=position.y+this.getRectangle().min.y)
		{
			velocity.y *=-1;
		}

		if(this.getRectangle().Test(pl1))
		{
			if(velocity.x<0)
				velocity.x *=-1;
		}

		if(this.getRectangle().Test(pl2))
		{
			if(velocity.x>0)
				velocity.x *=-1;
		}


		if(PongWindow.Current.getWidth()<position.x+this.getRectangle().max.x)
		{
			((PongGame)PongLevel.Current).Win(1);
			PongLevel.Current.removeObject(this);
		}

		if(0>position.x+this.getRectangle().min.x)
		{
			((PongGame)PongLevel.Current).Win(2);
			PongLevel.Current.removeObject(this);
		}
	}

}