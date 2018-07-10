import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import word.api.interfaces.IDocument;
import word.w2004.Document2004;
import word.w2004.elements.Heading1;
import word.w2004.elements.Image;
import word.w2004.elements.ImageLocation;
import word.w2004.elements.Paragraph;



public class ToWord {
	
	static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	static Date date = new Date();
	
	
	static String Temp_dir = System.getProperty("user.home")+"\\SStoWord\\";
	static String Word_filePath = Temp_dir+dateFormat.format(date)+".doc";
	static XWPFDocument doc;
	static XWPFParagraph p; 
	static XWPFRun r ;
	static CustomXWPFDocument document;
	static FileOutputStream fos;
	
	
	public static void addImagetoWord() throws IOException, InvalidFormatException
	{
		
		

		new File(Temp_dir).mkdirs();
		document = new CustomXWPFDocument();
	    fos = new FileOutputStream(new File(Word_filePath));
	    
		Integer Counter=0;
		TreeSet<String> filenames = TakeScreenshot.getSortedFileSet();  
		while(filenames.contains(("Screenshot"+Counter.toString()+".jpeg")))
		{
	
		System.out.println("Image being copied is :"+System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\"+"Screenshot"+Counter.toString()+".jpeg");
		ToWord.addimage1(System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\"+"Screenshot"+Counter.toString()+".jpeg");
		Counter++;
	
		}	
		document.write(fos);
	    fos.flush();
	    fos.close();
	    
	    //file1.delete();
		
		
	}
	
	public static void addImage(String Path) throws IOException, InvalidFormatException 
	{
		//System.out.println("Path is "+ Path);
		File imageFile1 = new File(Path);
		BufferedImage bimg1 = ImageIO.read(imageFile1);
		int width1 = bimg1.getWidth();
		int height1 = bimg1.getHeight();
		
		String imgFile1 = imageFile1.getName();
		int imgFormat1 = XWPFDocument.PICTURE_TYPE_JPEG;
		r.addBreak();
		r.setText(imgFile1);
		r.addBreak();
		
		
		r.addPicture(new FileInputStream(imageFile1), imgFormat1, imgFile1, Units.toEMU(200), Units.toEMU(200));
		r.addBreak();
		r.addBreak(BreakType.PAGE);
		r.addBreak();
	
	}
	
	public static void addimage1(String Path) throws InvalidFormatException, IOException
	
	{
		XWPFParagraph par = document.createParagraph();
        XWPFRun run = par.createRun();
        
        run.setText(Path.substring(Path.lastIndexOf('\\'),Path.length()));
		
		String id = document.addPictureData(new FileInputStream(new File(Path)), Document.PICTURE_TYPE_JPEG);
	    document.createPicture(id,document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 900, 810);
	    

	    
	    
	}


	public static void addImage5(String Path)
	{
	
		 IDocument myDoc = new Document2004();
		 myDoc.addEle(Heading1.with("Heading01").create());
		 myDoc.addEle(Paragraph.with("This document is an example of paragraph").create());
		 myDoc.addEle(Image.from_FULL_LOCAL_PATHL(Path));
		 
		 File fileObj = new File(System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\doc1.doc");

		 PrintWriter writer = null;
		 try {
		     writer = new PrintWriter(fileObj);
		 } catch (FileNotFoundException e) {
		     e.printStackTrace();
		 }
		 String myWord = myDoc.getContent();

		 writer.println(myWord);
		 writer.close();
		 
	}

  public static void opendoc()
  {
	  try {
		     if (Desktop.isDesktopSupported()) {
		       Desktop.getDesktop().open(new File(Word_filePath));
		     }
		   } catch (IOException ioe) {
		     ioe.printStackTrace();
		  }
	  
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
	  
	 
		
		
	 	}
  
  
  	
  

  
}
