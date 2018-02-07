//PongPlayer1

package Pong;

import java.awt.event.KeyEvent;

public class PongPlayer1 extends PongPlayer
{
	PongPlayer1()
	{
		super();
		this.setName("Player1");
		this.setControlls(KeyEvent.VK_W,KeyEvent.VK_S);
		position.x = 13;
		position.y = 100;
	}
}