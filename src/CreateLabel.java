package ide;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CreateLabel implements ActionListener {
	MainForm mf;
	ComponentJ cj;
	ButtonHandle bh;
	
	private volatile int draggedAtX, draggedAtY;
	
	public void actionPerformed(ActionEvent ae) { 
		//mf.ta.setText("hiii");
		JFrame frame=new JFrame();
		String s = null,st;
		s=JOptionPane.showInputDialog(
                "enter the button's label:\n",
                "button");

			//If a string was returned, say so.
			if ((s != null) && (s.length() > 0)) {
				//initialize the new component
				cj=new ComponentJ();
				cj.c=new Lbl(s);
				cj.c.setPreferredSize(new Dimension(50, 75)); 
				//cj.t.setText("");
				//mf.gui.add(cj.c);
				mf.gui.add(new Lbl(s));
				mf.gui.revalidate();
				//mf.cj=cj;
				//bh=new ButtonHandle();
				//bh.cj=cj;
				//bh.mf=mf;
				//bh.cjold=mf.cjold;
				//cj.c.addMouseListener( bh );
				ComponentResizer cr = new ComponentResizer();
		        cr.setSnapSize(new Dimension(10, 10));
		        cr.setDragInsets(new Insets(5, 5, 5, 5));
		        cr.registerComponent(cj.c);

				mf.clist.add(cj);

			}
			else
				JOptionPane.showMessageDialog(frame, "Please enter a label.");
	} //end method actionPerformed() 
} //end ButtonHandler nested (inner) class