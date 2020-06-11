public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int ABSENT = 0;
	//private final int isPresent;
	public String checkAttendece(){
		int empCheck = (int)Math.floor(Math.random() * 10 ) %2;
		if (empCheck == PRESENT )
			return "Present";
		else
			return "Absent";
	}
	public static void main(String[] args){
		System.out.println("Welcome to Employee Wage..");
		EmployeeWage empWage = new EmployeeWage();
		System.out.println("Employee is: "+ empWage.checkAttendece());
	}
}
