//PongMenu

package Pong;

public class PongMenu extends PongLevel
{
	PongMenu()
	{
		super();


		PongBackGround background = new PongBackGround();
		this.addObject(background);

		PongPlay play = new PongPlay();
		this.addObject(play);

		PongQuit quit = new PongQuit();
		this.addObject(quit);
	}	
}