import java.util.ArrayList;
public class EmployeeWage{

	private static final int PRESENT = 1;
	private static final int PARTTIME = 2;
	private ArrayList<Company> companyArray;
	private int numberOfEmployee = 0;

	public EmployeeWage(){
		companyArray = new ArrayList<Company>();
	}

	public void addCompanyEmployee(String company, int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays, int maxWorkingHrs)
	{
		Company comp = new Company(company, wagePerHour, dayHrs, partTimeHrs, maxWorkingDays, maxWorkingHrs);
		companyArray.add(comp);
		numberOfEmployee++;
	}

   	public int getEmpHrs(Company comp){
      		int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
      		switch(empCheck){
        		case PRESENT:
            			return comp.dayHrs;
         		case PARTTIME:
            			return comp.partTimeHrs;
		}
		return 0;
   	}

	public void computeEmployeeWage(){
		for (int i=0; i< numberOfEmployee; i++)
			System.out.println("Employee "+getTotalEmployeeWage(companyArray.get(i)));
	}

  	public int getTotalEmployeeWage(Company company){
		int totalWage = 0;
		int workingDays = 0;
		int workingHrs = 0;
		while (workingDays < company.maxWorkingDays && workingHrs < company.maxWorkingHrs){
   			int empHrs = getEmpHrs(company);
     			int dailyWage = 0;
      			dailyWage = company.wagePerHour * empHrs;
			totalWage = totalWage + dailyWage;
			++workingDays;
			workingHrs = workingHrs + empHrs;
		}
		if (workingHrs > company.maxWorkingHrs)
			return company.wagePerHour * company.maxWorkingHrs;
      		return totalWage;
   	}

   	public static void main(String[] args){
   		System.out.println("Welcome to Employee Wage..");
		EmployeeWage employeeWage = new EmployeeWage();
    		employeeWage.addCompanyEmployee("DMart", 20, 8, 4, 20, 100);
		employeeWage.addCompanyEmployee("Reliance", 24, 9, 5, 25, 120);
		employeeWage.addCompanyEmployee("BigBasket", 20, 8, 5, 24, 120);
		employeeWage.computeEmployeeWage();
      		//System.out.println("Employee Total wage of Company: "+ empDMart.company +" and month wage is: "+empDMart.getTotalEmployeeWage());
		//System.out.println("Employee Tatal wage of Company: "+ empReliance.company +" and month wage is: "+ empReliance.getTotalEmployeeWage());
		//System.out.println("Employee Tatal wage of Company: "+ empBigBasket.company +" and month wage is: "+ empBigBasket.getTotalEmployeeWage());
   	}
}
