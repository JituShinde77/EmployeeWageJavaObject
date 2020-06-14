import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class EmployeeWage implements IEmployeeWage{

	private ArrayList<Company> companyArray;
	private Map<String, Integer> companyWageMap;
	private int numberOfEmployee = 0;

	public EmployeeWage(){
		companyArray = new ArrayList<Company>();
		companyWageMap = new HashMap<>();
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
			int pastWage = 0;
			System.out.println("Day         TodayWage         Total Wage");
			for (int j=0; j<companyArray.get(i).dailyWage.size(); j++){

				System.out.println("Day: "+ j +"\t\t"+(companyArray.get(i).dailyWage.get(j)-pastWage)+"\t\t"+companyArray.get(i).dailyWage.get(j));
				pastWage = companyArray.get(i).dailyWage.get(j);
			}
		        System.out.println("------------------------------------------------------------");
		}
	}

	public void wagePerCompany()
	{
		Set set= companyWageMap.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext()){
        		Map.Entry entry=(Map.Entry)itr.next();
        		System.out.println(entry.getKey()+":"+entry.getValue());
    		}
	}

  	public void getTotalEmployeeWage(Company company){
		int totalWage = 0, workingDays = 0, workingHrs = 0;
		ArrayList<Integer> dailyWageArray = new ArrayList<Integer>();
		while (workingDays < company.maxWorkingDays && workingHrs < company.maxWorkingHrs){
   			int empHrs = getEmpHrs(company);
     			int dailyWage = 0;
      			dailyWage = company.wagePerHour * empHrs;
			totalWage = totalWage + dailyWage;
			dailyWageArray.add(totalWage);
			++workingDays;
			workingHrs = workingHrs + empHrs;
		}
		if (workingHrs > company.maxWorkingHrs)
			company.getTotalWage(totalWage);
		company.storeDailyWage(dailyWageArray);
		company.getTotalWage(totalWage);
		companyWageMap.put(company.company, totalWage);
   	}

   	public static void main(String[] args){
   		System.out.println("Welcome to Employee Wage..");
		EmployeeWage employeeWage = new EmployeeWage();
    		employeeWage.addCompanyEmployee("DMart", 20, 8, 4, 20, 100);
		employeeWage.addCompanyEmployee("Reliance", 24, 9, 5, 25, 120);
		employeeWage.addCompanyEmployee("BigBasket", 20, 8, 5, 24, 120);
		employeeWage.computeEmployeeWage();
		employeeWage.wagePerCompany();
   	}
}
