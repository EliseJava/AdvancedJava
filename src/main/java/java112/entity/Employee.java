package java112.entity;

/**
 * This is an Employee java bean and will be used to store information for each
 * employee that was found on the database
 *
 * @author Elise Strauss
 * class Employee
 */
public class Employee {

   private String employeeId;
   private String firstName;
   private String lastName;
   private String employeeSsn;
   private String department;
   private String roomNumber;
   private String phoneNumber;

    /**
     * Constructor for Employee
     */
    public Employee() {
    }

    /**
     * Returns the value of employeeId.
     * @return employeeId The employee ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of employeeId.
     * @param employeeId The value to assign employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Returns the value of firstName.
     * @return firstName The Employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of firstName.
     * @param firstName The value to assign firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Returns the value of lastName.
     * @return lastName The employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of lastName.
     * @param lastName The value to assign lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Returns the value of employeeSSN.
     * @return employeeSSN The employee's employeeSSN
     */
    public String getEmployeeSsn() {
        return employeeSsn;
    }

    /**
     * Sets the value of employeeSSN.
     * @param employeeSsn The value to assign employeeSSN.
     */
    public void setEmployeeSsn(String employeeSsn) {
        this.employeeSsn = employeeSsn;
    }


    /**
     * Returns the value of department.
     * @return department The employee's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of department.
     * @param department The value to assign department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * Returns the value of roomNumber.
     * @return roomNumber The employee's room Number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of roomNumber.
     * @param roomNumber The value to assign roomNumber.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     * Returns the value of phoneNumber.
     * @return phoneNumber The employee's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of phoneNumber.
     * @param phoneNumber The value to assign phoneNumber.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
      * This method will return the information for an employee
      * @return employeeInformation The database query results
      */
    public String toString() {

        String employeeInformation = (getEmployeeId() + getFirstName()
                                    + getLastName() + getEmployeeSsn() + getDepartment()
                                    + getRoomNumber() + getPhoneNumber());

        return employeeInformation;
    }
}
