import java.util.ArrayList;
public class Company{
	public final String company;
	public final int wagePerHour;
        public final int dayHrs;
        public final int partTimeHrs;
        public final int maxWorkingDays;
        public final int maxWorkingHrs;
	public int totalWage;
	public ArrayList<Integer> dailyWage = new ArrayList<Integer>();

        public Company(String company, int wagePerHour, int dayHrs, int partTimeHrs, int maxWorkingDays, int maxWorkingHrs){
                this.company = company;
                this.wagePerHour = wagePerHour;
                this.dayHrs = dayHrs;
                this.partTimeHrs = partTimeHrs;
                this.maxWorkingDays = maxWorkingDays;
                this.maxWorkingHrs = maxWorkingHrs;
        }
	public void getTotalWage(int totalWage){
		this.totalWage = totalWage;
	}
	public void storeDailyWage(ArrayList<Integer> dailyWage )
	{
		this.dailyWage = dailyWage;
	}
}

