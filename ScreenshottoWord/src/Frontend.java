import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class Frontend {
	
	static JFrame frame;
	public static void intiate_GUI()
	{
		
		
	 frame = new JFrame("Test");
	  frame.setVisible(true);
	  
	  frame.setSize(200,100);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  JPanel panel = new JPanel();
	  frame.add(panel);
	  JButton button = new JButton("Take Screenshot");
	  panel.add(button);
	  button.addActionListener (new Action1());

	  JButton button2 = new JButton("Stop");
	 // button2.setPreferredSize(new Dimension(40,20));
	  panel.add(button2);
	  button2.addActionListener (new Action2()); 
	}
	
	static class Action1 implements ActionListener {  
		Integer Counter=0;
		  public void actionPerformed (ActionEvent e) {    
			  frame.setVisible(false);
			  
			  try {
				  Thread.sleep(100);
			 TakeScreenshot.Takescreenshot(Counter.toString());
			 Counter++;
			  }
			  catch(Exception Ex)
			  {
				  Ex.printStackTrace();
			  }
			    
			  frame.setVisible(true);
		  }
		}   
	
	static class Action2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
		
			  try {
				ToWord.addImagetoWord();
				JFrame frame1 = new JFrame();
				frame1.setSize(300,100);
				JPanel panel = new JPanel();
				JLabel Label1 = new JLabel("Do you want to Stop ?");
				JButton button2 = new JButton("Yes");
				JButton button3 = new JButton("No");
				panel.add(Label1);
				panel.add(button2);
				panel.add(button3);
				frame1.add(panel);
				frame1.setVisible(true);
				button2.addActionListener(new Action3());
				
				button3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.dispose();						
					}
				});
				
				
			} catch (InvalidFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		  }
	}
	
	static class Action3 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
			 frame.dispose();
			 ToWord.opendoc();
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 System.exit(0);
		
		  }
	}
		  
		  
	
	
	
	
	
	
}


