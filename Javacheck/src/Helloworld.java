import java.lang.*;
import com.pattern.Patern_printer;
import java.util.*;
public class Helloworld {
	public static void main (String args[])
	{
		System.out.println("hello world changed");
		Patern_printer p = new Patern_printer();
		p.upperhalfdiamond(5);
		p.lowerhalfdiamond(5);
	}

}
