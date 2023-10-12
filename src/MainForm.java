package ide;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainForm {
	static MainForm mf;
	JFrame f;
	JTextArea ta;
	JButton button ;		
	JButton textfield ;
	JButton textbox ;		
	JButton label ;
	JButton jb5 ;
	JPanel gui;
	ComponentJ cj=null;
	ComponentJ cjold=null;
	JInternalFrame gf;
	ArrayList<ComponentJ> clist = new ArrayList<ComponentJ>(); 

	public static void main(String[] args) 
	{ mf=new MainForm(); 
	 mf.go(); 
	} //end method main()
	
	public void go()  
	{
		f=new JFrame("GUI IDE");
		
		ta=new JTextArea();
			
		MenuExample menu=new MenuExample(mf);
		
		f.add(menu.mb);
		f.setJMenuBar(menu.mb); 
		gui = new JPanel();
		//gf=new JInternalFrame();
		//gf.setLayout(null);
		//gui.add(gf);
		
			// Define new buttons for panelbuttons with action listeners
					button = new JButton("Button");		
					textfield = new JButton("textfield");
					textbox = new JButton("textbox");		
					label = new JButton("label");
					jb5 = new JButton("Button 5");			
					
					
			// Define the panel to hold the buttons	
			JPanel panelbuttons = new JPanel();
					panelbuttons.setSize(100, 500);
					panelbuttons.setLayout(new GridLayout(5, 0));
					panelbuttons.add(button);
					panelbuttons.add(textfield);
					panelbuttons.add(textbox);
					panelbuttons.add(label);
					panelbuttons.add(jb5);

					JScrollPane guiScroll = new JScrollPane(gui,
	                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					JScrollPane taScroll = new JScrollPane(ta, 
	                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					JScrollPane buttonsScroll = new JScrollPane(panelbuttons, 
	                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		guiScroll.setPreferredSize(new Dimension(400, 800));
		taScroll.setPreferredSize(new Dimension(800, 350));
		buttonsScroll.setPreferredSize(new Dimension(800, 450));
		panelbuttons.setBackground(Color.blue);
		JSplitPane panneau2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,
						     guiScroll, taScroll);
		JSplitPane panneau1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
							buttonsScroll, panneau2);
		panneau1.setOneTouchExpandable(true); 
		panneau2.setOneTouchExpandable(true); 
		f.getContentPane().add(panneau1);
		
		f.pack();
		
		CreateComp cp=new CreateComp();
		CreateLabel cl = new CreateLabel();
		cp.mf=mf;
		cl.mf=mf;
		button.addActionListener( cp );
		textfield.addActionListener( cp );
		textbox.addActionListener( cp );
		label.addActionListener( cl );
		jb5.addActionListener( cp );
		
		f.setVisible(true); 
		
	} //end method go()
	
}