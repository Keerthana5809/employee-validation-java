package com.wipro.empvalidation.service;

import com.wipro.empvalidation.bean.EmployeeBean;
import com.wipro.empvalidation.bean.ValidationResult;
import com.wipro.empvalidation.util.RegexPatterns;
import com.wipro.empvalidation.util.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class responsible for validating Employee records against regex rules.
 */
public class EmployeeValidatorService {

    /**
     * Validates a single EmployeeBean against Email, Phone, and PAN regex rules.
     * Collects all validation failure reasons without stopping at the first error.
     *
     * @param bean Employee record to validate
     * @return ValidationResult containing status and list of failure reasons
     */
    public ValidationResult validateEmployee(EmployeeBean bean) {
        List<String> failureReasons = new ArrayList<>();

        if (bean == null) {
            failureReasons.add("Null Employee Record");
            return new ValidationResult(null, false, failureReasons);
        }

        // Validate Email
        if (bean.getEmail() == null || !bean.getEmail().matches(RegexPatterns.EMAIL_REGEX)) {
            failureReasons.add("Invalid Email");
        }

        // Validate Phone (10 digits starting with 6-9)
        if (bean.getPhone() == null || !bean.getPhone().matches(RegexPatterns.PHONE_REGEX)) {
            failureReasons.add("Invalid Phone");
        }

        // Validate PAN (5 uppercase letters, 4 digits, 1 uppercase letter)
        if (bean.getPan() == null || !bean.getPan().matches(RegexPatterns.PAN_REGEX)) {
            failureReasons.add("Invalid PAN");
        }

        boolean isValid = failureReasons.isEmpty();
        return new ValidationResult(bean, isValid, failureReasons);
    }

    /**
     * Validates a batch of EmployeeBean records using Java Streams.
     *
     * @param list List of employee records
     * @return List of ValidationResult objects
     * @throws ValidationException if list is null or empty
     */
    public List<ValidationResult> validateAll(List<EmployeeBean> list) throws ValidationException {
        if (list == null || list.isEmpty()) {
            throw new ValidationException("Employee list cannot be empty");
        }

        return list.stream()
                .map(this::validateEmployee)
                .collect(Collectors.toList());
    }
}
