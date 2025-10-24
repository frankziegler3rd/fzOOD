package model;
import java.time.LocalDate;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Insurance {

    private String company;
    private String policyNumber;
    private LocalDate effectiveDate;
    private LocalDate expDate;
    private double minimumLiability;

    public Insurance(String company, String policyNumber, LocalDate effectiveDate, LocalDate expDate, double minimumLiability) {
        this.company = company;
        this.policyNumber = policyNumber;
        this.effectiveDate = effectiveDate;
        this.expDate = expDate;
        this.minimumLiability = minimumLiability;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public double getMinimumLiability() {
        return minimumLiability;
    }

    public void setMinimumLiability(double minimumLiability) {
        this.minimumLiability = minimumLiability;
    }
}