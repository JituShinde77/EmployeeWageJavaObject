public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int ABSENT = 0;

	private final int wagePerHour;
	private final int dayHours;

	public EmployeeWage(int wagePerHour, int dayHours){
                this.wagePerHour = wagePerHour;
		this.dayHours = dayHours;
        }

	public int checkAttendence(){
                int empCheck = (int)Math.floor(Math.random() * 10 ) %2;
                if (empCheck == PRESENT )
                        return PRESENT;
                else
                        return ABSENT;
        }

	public int getDailyEmplyeeWage(){
		int isPresent = checkAttendence();
		int dailyWage = 0;
		if (isPresent == 1){
			dailyWage = wagePerHour * dayHours;
		}
		return dailyWage;
	}
	public static void main(String[] args){
		System.out.println("Welcome to Employee Wage..");
		EmployeeWage empWage = new EmployeeWage(20, 8);
		System.out.println("Employee Daily wage is: "+empWage.getDailyEmplyeeWage());
	}
}
