public class Employee {
    private String firstName;
    private String lastName;
    private int employeeID;
    private double salary;

    public Employee() {
        this.salary = 0.0; // Initialize salary to zero
    }

    // Setters and getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    // Method to print employee summary
    public void employeeSummary() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + salary);
    }
 // Main method for testing
public static void main(String[] args) {
    // Create an instance of Employee for testing
    Employee emp = new Employee();
    emp.setFirstName("John");
    emp.setLastName("Doe");
    emp.setEmployeeID(1001);

    // Print employee summary
    emp.employeeSummary();
    }
}
