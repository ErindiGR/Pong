//PongWindow

package Pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PongWindow extends JFrame
{

	public static PongWindow Current;
	Canvas DrawScreen;
	Graphics DG;
	PongBitmap Screen;
	int width,height;

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	//w the width of the window
	//h the height of the window
	//t the title of the window
	PongWindow(int w,int h,String t)
	{
		//JFrame constructor
		super();

		//create a new canvas to draw on
		DrawScreen = new Canvas();

		width = w;
		height = h;

		//set the size of the canvas
		DrawScreen.setSize(w,h);

		//set the background color to black
		DrawScreen.setBackground(Color.BLACK);
		
		DrawScreen.setFocusable(false);
		
		this.setTitle(t);
		
		//add the canvas to the Jframe
		this.add(DrawScreen);
		//resize the Jframe to fit everything inside
		this.pack();
		//set the jframe visible
		this.setVisible(true);
		
		this.setResizable(false);
		
		this.setSize(this.getSize().width-2, this.getSize().height-2);
		
		//set the program to close when the window closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//get the key from window
		this.addKeyListener(PongInput.Key);
		DrawScreen.addMouseListener(PongInput.Mouse);
		
		//get the Canvas graphic component
		DG = DrawScreen.getGraphics();

		//create a new bitmap
		Screen = new PongBitmap(width,height,"Screen");

		Current = this;
		
	}

	public void Update()
	{
		//fill all the screen with color
		Screen.ClearColor(0xff000000);
		

		if(PongLevel.Current !=null)
			PongLevel.Current.Draw(Screen);

		//draw the new image on the screen
		DG.drawImage(Screen.toImg(),0,0, width, height, null);
	}

}