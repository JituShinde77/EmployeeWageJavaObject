public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int ABSENT = 0;
	private static final int PARTTIME = 2;

	private final int wagePerHour;
	private final int dayHrs;
	private final int partTimeHrs;

	public EmployeeWage(int wagePerHour, int dayHrs, int partTimeHrs){
                this.wagePerHour = wagePerHour;
                this.dayHrs = dayHrs;
		this.partTimeHrs = partTimeHrs;
        }

        public int getEmpHrs(){
                int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
                if (empCheck == PRESENT )
                        return dayHrs;
                else if (empCheck == PARTTIME)
                        return partTimeHrs;
		else
			return 0;
        }

        public int getDailyEmplyeeWage(){
                int empHrs = getEmpHrs();
                int dailyWage = 0;
                dailyWage = wagePerHour * empHrs;
                return dailyWage;
        }
        public static void main(String[] args){
                System.out.println("Welcome to Employee Wage..");
                EmployeeWage empWage = new EmployeeWage(20, 8, 4);
                System.out.println("Employee Daily wage is: "+empWage.getDailyEmplyeeWage());
        }
}
