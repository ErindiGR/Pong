//Pong

package Pong;

public class Pong 
{
	static boolean GameLoop=true;

	public static void Quit()
	{
		GameLoop=false;
	}

	public static void main(String[] args)
	{
		PongWindow window = new PongWindow(240,160,"Pong");

		PongMenu menu = new PongMenu();
		menu.MakeCurrent();
		
		double t=0.0;
		while(GameLoop)
		{
			//limit the game to 60 frames per second
			while(System.nanoTime()/1000000.0-t<16.666){}
			t=System.nanoTime()/1000000.0;
			
			PongLevel.Current.Update();
			window.Update();
		}
		
		System.exit(0);
	}
}
