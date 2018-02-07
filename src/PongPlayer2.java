//PongPlayer2

package Pong;

import java.awt.event.KeyEvent;

public class PongPlayer2 extends PongPlayer
{
	PongPlayer2()
	{
		super();
		this.setName("Player2");
		this.setControlls(KeyEvent.VK_UP,KeyEvent.VK_DOWN);
		position.x = 222;
		position.y = 100;
	}
}