/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package model;

import java.time.LocalDate;

public class License {
    private String name;
    private String licenseNum;
    private LicenseClass licenseClass;
    private LocalDate dob;
    private LocalDate issDate;
    private LocalDate expDate;

    public License(String name, String licenseNum, LicenseClass licenseClass, LocalDate dob, LocalDate issDate, LocalDate expDate) {
        this.name = name;
        this.licenseNum = licenseNum;
        this.licenseClass = licenseClass;
        this.dob = dob;
        this.issDate = issDate;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public LicenseClass getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(LicenseClass licenseClass) {
        this.licenseClass = licenseClass;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getIssDate() {
        return issDate;
    }

    public void setIssDate(LocalDate issDate) {
        this.issDate = issDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
}