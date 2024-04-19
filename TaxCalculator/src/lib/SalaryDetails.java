package lib;

public class SalaryDetails {
    private int grade;
    private boolean isForeigner;

    public SalaryDetails(int grade, boolean isForeigner) {
        this.grade = grade;
        this.isForeigner = isForeigner;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}
