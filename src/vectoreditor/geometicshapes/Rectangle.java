package vectoreditor.geometicshapes;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import vectoreditor.model.Sizeable;

public class Rectangle extends Sizeable {

	@Override
	public void paint(Graphics g) 
	{
		g.setColor(fillColor);
		g.fillRect((int)getLeftBorder(), (int)getTopBorder(), (int)getAbsWidth(), (int)getAbsHeight());
		g.setColor(strokeColor);
		g.drawRect((int)getLeftBorder(), (int)getTopBorder(), (int)getAbsWidth(), (int)getAbsHeight());
	}

	@Override
	public boolean insideOfFigure(int a, int b) {

		if (a>getLeftBorder() && a<getRightBorder() && b<getBottomBorder() && b>getTopBorder())
		{
			return true;
		}
		return false;
	}

	@Override
	public void saveIn(Sizeable a, PrintWriter file)
	{
		String s="2"+" "+getX()+" "+getY()+" "+getWidth()+" "+getHeigh()+" "+getFillColor().getRed()+" "+getFillColor().getGreen()+" "+getFillColor().getBlue()
				+" "+getStrokeColor().getRed()+" "+getStrokeColor().getGreen()+" "+getStrokeColor().getBlue();
		 file.print(s);
		 file.println();
		 
		
	}

}
