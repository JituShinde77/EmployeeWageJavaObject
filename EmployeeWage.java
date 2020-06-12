public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int ABSENT = 0;
	private static final int PARTTIME = 2;

	private final int wagePerHour;
	private final int dayHrs;
	private final int partTimeHrs;
	private final int maxWorkingDays;

	public EmployeeWage(int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays){
      		this.wagePerHour = wagePerHour;
     		this.dayHrs = dayHrs;
		this.partTimeHrs = partTimeHrs;
		this.maxWorkingDays = maxWorkingDays;
   	}

   	public int getEmpHrs(){
      		int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
      		switch(empCheck){
        		case PRESENT:
            			return dayHrs;
         		case PARTTIME:
            			return partTimeHrs;
		}
		return 0;
   	}

  	 public int getTotalEmplyeeWage(){
		int totalWage = 0;
		int workingDays = 0;
		while (workingDays < 20){
   			int empHrs = getEmpHrs();
     			int dailyWage = 0;
      			dailyWage = wagePerHour * empHrs;
			totalWage = totalWage + dailyWage;
			++workingDays;
		}
      		return totalWage;
   	}

   	public static void main(String[] args){
   		System.out.println("Welcome to Employee Wage..");
    		EmployeeWage empWage = new EmployeeWage(20, 8, 4, 20);
      		System.out.println("Employee Total Employee wage for month is: "+empWage.getTotalEmplyeeWage());
   	}
}
