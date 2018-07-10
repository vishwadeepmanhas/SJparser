	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.image.BufferedImage;
	import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

import javax.imageio.*;
	
public class TakeScreenshot {

	

	 
	
	 public static void Takescreenshot(String ScreenshotName) throws Exception
	 {
		 
	  Robot awt_robot = new Robot();
	  BufferedImage Entire_Screen = awt_robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	  File thefile = new File(System.getProperty("user.home") + "//Desktop"+"//Images"+"//"+"Screenshot"+ScreenshotName+".jpeg");
	  thefile.mkdirs();
	  ImageIO.write(Entire_Screen, "JPEG", thefile);
	  
	 
	 }
	 
	 public static TreeSet<String> getSortedFileSet()
	 {
		 File Folder = new File(System.getProperty("user.home") + "//Desktop"+"//Images"+"//");
		 TreeSet<String> Filenames = new TreeSet<String>(Arrays.asList(Folder.list()));
		 System.out.println(Filenames);
		 return Filenames;
		 
	 }
	
}
