package vectoreditor.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Sizeable extends GeometricShape 
{
	protected float width;
	protected float height;
	
	public abstract void saveIn(Sizeable a, PrintWriter file);
	
	public void setWidth(float a)
	{
		width=a;
	}
	public void setHeigh(float a)
	{
		height=a;
	}
	public float getWidth()
	{
		return width;
	}
	public float getHeigh()
	{
		return height;
	}
	public float getTopBorder()
	{
		if (height<0)
		{
			return y+height;
		}
		else return y;
	}
	public void moveCPtoLT()
	{
		setX(getLeftBorder());
		setY(getTopBorder());
		setHeigh(getAbsHeight());
		setWidth(getAbsWidth());
	}
	public float getBottomBorder()
	{
		if (height<0)
		{
			return y;
		}
		else return y+height;
	}
	public float getLeftBorder()
	{
		if (width<0)
		{
			return x+width;
		}
		else return x;
	}
	public float getRightBorder()
	{
		if (width<0)
		{
			return x;
		}
		else return x+width;
	}
	public float getAbsHeight()
	{
		return Math.abs(height);
	}
	public float getAbsWidth()
	{
		return Math.abs(width);
	}
	public abstract boolean insideOfFigure(int a, int b);
}
