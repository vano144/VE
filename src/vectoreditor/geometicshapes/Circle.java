package vectoreditor.geometicshapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import vectoreditor.model.Sizeable;

public class Circle extends Sizeable
{

	@Override
	public void paint(Graphics g) 
	{
		g.setColor(strokeColor);
		Graphics2D gr2d = (Graphics2D) g;
		BasicStroke s = new BasicStroke(3); //толщина линии 3  многоугольника
		gr2d.setStroke(s);
		g.drawOval((int)getLeftBorder(), (int)getTopBorder(), (int)getAbsWidth(), (int)getAbsHeight());
		g.setColor(fillColor);
		g.fillOval((int)getLeftBorder(), (int)getTopBorder(), (int)getAbsWidth(), (int)getAbsHeight());
	}

	@Override
	public boolean insideOfFigure(int a, int b) {
		if (    ((a-((getLeftBorder()+getRightBorder())/2))/(getAbsWidth()/2))*
				((a-((getLeftBorder()+getRightBorder())/2))/(getAbsWidth()/2))+
				((b-((getTopBorder()+getBottomBorder())/2))/getAbsHeight()/2)*
				((b-((getTopBorder()+getBottomBorder())/2))/getAbsHeight()/2)<=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public void saveIn(Sizeable a, PrintWriter file) 
	{
		
		String s="0"+" "+getX()+" "+getY()+" "+getWidth()+" "+getHeigh()+" "+getFillColor().getRed()+" "+getFillColor().getGreen()+" "+getFillColor().getBlue()
				+" "+getStrokeColor().getRed()+" "+getStrokeColor().getGreen()+" "+getStrokeColor().getBlue();
		 file.print(s); 
		 file.println();
		
		 
		
	}

}
