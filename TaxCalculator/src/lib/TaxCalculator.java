package lib;

public class TaxCalculator {
    public static int calculateIncomeTax(int monthlySalary, int otherMonthlyIncome, int monthsWorkedInYear, int annualDeductible, boolean noSpouse, int numChildren) {
        int taxableIncome = monthlySalary * monthsWorkedInYear + otherMonthlyIncome * monthsWorkedInYear - annualDeductible;
        int tax = calculateTaxAmount(taxableIncome);
        return tax;
    }

    private static int calculateTaxAmount(int taxableIncome) {
        double taxPercentage;
        if (taxableIncome <= 50000000) {
            taxPercentage = 0.05;
        } else if (taxableIncome <= 250000000) {
            taxPercentage = 0.15;
        } else {
            taxPercentage = 0.25;
        }
        return (int) (taxableIncome * taxPercentage);
    }
}

