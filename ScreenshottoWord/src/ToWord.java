import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



public class ToWord {
	
	
	String Temp_dir = System.getProperty("java.io.tmpdir");
	
	static XWPFDocument doc = new XWPFDocument();
	static XWPFParagraph p; 
	static XWPFRun r ;
	
	
	public static void addImagetoWord() throws IOException, InvalidFormatException
	{
		
		System.out.println("Values of Word file initialized");
		
		System.out.println("Value of doc is "+doc);
		p = doc.createParagraph();
		r = p.createRun();
		Integer Counter=0;
		TreeSet<String> filenames = TakeScreenshot.getSortedFileSet();  
		while(filenames.contains(("Screenshot"+Counter.toString()+".jpeg")))
		{
	
		System.out.println("Image being copied is :"+System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\"+"Screenshot"+Counter.toString()+".jpeg");
		ToWord.addImage(System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\"+"Screenshot"+Counter.toString()+".jpeg");
		Counter++;
	
		}
	
	
		
	FileOutputStream out = new FileOutputStream(System.getProperty("user.home") + "\\Desktop"+"\\Images"+"\\"+"word_images.docx");
		System.out.println(out);
		doc.write(out);
		out.close();
		//doc.close();
		
	}
	
	public static void addImage(String Path) throws IOException, InvalidFormatException 
	{
		System.out.println("Path is "+ Path);
		File imageFile1 = new File(Path);
		BufferedImage bimg1 = ImageIO.read(imageFile1);
		int width1 = bimg1.getWidth();
		int height1 = bimg1.getHeight();
		
		String imgFile1 = imageFile1.getName();
		int imgFormat1 = XWPFDocument.PICTURE_TYPE_JPEG;
		r.addBreak();
		r.setText(imgFile1);
		r.addBreak();
		
		
		r.addPicture(new FileInputStream(imageFile1), imgFormat1, imgFile1, Units.toEMU(width1), Units.toEMU(height1));
		r.addBreak();
		r.addBreak(BreakType.PAGE);
		r.addBreak();
	
	}
	
	
	

}
