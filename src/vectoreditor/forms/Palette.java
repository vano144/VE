package vectoreditor.forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Palette extends JPanel { 

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JButton jButton1;
	private Color color0;
	private Color color1;
	
	// colorChanged event
	private Vector<ActionListener> colorChangedListeners;
	public void addColorChangedListener(ActionListener l)
	{
		colorChangedListeners.add(l);
	}
	public void removeColorChangedListener(ActionListener l)
	{
		colorChangedListeners.remove(l);
	}
	protected void onColorChanged()
	{
		for(ActionListener listener: colorChangedListeners)
		{
			listener.actionPerformed(new ActionEvent(this, 0, "color changed"));
		}
	}
	// end of colorChanged event
	
	public Palette() {
		colorChangedListeners=new Vector<ActionListener>();
		initComponents();
		setBackground(Color.gray);
	}

	private void initComponents() {
		add(getJButton0());
		add(getJButton1());
		setSize(337, 240);
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Choose a color of fill");
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
			jButton0.setText("Choose a color of stroke");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	public Color getFillColor()
	{
		return color1;
	}
	public Color getStrokeColor()
	{
		return color0;
	}
	
	
	
	private void jButton0MouseMouseClicked(MouseEvent event) 
	{
		color0=JColorChooser.showDialog(null, "q", Color.WHITE);
		onColorChanged();
	}

	private void jButton1MouseMouseClicked(MouseEvent event) 
	{
		color1=JColorChooser.showDialog(null, "q", Color.WHITE);
		onColorChanged();
	}

}
