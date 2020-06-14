import java.util.ArrayList;
public class EmployeeWage implements IEmployeeWage{

	private ArrayList<Company> companyArray;
	private int numberOfEmployee = 0;

	public EmployeeWage(){
		companyArray = new ArrayList<Company>();
	}

	public void addCompanyEmployee(String company, int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays, int maxWorkingHrs){
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
		for (int i=0; i< numberOfEmployee; i++){
			getTotalEmployeeWage(companyArray.get(i));
			System.out.println("Company: "+companyArray.get(i).company+ " Employee Wage :"+companyArray.get(i).totalWage);
		}
	}

  	public void getTotalEmployeeWage(Company company){
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
			company.getTotalWage(totalWage);
		//return company.wagePerHour * company.maxWorkingHrs;
      		//return totalWage;
		company.getTotalWage(totalWage);
   	}

   	public static void main(String[] args){
   		System.out.println("Welcome to Employee Wage..");
		EmployeeWage employeeWage = new EmployeeWage();
    		employeeWage.addCompanyEmployee("DMart", 20, 8, 4, 20, 100);
		employeeWage.addCompanyEmployee("Reliance", 24, 9, 5, 25, 120);
		employeeWage.addCompanyEmployee("BigBasket", 20, 8, 5, 24, 120);
		employeeWage.computeEmployeeWage();
   	}
}
