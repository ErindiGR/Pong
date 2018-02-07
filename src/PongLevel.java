//PongLevel

package Pong;

import java.util.ArrayList;


public class PongLevel
{
	public static PongLevel Current;

	private ArrayList<PongObject> objects;

	PongLevel()
	{
		objects= new ArrayList<PongObject>();
	}

	public void Update()
	{
		for(int i=0;i<objects.size();i++)
		{
			objects.get(i).Update();
		}
	}

	public void Draw(PongBitmap screen)
	{
		for(int i=0;i<objects.size();i++)
		{
			screen.DrawBitmap(objects.get(i).getPosition(),
				objects.get(i).getImage());
		}
	}

	public PongObject getObject(String name)
	{
		for(int i=0;i<objects.size();i++)
		{
			if(objects.get(i).getName().compareTo(name) == 0)
				return objects.get(i);
		}
		return null;
	}

	public void addObject(PongObject o)
	{
		objects.add(o);
	}

	public void removeObject(PongObject o)
	{
		objects.remove(o);
	}

	public void MakeCurrent()
	{
		Current = this;
	}
}