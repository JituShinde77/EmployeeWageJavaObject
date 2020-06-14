public interface IEmployeeWage{
	public static final int PRESENT = 1;
        public static final int PARTTIME = 2;
	public void addCompanyEmployee(String company, int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays, int maxWorkingHrs);
	public void computeEmployeeWage();
	public int getTotalEmployeeWage(Company company);
}
