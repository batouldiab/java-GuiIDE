package ide;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ButtonHandle implements MouseListener { 
	boolean isAlreadyOneClick;
	MainForm mf;
	ComponentJ cj,cjold;
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
	    if (isAlreadyOneClick) {
	    	String st;
	    	JFrame frame=new JFrame();
	    	JOptionPane.showMessageDialog(frame, "double clicked.");
	    	cjold=mf.cjold;
	    	//cj=mf.cj;
	    	if(cjold!=null)//no old button to save 
			{
				//cjold=mf.clist.get(mf.clist.size()-1);
	    		if(mf.ta!=null) {
	    			st=mf.ta.getText();
	    			if(cjold.t!=null)
	    				cjold.t=st;
	    		}
	    		
			}
	    		//open the text implementaion of this button in ta:
	    	if(cj.t!=null) {
	    		st=cj.t;
	    		mf.ta.setText(st);
	    	}
	    		//ta.setText("hhh");
	    		//ta.updateUI();//refresh
	    		mf.cjold=cj;
	        isAlreadyOneClick = false;
	    } else {
	        isAlreadyOneClick = true;
	        Timer t = new Timer("doubleclickTimer", false);
	        t.schedule(new TimerTask() {

	            @Override
	            public void run() {
	                isAlreadyOneClick = false;
	            }
	        }, 500);
	    }
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
		cj.c.setFocusable(true);
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}