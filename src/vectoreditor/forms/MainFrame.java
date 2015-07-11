package vectoreditor.forms;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JFrame;

import vectoreditor.geometicshapes.Circle;
import vectoreditor.geometicshapes.Line;
import vectoreditor.geometicshapes.Rectangle;
import vectoreditor.model.Sizeable;


//VS4E -- DO NOT REMOVE THIS LINE!
public class MainFrame extends JFrame {

	private PrintWriter out;
	Color currentFillColor;
	Color currentStrokeColor;
	Sizeable currentGeomFigure;
	Vector<Sizeable> listOfGeomFigures;
	Sizeable selectedFigure;
	boolean stretch; 
	private PrimitivesMenu primitivesMenu0;
	private MyJPanel jPanel0;
	private Palette palette0;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public MainFrame() 
	{
		stretch=false;
		currentStrokeColor=Color.BLACK;
		currentFillColor=Color.WHITE;
		currentGeomFigure=null;
		selectedFigure=null;
		listOfGeomFigures=new Vector<Sizeable>();
		initComponents();
	}
	public Sizeable getSelectedFigure()
	{
		return selectedFigure;
	}
	private void initComponents() {
		add(getPrimitivesMenu0(), BorderLayout.WEST);
		add(getPalette0(), BorderLayout.EAST);
		add(getJPanel0(), BorderLayout.CENTER);
		palette0.addColorChangedListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentFillColor=palette0.getFillColor();
				currentStrokeColor=palette0.getStrokeColor();
				if (selectedFigure!=null)
				{
					selectedFigure.setFillColor(currentFillColor);
					selectedFigure.setStrokeColor(currentStrokeColor);
				}
				if (currentGeomFigure!=null)
				{
					currentGeomFigure.setFillColor(currentFillColor);
					currentGeomFigure.setStrokeColor(currentStrokeColor);
				}
			}
		});
		primitivesMenu0.addDeleationListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				listOfGeomFigures.remove(selectedFigure);
				//getSelectedFigure().setStrokeColor(Color.WHITE);
				//getSelectedFigure().setFillColor(Color.WHITE);
				selectedFigure=null;
				jPanel0.repaint();
			}
		});
		primitivesMenu0.addLoadingListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				listOfGeomFigures.removeAllElements();
				try{
				FileInputStream fis=new FileInputStream("MyFile.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fis, "windows-1251"));
				String str;
				String[] a=new String[11];
				while((str=br.readLine())!=null)
				{
					Sizeable loadFigure=null;
					a=str.split(" ");
					if (a[0].equals("0"))
					{
						loadFigure=new Circle();
					}
					if (a[0].equals("1"))
					{
						loadFigure=new Line();
					}
					if (a[0].equals("2"))
					{
						loadFigure=new Rectangle();
					}
					System.out.println(a[0]);
					loadFigure.setX(Float.valueOf(a[1]));
					loadFigure.setY(Float.valueOf(a[2]));
					loadFigure.setWidth(Float.valueOf(a[3]));
					loadFigure.setHeigh(Float.valueOf(a[4]));
					Color fillColorOfLoadFigure=new Color(Integer.valueOf(a[5]), Integer.valueOf(a[6]), Integer.valueOf(a[7]));
					loadFigure.setFillColor(fillColorOfLoadFigure);
					Color strokeColorOfLoadFigure=new Color(Integer.valueOf(a[8]),Integer.valueOf(a[9]),Integer.valueOf(a[10]));
					loadFigure.setStrokeColor(strokeColorOfLoadFigure);
					listOfGeomFigures.addElement(loadFigure);
					//System.out.println(str);
				}
				br.close();
				jPanel0.repaint();
					}
				
				 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		primitivesMenu0.addSavementListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = new File("MyFile.txt");
				try {
					out=new PrintWriter(file);
					for(Sizeable listener: listOfGeomFigures)
					{
						
							listener.saveIn(listener, out);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				out.close();  
			}
		});
		jPanel0.addMouseMotionListener(new MouseMotionAdapter() {
	
			public void mouseMoved(MouseEvent event) {
				super.mouseMoved(event);
				//System.out.println("!");
				mouseMotionMouseMoved(event);
			}
			public void mouseDragged(MouseEvent event)
			{
				super.mouseDragged(event);
				mouseMotionMouseDrugged(event);
				
			}
		});
		jPanel0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				mouseMousePressed(e);
			}

			private void mouseMousePressed(MouseEvent e) 
			{
				if (getSelectedFigure()!=null)
				{
					
					if (e.getX()>getSelectedFigure().getLeftBorder() && e.getX()<getSelectedFigure().getRightBorder() && 
							e.getY()<getSelectedFigure().getBottomBorder() && e.getY()>getSelectedFigure().getTopBorder())
					{
						
						stretch=false;
						getSelectedFigure().moveCPtoLT();
					}
					else  
					{
						stretch=true;
					}
				}
				
			}
		});
		setSize(731, 240);
	}

	private Palette getPalette0() {
		if (palette0 == null) {
			palette0 = new Palette();
		}
		return palette0;
	}

	private MyJPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new MyJPanel(this);
			jPanel0.setBackground(Color.white);
			jPanel0.setOpaque(true);
			jPanel0.setVisible(true);
			jPanel0.setRequestFocusEnabled(true);
			jPanel0.setFocusable(true);
			jPanel0.setEnabled(true);
			jPanel0.setVerifyInputWhenFocusTarget(true);
			jPanel0.setDoubleBuffered(true);
			jPanel0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jPanel0MouseMouseClicked(event);
				}
			});
		}
		return jPanel0;
	}

	private PrimitivesMenu getPrimitivesMenu0() {
		if (primitivesMenu0 == null) {
			primitivesMenu0 = new PrimitivesMenu();
		}
		return primitivesMenu0;
	}

	private void jPanel0MouseMouseClicked(MouseEvent event)
	{
		selectedFigure=null;
		//System.out.println(listOfGeomFigures.size());
		if(currentGeomFigure==null)
		{
			currentGeomFigure=primitivesMenu0.getSelectedFigure();
			if (currentGeomFigure!=null)
			{
				currentGeomFigure.setFillColor(currentFillColor);
				currentGeomFigure.setStrokeColor(currentStrokeColor);
				currentGeomFigure.setX(event.getX());
				currentGeomFigure.setY(event.getY());
			}
			else
			{
				
				for (Sizeable a: listOfGeomFigures)
				{
					if (a.insideOfFigure(event.getX(), event.getY()))
					{
						selectedFigure=a;
						break;
					}
				}
			}
		}
		else 
		{
			listOfGeomFigures.add(currentGeomFigure);
			currentGeomFigure=null;
		}
		
	}
	public Sizeable[] getListOfFigures()
	{
		if (currentGeomFigure!=null)
		{
			Sizeable[] array=new Sizeable[listOfGeomFigures.size()+1];
			listOfGeomFigures.toArray(array);
			array[listOfGeomFigures.size()]=currentGeomFigure;
			return array;
		}
		else
		{
			Sizeable[] array=new Sizeable[listOfGeomFigures.size()];
			listOfGeomFigures.toArray(array);
			return array;
		}
	}

	private void mouseMotionMouseMoved(MouseEvent event)
	{
		//System.out.println(event.getX());
		if(currentGeomFigure!=null)
		{
			currentGeomFigure.setWidth(event.getX()-currentGeomFigure.getX());
			currentGeomFigure.setHeigh(event.getY()-currentGeomFigure.getY());
			
		}
	}
	private void mouseMotionMouseDrugged(MouseEvent event)
	{
		if (getSelectedFigure()!=null)
		{
			if (!stretch)
			{
				if (event.getX()>0 && event.getY()>0 && ((event.getX()+getSelectedFigure().getAbsWidth())<jPanel0.getWidth())
						&& ((event.getY()+getSelectedFigure().getAbsHeight())<jPanel0.getHeight()))  
				{
			getSelectedFigure().setX(event.getX());
				
			getSelectedFigure().setY(event.getY());
				}
			}
			else
			{
				getSelectedFigure().setHeigh(Math.abs(event.getY()));
				getSelectedFigure().setWidth(Math.abs(event.getX()));
			}
		}
	}
	
}
