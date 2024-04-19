package lib;

public class SalaryCalculator {
    public static void setMonthlySalary(Employee employee, SalaryDetails salaryDetails) {
        int grade = salaryDetails.getGrade();
        boolean isForeigner = salaryDetails.isForeigner();
        int monthlySalary = 0;

        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary = (int) (5000000 * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary = (int) (7000000 * 1.5);
            }
        }

        employee.setMonthlySalary(monthlySalary, isForeigner);
    }
}
