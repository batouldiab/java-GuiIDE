package ide;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;    
public class MenuExample implements ActionListener{    
	/*
	ImageIcon iconNew = new ImageIcon("new.png");
    ImageIcon iconOpen = new ImageIcon("open.png");
    ImageIcon iconSave = new ImageIcon("save.png");
    ImageIcon iconExit = new ImageIcon("exit.png");
    */ 
	JMenuBar mb;    
	JMenu file,edit,help,impMenu;    
	JMenuItem undo,redo,cut,copy,paste,selectAll;  //edit menu items
	JMenuItem newsfMi,bookmMi,mailMi;  //import menu items
	JMenuItem newMi,openMi,saveMi,exitMi;	//file menu items
	JTextArea ta;    
	
	final JFileChooser fc = new JFileChooser();//to save text file
	 
		MenuExample(MainForm mf){    
			//ta=mf.ta;
			for(int i=0; i<mf.clist.size(); i++)
			{
				ta.append(mf.clist.get(i).t);
			}
		mb=new JMenuBar();  
		file=new JMenu("File");    
		edit=new JMenu("Edit");    
		help=new JMenu("Help"); 
		impMenu = new JMenu("Import");
		//import items
		newsfMi = new JMenuItem("Import newsfeed list...");
		bookmMi = new JMenuItem("Import bookmarks...");
		mailMi = new JMenuItem("Import mail...");

		//edit menu items
		undo=new JMenuItem("undo");    
		redo=new JMenuItem("redo");    
		cut=new JMenuItem("cut");    
		copy=new JMenuItem("copy");    
		paste=new JMenuItem("paste");    
		selectAll=new JMenuItem("selectAll");    
		undo.addActionListener(this);    
		redo.addActionListener(this);   
		cut.addActionListener(this);    
		copy.addActionListener(this);    
		paste.addActionListener(this);    
		selectAll.addActionListener(this);    
		//file menu items
		/*import png images:
		ImageIcon iconNew = new ImageIcon("new.png");
        ImageIcon iconOpen = new ImageIcon("open.png");
        ImageIcon iconSave = new ImageIcon("save.png");
        ImageIcon iconExit = new ImageIcon("exit.png");
		 */
		/*file menu items with png images:
		JMenuItem newMi = new JMenuItem("New", iconNew);
        JMenuItem openMi = new JMenuItem("Open", iconOpen);
        JMenuItem saveMi = new JMenuItem("Save", iconSave);
        exitMi= new JMenuItem("Exit", iconExit);
        */
		//file menu items with no png images:
		newMi = new JMenuItem("New");
        openMi = new JMenuItem("Open");
        saveMi = new JMenuItem("Save");
        exitMi= new JMenuItem("Exit");
        exitMi.setToolTipText("Exit application");
        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        saveMi.addActionListener(this);
        
		//set the submenu import
		impMenu.add(newsfMi);impMenu.add(bookmMi);impMenu.add(mailMi);
		//set the edit menu
		edit.add(undo);edit.add(redo);edit.addSeparator();edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll); 
		//set file menu
		file.add(newMi); file.add(openMi); file.add(saveMi);file.addSeparator();file.add(impMenu);file.addSeparator(); file.add(exitMi);
		
		mb.add(file);mb.add(edit);mb.add(help); 
		}     
	public void actionPerformed(ActionEvent e) {   
		if(e.getSource()==undo)    
			//code   
		if(e.getSource()==redo)    
			//code
		if(e.getSource()==cut)    
			ta.cut();    
		if(e.getSource()==paste)    
			ta.paste();    
		if(e.getSource()==copy)    
			ta.copy();    
		if(e.getSource()==selectAll)    
			ta.selectAll();  
		if(e.getSource()==saveMi)    
			saveAs(); 
	} 
	 public void saveAs() {
	      FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
	      final JFileChooser saveAsFileChooser = new JFileChooser();
	      saveAsFileChooser.setApproveButtonText("Save");
	      saveAsFileChooser.setFileFilter(extensionFilter);
	      int actionDialog = saveAsFileChooser.showOpenDialog(this.ta);
	      if (actionDialog != JFileChooser.APPROVE_OPTION) {
	         return;
	      }

	      // !! File fileName = new File(SaveAs.getSelectedFile() + ".txt");
	      File file = saveAsFileChooser.getSelectedFile();
	      if (!file.getName().endsWith(".txt")) {
	         file = new File(file.getAbsolutePath() + ".txt");
	      }

	      BufferedWriter outFile = null;
	      try {
	         outFile = new BufferedWriter(new FileWriter(file));

	         ta.write(outFile);

	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } finally {
	         if (outFile != null) {
	            try {
	               outFile.close();
	            } catch (IOException e) {}
	         }
	      }
		


}
}