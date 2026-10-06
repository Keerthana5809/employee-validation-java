# Java Employee Validation Mini Project

A Java-based employee validation project that validates employee details such as **Email, Phone Number, and PAN Number** using Regular Expressions. The project also demonstrates **Java Exception Handling, Custom Exceptions, and validation reporting**.

## Project Structure

```text
java-mini-project/
│
├── src/
│   └── com/
│       └── wipro/
│           └── empvalidation/
│               ├── bean/
│               │   ├── EmployeeBean.java
│               │   └── ValidationResult.java
│               │
│               ├── service/
│               │   ├── EmployeeValidatorService.java
│               │   └── ReportGeneratorService.java
│               │
│               └── util/
│                   ├── RegexPatterns.java
│                   └── ValidationException.java
│
├── .gitignore
└── README.md
```

## Technologies Used

* Java
* Object-Oriented Programming
* Regular Expressions
* Exception Handling
* Custom Exception
* Java Streams

## Validations

The project validates:

* Email address
* Indian mobile number
* PAN number

## Requirements

Make sure Java JDK is installed.

Check Java:

```powershell
java -version
```

Check the Java compiler:

```powershell
javac -version
```

## How to Run the Project

### 1. Clone the Repository

```powershell
git clone https://github.com/Keerthana5809/employee-validation-java.git
```

Move into the project folder:

```powershell
cd employee-validation-java
```

### 2. Compile the Project

Compile all Java source files using:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
```

The compiled `.class` files will be generated inside the `out` folder.

### 3. Run the Program

The main method is present in:

```text
ReportGeneratorService.java
```

Run it using:

```powershell
java -cp out com.wipro.empvalidation.service.ReportGeneratorService
```

## Expected Output

The program runs multiple test cases.

Example:

```text
--- Test Case 1: 5 Employees (3 Valid, 2 Invalid Email) ---

==================================================
EMPLOYEE VALIDATION REPORT
==================================================

Total Employees   : 5
Valid Employees   : 3
Invalid Employees : 2

--------------------------------------------------

Failure Reason : Invalid Email

E102 - Priya
E105 - Arun

==================================================
```

The project also demonstrates multiple validation failures:

```text
Failure Reason : Invalid Email
E102 - Priya
E105 - Arun

Failure Reason : Invalid PAN
E104 - Kavi

Failure Reason : Invalid Phone
E103 - Rahul
```

It also demonstrates the custom exception:

```text
--- Test Case 3: Empty List ValidationException ---

ValidationException: Employee list cannot be empty
```

## Main Class

The application starts from:

```text
com.wipro.empvalidation.service.ReportGeneratorService
```

Run it with:

```powershell
java -cp out com.wipro.empvalidation.service.ReportGeneratorService
```

## Notes

The `out/` directory contains compiled Java `.class` files and is excluded from Git using `.gitignore`.

Source files are located inside the `src/` directory.
