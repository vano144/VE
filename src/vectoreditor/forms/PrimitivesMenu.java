package vectoreditor.forms;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import vectoreditor.geometicshapes.Circle;
import vectoreditor.geometicshapes.Line;
import vectoreditor.geometicshapes.Rectangle;
import vectoreditor.model.Sizeable;
//VS4E -- DO NOT REMOVE THIS LINE!
public class PrimitivesMenu extends JPanel 
{
	private JToggleButton getPreviousClick()
	{
		return null;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToggleButton CircleButton;
	private JToggleButton RectangleButton;
	private  JToggleButton previousClick;
	private JToggleButton jToggleButton0;
	private JToggleButton jToggleButton1;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	
	//load event
private Vector<ActionListener> LoadListeners;
	
	public void addLoadingListener(ActionListener l)
	{
		LoadListeners.add(l);
	}
	public void removeLoadingListener(ActionListener l)
	{
		savementListeners.remove(l);
	}
	protected void onLoad()
	{
		for(ActionListener listener: LoadListeners)
		{
			listener.actionPerformed(new ActionEvent(this, 0, "need loading"));
		}
	}
	// save event
	private Vector<ActionListener> savementListeners;
	
	public void addSavementListener(ActionListener l)
	{
		savementListeners.add(l);
	}
	public void removeSavementListener(ActionListener l)
	{
		savementListeners.remove(l);
	}
	protected void onSave()
	{
		for(ActionListener listener: savementListeners)
		{
			listener.actionPerformed(new ActionEvent(this, 0, "need deletion"));
		}
	}
	// Delete event
		private Vector<ActionListener> deleationListeners;
		
		public void addDeleationListener(ActionListener l)
		{
			deleationListeners.add(l);
		}
		public void removeDeleationListener(ActionListener l)
		{
			deleationListeners.remove(l);
		}
		protected void onDeleteded()
		{
			for(ActionListener listener: deleationListeners)
			{
				listener.actionPerformed(new ActionEvent(this, 0, "need deletion"));
			}
		}
		// end of Deleated event

	public PrimitivesMenu() 
	{
		setBackground(Color.gray);
		deleationListeners=new Vector<ActionListener>();
		savementListeners = new Vector<ActionListener>();
		LoadListeners=new Vector<ActionListener>();
		previousClick=null;
		initComponents();
		jButton2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				jButton2MouseMouseClicked(e);
				
			}
		});
		jButton1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				jButton1MouseMouseClicked( e);
				
			}
		});
		jToggleButton1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				{
					if (jToggleButton0.isSelected())
					{
						jToggleButton0.doClick();
					}
					if (previousClick!=jToggleButton1)
					if (previousClick.isSelected())
						previousClick.doClick();
					previousClick=jToggleButton1;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		RectangleButton.addMouseListener( new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (jToggleButton0.isSelected())
				{
					jToggleButton0.doClick();
				}
				if (previousClick!=RectangleButton)
				if (previousClick.isSelected())
					previousClick.doClick();
				previousClick=RectangleButton;
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
				// TODO Auto-generated method stub
				
			}
		} );
		jButton0.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//jButton0MouseMouseClicked(e);
				
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
				// TODO Auto-generated method stub
				
			}
		});
		CircleButton.addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				if (jToggleButton0.isSelected())
				{
					jToggleButton0.doClick();
				}
				if (previousClick!=CircleButton)
				if (previousClick.isSelected())
					previousClick.doClick();
				previousClick=CircleButton;
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
				// TODO Auto-generated method stub
				
			}
			
		});
		jToggleButton0.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(CircleButton.isSelected())
				{
					CircleButton.doClick();
				}
				if(RectangleButton.isSelected())
				{
					RectangleButton.doClick();
				}
				if (jToggleButton1.isSelected())
				{
					jToggleButton1.doClick();
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
		});
	}
	

	private void initComponents() {
		setBackground(Color.gray);
		add(getCircleButton());
		add(getRectangleButton());
		add(getJToggleButton1());
		add(getJToggleButton0());
		add(getJButton0());
		add(getJButton1());
		add(getJButton2());
		setSize(173, 174);
	}
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("save");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}
	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("load");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("delete");
			jButton2.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton2MouseMouseClicked(event);
				}
			});
		}
		return jButton2;
	}
	private JToggleButton getJToggleButton1() {
		if (jToggleButton1 == null) {
			jToggleButton1 = new JToggleButton();
			jToggleButton1.setText("Line");
			jToggleButton1.addMouseListener(new MouseAdapter() {
	
				public void mousePressed(MouseEvent event) {
					jToggleButton1MouseMousePressed(event);
				}
			});
		}
		return jToggleButton1;
	}

	private JToggleButton getJToggleButton0() {
		if (jToggleButton0 == null) {
			jToggleButton0 = new JToggleButton();
			jToggleButton0.setText("Selection ");
			jToggleButton0.addMouseListener(new MouseAdapter() {
	
				public void mousePressed(MouseEvent event) {
					jToggleButton0MouseMousePressed(event);
				}
			});
		}
		return jToggleButton0;
	}

	private JToggleButton getCircleButton() {
		if (CircleButton == null) {
			CircleButton = new JToggleButton();
			CircleButton.setText("Circle");
			CircleButton.addMouseListener(new MouseAdapter() {
	
				public void mousePressed(MouseEvent event) {
					CircleButtonMouseMousePressed(event);
				}
			});
		}
		return CircleButton;
	}

	private JToggleButton getRectangleButton() {
		if (RectangleButton == null) {
			RectangleButton = new JToggleButton();
			RectangleButton.setText("Rectangle");
			previousClick=RectangleButton;
		}
		return RectangleButton;
	}
	public Sizeable getSelectedFigure()
	{
		if (jToggleButton0.isSelected())
		{
			return null;
		}
		if (!previousClick.isSelected())
		previousClick.doClick();
		if (RectangleButton.isSelected())
			return new Rectangle();
		if (CircleButton.isSelected())
			return new Circle();
		if (jToggleButton1.isSelected())
			return new Line();
		return null;
	}

	private void CircleButtonMouseMousePressed(MouseEvent event) {
	}

	private void jToggleButton0MouseMousePressed(MouseEvent event) 
	{
		
	}

	private void jToggleButton1MouseMousePressed(MouseEvent event) {
	}

	private void jButton2MouseMouseClicked(MouseEvent event) {
		if (jToggleButton0.isSelected())
		{
			onDeleteded();
		}
	}
	private void jButton1MouseMouseClicked(MouseEvent event) {
		onSave();
	}
	private void jButton0MouseMouseClicked(MouseEvent event) {
		onLoad();
		System.out.println("clk");
	}
}
