public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int ABSENT = 0;
	private static final int PARTTIME = 2;

	private final int wagePerHour;
	private final int dayHrs;
	private final int partTimeHrs;
	private final int maxWorkingDays;
	private final int maxWorkingHrs;
	private final String company;

	public EmployeeWage(String company, int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays, int maxWorkingHrs){
      		this.company = company;
		this.wagePerHour = wagePerHour;
     		this.dayHrs = dayHrs;
		this.partTimeHrs = partTimeHrs;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHrs = maxWorkingHrs;
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

  	 public int getTotalEmployeeWage(){
		int totalWage = 0;
		int workingDays = 0;
		int workingHrs = 0;
		while (workingDays < maxWorkingDays && workingHrs < maxWorkingHrs){
   			int empHrs = getEmpHrs();
     			int dailyWage = 0;
      			dailyWage = wagePerHour * empHrs;
			totalWage = totalWage + dailyWage;
			++workingDays;
			workingHrs = workingHrs + empHrs;
		}
		if (workingHrs > maxWorkingHrs)
			return wagePerHour * maxWorkingHrs;
      		return totalWage;
   	}

   	public static void main(String[] args){
   		System.out.println("Welcome to Employee Wage..");
    		EmployeeWage empDMart = new EmployeeWage("DMart", 20, 8, 4, 20, 100);
		EmployeeWage empReliance = new EmployeeWage("Reliance", 24, 9, 5, 25, 120);
		EmployeeWage empBigBasket = new EmployeeWage("BigBasket", 20, 8, 5, 24, 120);
      		System.out.println("Employee Total wage of Company: "+ empDMart.company +" and month wage is: "+empDMart.getTotalEmployeeWage());
		System.out.println("Employee Tatal wage of Company: "+ empReliance.company +" and month wage is: "+ empReliance.getTotalEmployeeWage());
		System.out.println("Employee Tatal wage of Company: "+ empBigBasket.company +" and month wage is: "+ empBigBasket.getTotalEmployeeWage());
   	}
}
