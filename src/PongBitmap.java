//PongBitmap

package Pong;

import javax.imageio.ImageIO;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongBitmap 
{
	String name;
	int height,width;
	int[] pixels;
	
	public PongBitmap(int w,int h,String n)
	{
		name = n;
		
		height = h;
		width = w;
		pixels = new int[height*width];
		
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				pixels[j+(i*width)]=0xff000000;
	}
	
	public PongBitmap(int w,int h,int rgb,String n)
	{
		name = n;
		
		height = h;
		width = w;
		
		pixels = new int[height*width];
		
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				pixels[j+(i*width)]=rgb;

	}
	
	public PongBitmap(String path)
	{
		BufferedImage img;
		try
		{
			img = ImageIO.read(new File(path));
			name = path;
			
			System.out.println("loaded: "+path);
			
			height = img.getHeight();
			width = img.getWidth();
			pixels = new int[height*width];
			
			for(int i=0;i<height;i++)
				for(int j=0;j<width;j++)
					pixels[j+(i*width)]= img.getRGB(j,i);
		}
		catch (IOException e) 
		{
	        e.printStackTrace();
	        
	        name = path;
	        
	        height = 16;
			width = 16;
			pixels = new int[height*width];
	        
			for(int i=0;i<height;i++)
				for(int j=0;j<width;j++)
					pixels[j+(i*width)]= 0xffff00ff;
			
	    }
		
	}
	
	public PongBitmap(String path,String n)
	{
		BufferedImage img;
		try
		{
			img = ImageIO.read(new File(path));
			name = n;
			
			System.out.println("loaded: "+path);
			
			height = img.getHeight();
			width = img.getWidth();
			pixels = new int[height*width];
			
			for(int i=0;i<height;i++)
				for(int j=0;j<width;j++)
					pixels[j+(i*width)]= img.getRGB(j,i);
		}
		catch (IOException e) 
		{
	        e.printStackTrace();
	        
	        name = n;
	        
	        height = 16;
			width = 16;
			pixels = new int[height*width];
	        
			for(int i=0;i<height;i++)
				for(int j=0;j<width;j++)
					pixels[j+(i*width)]= 0xffff00ff;
			
	    }
		
	}
	
	public void DrawRect(int xstart,int ystart,int xend,int yend,int rgb)
	{
		for(int i=Math.max(ystart,0);i<Math.min(yend,height);i++)
			for(int j=Math.max(xstart,0);j<Math.min(xend,width);j++)
				pixels[j+(i*width)]= rgb;
	}
	
	public void DrawRect(PongVector2 start,PongVector2 end,int rgb)
	{
		for(int i=Math.max(start.y,0);i<Math.min(end.y,height);i++)
			for(int j=Math.max(start.x,0);j<Math.min(end.x,width);j++)
				pixels[j+(i*width)]= rgb;
	}
	
	public void DrawBitmap(int xstart,int ystart,PongBitmap t)
	{
		int mh=Math.min(t.height+ystart,height);
		int mw=Math.min(t.width+xstart,width);
		
		for(int i=Math.max(ystart,0);i<mh;i++)
			for(int j=Math.max(xstart,0);j<mw;j++)
				//draw pixel if the alpha channel is white(255)
				if(((t.pixels[(j-xstart)+((i-ystart)*t.width)] >>24)& 0xff)==255)
				pixels[j+(i*width)]= t.pixels[(j-xstart)+((i-ystart)*t.width)];
	}
	
	public void DrawBitmap(PongVector2 start,PongBitmap t)
	{
		int mh=Math.min(t.height+start.y,height);
		int mw=Math.min(t.width+start.x,width);
		
		for(int i=Math.max(start.y,0);i<mh;i++)
			for(int j=Math.max(start.x,0);j<mw;j++)
				if(((t.pixels[(j-start.x)+((i-start.y)*t.width)] >>24)& 0xff)==255)
				pixels[j+(i*width)]= t.pixels[(j-start.x)+((i-start.y)*t.width)];
	}
	
	
	public void ClearColor(int rgb)
	{
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				pixels[j+(i*width)]= rgb;
	}
	
	public BufferedImage toImg()
	{
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				img.setRGB(j,i, pixels[j+(i*width)]);
		
		return img;
	}
}
