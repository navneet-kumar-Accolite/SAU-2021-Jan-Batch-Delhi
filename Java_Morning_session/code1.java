
import java.util.*;

public class code1 {
	static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {  
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Enter Numbers : Press 'q' to stop");
		String s;
		
        do{
            s = in.nextLine( );
            if(s.equals("q"))
                break;
            else
                list.add(Integer.parseInt(s));
        }while(!s.equals("q"));

        Collections.sort(list);


        System.out.println("Sorted numbers :\n" + list);
    }
}