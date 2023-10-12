package ide;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class KeyL implements KeyListener{
	MainForm mf;
	JComponent cj;
	@Override
	public void keyPressed(KeyEvent ke) {
		{
			int code=ke.getKeyCode();
			boolean flag=true;
			if(code==KeyEvent.VK_DELETE && flag==true)
				mf.gui.remove(cj);
			}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
