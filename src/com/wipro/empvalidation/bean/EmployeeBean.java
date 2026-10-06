package com.wipro.empvalidation.bean;

/**
 * Bean class representing Employee details.
 */
public class EmployeeBean {

    private String empId;
    private String name;
    private String email;
    private String phone;
    private String pan;

    /**
     * Default constructor
     */
    public EmployeeBean() {
    }

    /**
     * Parameterized constructor
     *
     * @param empId Employee ID
     * @param name  Employee Name
     * @param email Employee Email Address
     * @param phone Employee Phone Number
     * @param pan   Employee PAN Number
     */
    public EmployeeBean(String empId, String name, String email, String phone, String pan) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pan = pan;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }
}
