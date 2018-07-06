import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class Frontend {
	
	
	public static void intiate_GUI()
	{
		
		
	 JFrame frame = new JFrame("Test");
	  frame.setVisible(true);
	  
	  frame.setSize(200,100);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  JPanel panel = new JPanel();
	  frame.add(panel);
	  JButton button = new JButton("Take Screenshot");
	  //button.setFont(new Font("Arial", Font.PLAIN, 25));
	  //button.setPreferredSize(new Dimension(40,20));
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
			  try {
			 TakeScreenshot.Takescreenshot(Counter.toString());
			 Counter++;
			  }
			  catch(Exception Ex)
			  {
				  Ex.printStackTrace();
			  }
			  
			  
		    /*JFrame frame2 = new JFrame("Clicked");
		    frame2.setVisible(true);
		    frame2.setSize(200,200);
		    JLabel label = new JLabel("you clicked me button 1");
		    JPanel panel = new JPanel();
		    frame2.add(panel);
		    panel.add(label); */     
		  }
		}   
	
	static class Action2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {
		
			  try {
				ToWord.addImagetoWord();
			} catch (InvalidFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		  }
	}
}


