//PongGame

package Pong;

public class PongGame extends PongLevel
{
	PongGame()
	{
		super();


		PongBackGround background = new PongBackGround();
		this.addObject(background);


		PongPlayer1 player1 = new PongPlayer1();
		this.addObject(player1);

		PongPlayer2 player2 = new PongPlayer2();
		this.addObject(player2);

		PongBall ball = new PongBall();
		this.addObject(ball);
	}	

	boolean end=false;
	int t=0;
	public void Win(int p)
	{
		PongObject won = new PongObject();
		won.setImage(new PongBitmap("Won_"+p+".png"));
		this.addObject(won);
		end = true;
	}

	public void Update()
	{
		super.Update();

		if(end)
		{
			//wait for 1.5 sec
			//than go to the menu
			if(t++ >= 90)
			{
				PongMenu menu = new PongMenu();
				menu.MakeCurrent();
			}
		}
	}
}