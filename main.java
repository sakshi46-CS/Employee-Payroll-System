import java.util.ArrayList;
import java.util.Scanner;

abstract class employee{
	private String name;
	private int id;
	
	public employee(String name,int id) {
		this.id=id;
		this.name=name;
	}
	public String getname() {
		return name;
	}
	public int getid() {
		return id;
	}
	public abstract double calculatesalary();
	@Override
	public String toString() {
		return "Employee[name="+name+",id="+id+",salary="+calculatesalary()+"]";
	}
}
class FullTimeEmployee extends employee{
	private double monthlysalary;

	
	public FullTimeEmployee(String name,int id,double monthlysalary) {
		super(name,id);
		this.monthlysalary=monthlysalary;
	}
	@Override
	public double calculatesalary() {
		return monthlysalary;
	}
	
}
class PartTimeEmployee extends employee{
	private int hoursworked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id,int hoursworked,double hourlyRate) {
		super(name,id);
		this.hourlyRate=hourlyRate;
		this.hoursworked=hoursworked;
	}
	@Override
	public double calculatesalary() {
		return hoursworked*hourlyRate;
	}
}
class payrollsystem{
	private ArrayList<employee>employeelist;
	
	public payrollsystem() {
		employeelist=new ArrayList<>();
	}
	public void addemployee(employee Employee) {
		employeelist.add(Employee);
	}
	public void removeemployee(int id) {
	employee employeeToremove=null;
	for(employee Employee:employeelist) {
		if(Employee.getid()==id) {
			employeeToremove=Employee;
			break;
		}
	}
	if(employeeToremove!=null) {
		employeelist.remove(employeeToremove);
	}
	}
	public void displayemployess() {
		for(employee Employee:employeelist) {
			System.out.println(Employee);
		}
	}
}
public class main {
public static void main(String[] args) {
	  payrollsystem payrollSystem = new payrollsystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nPayroll System Menu:");
	            System.out.println("1. Add Full-Time Employee");
	            System.out.println("2. Add Part-Time Employee");
	            System.out.println("3. Remove Employee");
	            System.out.println("4. Display All Employees");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Name: ");
	                    String fullName = scanner.nextLine();
	                    System.out.print("Enter ID: ");
	                    int fullId = scanner.nextInt();
	                    System.out.print("Enter Monthly Salary: ");
	                    double salary = scanner.nextDouble();
	                    payrollSystem.addemployee(new FullTimeEmployee(fullName, fullId, salary));
	                    System.out.println("Full-Time Employee Added.");
	                    break;

	                case 2:
	                    System.out.print("Enter Name: ");
	                    String partName = scanner.nextLine();
	                    System.out.print("Enter ID: ");
	                    int partId = scanner.nextInt();
	                    System.out.print("Enter Hours Worked: ");
	                    int hoursWorked = scanner.nextInt();
	                    System.out.print("Enter Hourly Rate: ");
	                    double hourlyRate = scanner.nextDouble();
	                    payrollSystem.addemployee(new PartTimeEmployee(partName, partId, hoursWorked, hourlyRate));
	                    System.out.println("Part-Time Employee Added.");
	                    break;

	                case 3:
	                    System.out.print("Enter Employee ID to Remove: ");
	                    int removeId = scanner.nextInt();
	                    payrollSystem.removeemployee(removeId);
	                    break;

	                case 4:
	                    System.out.println("Employee Details:");
	                    payrollSystem.displayemployess();
	                    break;

	                case 5:
	                    System.out.println("Exiting Payroll System.");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
}

}

