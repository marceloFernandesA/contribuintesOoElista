package entities;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer() {

    }

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {

        if (salaryIncome <= 36000) {
            return getSalaryIncome() * 0;
        } else if (salaryIncome <= 60000) {
            return getSalaryIncome() * 0.10;

        } else {
            return getSalaryIncome() * 0.20;
        }

    }

    public double servicesTax() {
        if (getServicesIncome() > 0) {
            return getServicesIncome() * 0.15;
        }
        return 0;
    }


    public double capitalTax() {
        if (getCapitalIncome() > 0) {
            return getCapitalIncome() * 0.20;
        }
        return 0;
    }


    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }


    public double taxRebate() {
        if((getHealthSpending() + getEducationSpending()) < (grossTax() * 0.30)){
            return getHealthSpending() + getEducationSpending();
        }else {
            return grossTax() * 0.30;
        }
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }
}
