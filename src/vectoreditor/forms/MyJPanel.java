package vectoreditor.forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import vectoreditor.model.Sizeable;


public class MyJPanel extends JPanel 
{
	MainFrame frame;
	public MyJPanel(MainFrame a)
	{
		frame=a;
		
		this.setBackground(Color.WHITE);
		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				super.mouseMoved(e);
				repaint();
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				repaint();
			}
			
		});
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				repaint();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				repaint();
				
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Sizeable[] array=frame.getListOfFigures();
		for(int i=0;i<array.length;++i)
		{
			if (array[i].equals(frame.getSelectedFigure()))
			{
				g.setColor(Color.BLUE);
				g.drawRect((int)array[i].getRightBorder(), (int)array[i].getBottomBorder(), 15, 15);
			}
			
			array[i].paint(g);
		}
	}
}
