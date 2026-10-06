package com.wipro.empvalidation.service;

import com.wipro.empvalidation.bean.EmployeeBean;
import com.wipro.empvalidation.bean.ValidationResult;
import com.wipro.empvalidation.util.ValidationException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class responsible for generating summary reports using Java Streams API.
 */
public class ReportGeneratorService {

    /**
     * Generates a clean, formatted validation summary report string.
     * Uses Streams API for counting, filtering, and grouping records.
     *
     * @param results List of ValidationResult objects
     * @return Formatted summary report string
     */
    public String generateSummary(List<ValidationResult> results) {
        if (results == null || results.isEmpty()) {
            return "No validation results available.";
        }

        // Count total employees using Streams
        long totalEmployees = results.stream().count();

        // Count valid employees using Streams filter() and count()
        long validEmployees = results.stream()
                .filter(ValidationResult::isValid)
                .count();

        // Count invalid employees using Streams filter() and count()
        long invalidEmployees = results.stream()
                .filter(r -> !r.isValid())
                .count();

        // Group invalid employees by failure reason using Streams (flatMap + groupingBy)
        Map<String, List<EmployeeBean>> invalidByReason = results.stream()
                .filter(r -> !r.isValid())
                .flatMap(res -> res.getFailureReasons().stream()
                        .map(reason -> new AbstractMap.SimpleEntry<>(reason, res.getEmployee())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        // Build formatted console summary report
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("EMPLOYEE VALIDATION REPORT\n");
        sb.append("==================================================\n\n");

        sb.append(String.format("Total Employees   : %d\n", totalEmployees));
        sb.append(String.format("Valid Employees   : %d\n", validEmployees));
        sb.append(String.format("Invalid Employees : %d\n", invalidEmployees));

        if (!invalidByReason.isEmpty()) {
            invalidByReason.forEach((reason, empList) -> {
                sb.append("\n--------------------------------------------------\n\n");
                sb.append("Failure Reason : ").append(reason).append("\n\n");
                empList.forEach(emp -> sb.append(emp.getEmpId()).append(" - ").append(emp.getName()).append("\n"));
            });
        }

        sb.append("\n==================================================\n");
        return sb.toString();
    }

    /**
     * Main method demonstrating validation execution, sample dataset, and exception handling.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        EmployeeValidatorService validatorService = new EmployeeValidatorService();
        ReportGeneratorService reportService = new ReportGeneratorService();

        System.out.println("--- Test Case 1: 5 Employees (3 Valid, 2 Invalid Email) ---\n");

        List<EmployeeBean> testList1 = new ArrayList<>();
        testList1.add(new EmployeeBean("E101", "Anand", "anand@wipro.com", "9876543210", "ABCDE1234F"));
        testList1.add(new EmployeeBean("E102", "Priya", "priya.invalidemail", "8765432109", "BCDEF2345G")); // Invalid Email
        testList1.add(new EmployeeBean("E103", "Rahul", "rahul@wipro.com", "9765432109", "CDEFG3456H"));
        testList1.add(new EmployeeBean("E104", "Kavi", "kavi@wipro.com", "7654321098", "DEFGH4567I"));
        testList1.add(new EmployeeBean("E105", "Arun", "arun.wipro.com", "9123456789", "EFGHI5678J")); // Invalid Email

        try {
            List<ValidationResult> results1 = validatorService.validateAll(testList1);
            System.out.println(reportService.generateSummary(results1));
        } catch (ValidationException e) {
            System.err.println(e);
        }

        System.out.println("\n--- Test Case 2: Comprehensive Multi-Failure Scenario ---\n");

        List<EmployeeBean> testList2 = new ArrayList<>();
        testList2.add(new EmployeeBean("E101", "Anand", "anand@wipro.com", "9876543210", "ABCDE1234F"));
        testList2.add(new EmployeeBean("E102", "Priya", "priya.invalidemail", "8765432109", "BCDEF2345G")); // Invalid Email
        testList2.add(new EmployeeBean("E103", "Rahul", "rahul@wipro.com", "5765432109", "CDEFG3456H"));    // Invalid Phone
        testList2.add(new EmployeeBean("E104", "Kavi", "kavi@wipro.com", "7654321098", "INVALIDPAN"));    // Invalid PAN
        testList2.add(new EmployeeBean("E105", "Arun", "arun.wipro.com", "9123456789", "EFGHI5678J"));    // Invalid Email

        try {
            List<ValidationResult> results2 = validatorService.validateAll(testList2);
            System.out.println(reportService.generateSummary(results2));
        } catch (ValidationException e) {
            System.err.println(e);
        }

        System.out.println("\n--- Test Case 3: Empty List ValidationException ---\n");

        try {
            validatorService.validateAll(new ArrayList<>());
        } catch (ValidationException e) {
            System.out.println(e);
        }
    }
}
