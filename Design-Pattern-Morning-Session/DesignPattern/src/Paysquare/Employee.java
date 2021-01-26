package Paysquare;

public interface Employee {
    public  int getId(); 
    public String getName(); 
    public String getEmail();
    public String getPhoneNumber(); 
    public double getSalary();  
    public void print();  
    public void add(Employee employee);  
    public void remove(Employee employee);  
    public Employee getChild(int i); 
    public String getnotifyMode();
    public void Notify();
    public String getdesignation();
}	

