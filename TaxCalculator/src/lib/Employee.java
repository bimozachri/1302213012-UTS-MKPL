package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
     public void setMonthlySalary(int grade, boolean isForeigner) {
        SalaryDetails salaryDetails = new SalaryDetails(grade, isForeigner);
        SalaryCalculator.setMonthlySalary(this, salaryDetails);
    }
    
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		int monthWorkingInYear = calculateMonthsWorkedInYear();
		boolean hasSpouse = hasSpouse();
		int numChildren = getChildCount();
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, !hasSpouse, numChildren);
	}
	
	private int calculateMonthsWorkedInYear() {
		LocalDate currentDate = LocalDate.now();
		if (currentDate.getYear() == yearJoined) {
			return currentDate.getMonthValue() - monthJoined;
		} else {
			return 12;
		}
	}
	
	private boolean hasSpouse() {
		return spouseName != null && !spouseName.isEmpty();
	}
	
	private int getChildCount() {
		return childNames.size();
	}	
}
