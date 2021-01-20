import java.util.*;

public class code2 {
	static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ArithmeticException{
        System.out.println("Enter two numbers");
        int number1 = in.nextInt();
        int number2 = in.nextInt();
        try {
			if(number2==0)
				throw new ArithmeticException();
			else
				System.out.println("Result : "+ (float) number1/number2);
        }
        catch(Exception e){
            System.out.println("Divide by zero exception");
		}
    }
}