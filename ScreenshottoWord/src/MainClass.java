
public class MainClass {
	
	
	public static void main(String args[])
	{
		
		Frontend.intiate_GUI();
		
		try {
			
		TakeScreenshot.Takescreenshot("Hula");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
