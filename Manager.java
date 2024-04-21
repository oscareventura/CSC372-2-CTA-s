public class Manager extends Employee {
    private String department;

    // Constructor
    public Manager() {
        // Call superclass constructor
        super();
    }

    // Setter and getter for department
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    // Method to print manager summary
    public void managerSummary() {
        // Call superclass method to print employee summary
        super.employeeSummary();
        System.out.println("Department: " + department);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of Manager for testing
        Manager manager = new Manager();
        manager.setFirstName("Alice");
        manager.setLastName("Smith");
        manager.setEmployeeID(2001);
        manager.setDepartment("HR");

        // Print manager summary
        manager.managerSummary();
    }
}
