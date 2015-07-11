package vectoreditor.geometicshapes;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import vectoreditor.model.Sizeable;

public class Line extends Sizeable
{

	@Override
	public boolean insideOfFigure(int a, int b) {
		float k =getHeigh()/getWidth();
		float b1 = (getY()-k*getX());
		if (Math.abs(b-k*a-b1)/Math.sqrt(1+k*k)<5)
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void paint(Graphics g) 
	{
		g.setColor(strokeColor);
		g.drawLine((int)(getX()), (int)(getY()), (int)(getWidth()+getX()), (int)(getHeigh()+getY()));
		
	}

	@Override
	public void saveIn(Sizeable a, PrintWriter file) {
		
		String s="1"+" "+getX()+" "+getY()+" "+getWidth()+" "+getHeigh()+" "+getFillColor().getRed()+" "+getFillColor().getGreen()+" "+getFillColor().getBlue()
				+" "+getStrokeColor().getRed()+" "+getStrokeColor().getGreen()+" "+getStrokeColor().getBlue();
		 file.print(s);
		 file.println();
		 
		
	}

}
