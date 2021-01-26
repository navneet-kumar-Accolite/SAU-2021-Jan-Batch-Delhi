package Paysquare;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List; 

public class staff implements Employee{
	 private int id;
     private String name, Email, PhoneNumber, designation, notifyMode;
     private double salary;  
     
     public staff(int id,String name,String Email,String PhoneNumber,double salary,String notifyMode,String designation) {  
      this.id=id;      
      this.name = name;  
      this.Email=Email;
      this.PhoneNumber=PhoneNumber;
      this.salary = salary; 
      this.notifyMode=notifyMode;
      this.designation=designation;
     }  
     List<Employee> employees = new ArrayList<Employee>();  
     @Override  
     public void add(Employee employee) {  
        employees.add(employee);  
     }  
        @Override  
     public Employee getChild(int i) {  
      return employees.get(i);  
     }  
     @Override  
     public void remove(Employee employee) {  
      employees.remove(employee);  
     }    
     @Override
     public int getId()  {  
      return id;  
     }  
     @Override  
     public String getName() {  
      return name;  
     }  
     @Override  
     public String getEmail() {  
      return Email;  
     }  
     @Override  
     public String getPhoneNumber() {  
      return PhoneNumber;  
     }  
    @Override  
     public double getSalary() {  
      return salary;  
     }  
    @Override
    public String getnotifyMode() {
    	return notifyMode;
    }
    @Override
    public String getdesignation() {
    	return designation;
    }
    @Override
    public void Notify()
    {
		if(notifyMode=="SMS")
			System.out.println("SMS sent: Dear employee your Salary is updated");
		else if(notifyMode == "Email")
			System.out.println("Email sent: Dear employee your Salary is updated");
		else {
			// dont't discuss
		}

		Iterator<Employee> it = employees.iterator();  
        while(it.hasNext())  {  
          Employee emp = it.next();  
          System.out.println("Dear " + emp.getName() + " your account is updated with " + emp.getSalary());  
       } 
    }
     @Override  
     public void print() {   
      System.out.println("Designation: "+getdesignation());
      System.out.println("Id: "+getId());  
      System.out.println("Name: "+getName());  
      System.out.println("Email: "+getEmail());  
      System.out.println("Phone Number: "+getPhoneNumber());  
      System.out.println("Salary: "+getSalary()+"\n");   
        
      Iterator<Employee> it = employees.iterator();  
        
          while(it.hasNext())  {  
            Employee employee = it.next();  
            employee.print();  
         }  
     }  

}