package com.wipro.empvalidation.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the validation status and details for an EmployeeBean.
 */
public class ValidationResult {

    private EmployeeBean employee;
    private boolean valid;
    private List<String> failureReasons;

    /**
     * Default constructor
     */
    public ValidationResult() {
        this.failureReasons = new ArrayList<>();
    }

    /**
     * Parameterized constructor
     *
     * @param employee       The EmployeeBean evaluated
     * @param valid          Validation status
     * @param failureReasons List of validation failure messages
     */
    public ValidationResult(EmployeeBean employee, boolean valid, List<String> failureReasons) {
        this.employee = employee;
        this.valid = valid;
        this.failureReasons = failureReasons != null ? failureReasons : new ArrayList<>();
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getFailureReasons() {
        return failureReasons;
    }

    public void setFailureReasons(List<String> failureReasons) {
        this.failureReasons = failureReasons;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "employee=" + employee +
                ", valid=" + valid +
                ", failureReasons=" + failureReasons +
                '}';
    }
}
