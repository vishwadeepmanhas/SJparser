import java.io.File;

public class MainClass {
	
	
	public static void main(String args[])
	{
		deleteOlderIfExist();
		
		Frontend.intiate_GUI();
		
		try {
			
		TakeScreenshot.Takescreenshot("Hula");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	
	public static void deleteOlderIfExist()
	{
		 File dir = new File(System.getProperty("user.home") + "\\Desktop"+"\\Images");
		 
		 System.out.println("Path for images is : "+System.getProperty("user.home") + "\\Desktop"+"\\Images");
		 System.out.println("Path for word files is :"+System.getProperty("user.home")+"\\SStoWord\\");
		  	if(dir.isDirectory() == false) {
				System.out.println("Not a directory. Do nothing");
				return;
			}
			File[] listFiles = dir.listFiles();
			for(File file : listFiles){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println("Deleting "+file.getName()+"  "+file.delete());
				
			}
			//now directory is empty, so we can delete it
			System.out.println("Deleting Directory. Success = "+dir.delete());

			
			
		
	}
}
