import java.lang.*;
import com.test.arrays.chunkactions;
import com.pattern.Patern_printer;
import com.practice.series.Print_series;
import java.util.*;
public class Helloworld {
	public static void main (String args[])
	{
		System.out.println("hello world changed");
		Patern_printer p = new Patern_printer();
		p.upperhalfdiamond(6);
		p.lowerhalfdiamond(6);
		chunkactions ca = new chunkactions();
		List<Object> intarraylist = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11);
		//intarraylist = [0,1,2,3,4,5,6,7,8,9,10,11];
		ca.replacechunks(new ArrayList<Object>(intarraylist), intarraylist.size(), 3);
		Print_series ps = new Print_series();
		ps.print_tribonici_series(10);
		List<Integer> intarraylist2 = Arrays.asList(0,1,10,-3,-9,-7,6,4,-10,3,7,-9);
		ps.print_maximum_P_seq(new ArrayList<Integer>(intarraylist2));
		
	}

}
