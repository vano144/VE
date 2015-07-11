package vectoreditor.model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GeometricShape 
{
	protected float x;
	protected float y;
	protected Color strokeColor;
	protected Color fillColor;
	
	public GeometricShape()
	{
		strokeColor=Color.black;
		fillColor=Color.white;
	}
	public abstract void paint (Graphics g );
	public void setFillColor(Color a)
	{
		fillColor=a;
	}
	public Color getFillColor()
	{
		return fillColor;
	}
	public void setStrokeColor(Color a)
	{
		strokeColor=a;
	}
	public Color getStrokeColor()
	{
		return strokeColor;
	}
	public void setX(float a)
	{
		x=a;
	}
	public void setY(float a)
	{
		y=a;
	}
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
}
