package Paysquare;

import java.time.LocalDate;
import java.time.Month;

public class Application{
	public static void main(String args[]){
	      staff emp1=new staff(103,"Navneet","nk@gmail.com","789574585", 600000.0,"SMS","Senior Software Engineer"); 
	      staff emp2=new staff(100,"Kumar","kn@gmail.com","9823544575",500000.0,"EMAIL","HR");
	      staff emp3=new staff(102,"Ansuk","ans@gmail.com","9856512655", 350000.0,"EMAIL","Software Engineer");  
	      staff emp4=new staff(101,"Dipa","abc@gmail.com","8785147852", 200000.0,"SMS","Intern");
	      staff ceo=new staff(100,"Manos","ma@gmail.com","9851123545",1000000.0,"EMAIL","CEO");  
	     
	      ceo.add(emp1);  
	      ceo.add(emp2);  
	      ceo.add(emp3);
	      ceo.add(emp4);
	      ceo.add(ceo);
	          
	          System.out.println("Sending notifications for the salary updation: ");
//	          LocalDate currentdate = LocalDate.now();
//	          Month month = currentdate.getMonth();
//	          int year = currentdate.getYear();
//	          System.out.println("Date: 15 "+month + " "+year+" 3:00 PM\n");

	          ceo.Notify();
	        }  
}