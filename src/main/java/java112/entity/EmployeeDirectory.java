package java112.entity;

import java.util.*;
import java.sql.*;

/**
  * This class will search for employees entered in a web appliaction, and will
  * also add new employees to the database.
  *
  * @author Elise Strauss
  * class EmployeeDirectory
  */
public class EmployeeDirectory {

    private Properties properties;

    /**
     * Empty constructor for EmployeeDirectory
     */
    public EmployeeDirectory() {

    }

    /**
     * Constructor for EmployeeDirectory
     * @param properties The properties files for the web application
     */
    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }


    /**
      * This method will receive the Employee information, call a method
      * to make the db connection, create a SQL statement to insert the
      * employee into the db.
      *
      * @param firstName The employee's first name
      * @param lastName The employee's last name
      * @param social The employee's SSN
      * @param department The employee's department
      * @param roomNumber The employee's room number
      * @param phoneNumber The employee's phone number
      * @return message A message to the client
      */
    public String addEmployee(String firstName,
                            String lastName,
                            String social,
                            String department,
                            String roomNumber,
                            String phoneNumber) {

        Connection connection = null;
        Statement statement   = null;
        ResultSet resultSet   = null;
        String    query       = null;
        String message        = "";

        try {

            connection = makeConnection();
            statement = connection.createStatement();

            query     = createInsertQuery(firstName,lastName,social,department,
                                          roomNumber,phoneNumber);

            statement.executeUpdate(query);

            message = "Employee added successfully with new messasge";

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return message;
    }

    /**
     * This metohod will search the employee database
     * @param term The value to search for
     * @param type The DB column to search on
     * @return Search The Search object
     */
    public Search searchEmployeeDB(String term, String type) {

        Search searchClass = new Search();

        searchClass.setSearchTerm(term);
        searchClass.setSearchType(type);
        searchEmployee(searchClass);

        return searchClass;
    }

    /**
     * This method will search for an employee id in the database
     *
     * @param searchClass The class that will return the results back to browser
     */
    private void searchEmployee(Search searchClass) {

        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";

        try {

            statement = makeConnection().createStatement();
            queryString = createSelectQuery(searchClass);
            resultSet = statement.executeQuery(queryString);

            createSearchArray(searchClass, resultSet);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * This method will add the employee's to the Search Arraylist
     * @param searchClass The Search class
     * @param resultSet  The resultset
     * @throws SQLException  a SQL exception
     */
    public void createSearchArray(Search searchClass, ResultSet resultSet)
             throws SQLException {

        while (resultSet.next()) {

            Employee employee = new Employee();

            employee.setEmployeeId(resultSet.getString("emp_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setEmployeeSsn(resultSet.getString("ssn"));
            employee.setDepartment(resultSet.getString("dept"));
            employee.setRoomNumber(resultSet.getString("room"));
            employee.setPhoneNumber(resultSet.getString("phone"));

            searchClass.addFoundEmployee(employee);
        }
    }

    /**
     * This method will build the query to insert new employees
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param social The employee's SSN
     * @param department The employee's department
     * @param roomNumber The employee's room number
     * @param phoneNumber The employee's phone number
     * @return query The Sql statement
     */
    public String createInsertQuery(String firstName,  String lastName,
                                    String social,     String department,
                                    String roomNumber, String phoneNumber) {

        String query = "INSERT into employees"
                     + " (first_name, last_name, ssn, dept, room, phone)"
                     + " VALUES ('" + firstName   + "', '"
                                    + lastName    + "', '"
                                    + social      + "', '"
                                    + department  + "', '"
                                    + roomNumber  + "', '"
                                    + phoneNumber + "')";
        return query;
    }

    /**
     * This method will construct the query String for each search
     *
     * @param searchClass The seach object with results
     * @return query The SQL statement that will be executed
     */
    public String createSelectQuery(Search searchClass) {

        String searchArgument = "";
        String query          = "";
        String type           = searchClass.getSearchType();

        if (type.equals("emp_id")) {
            searchArgument = type + " = " + searchClass.getSearchTerm();
        } else {
            searchArgument = type + " like '" + searchClass.getSearchTerm() + "%'";
        }

        query = "SELECT emp_id, first_name, last_name, ssn, dept,"
              + " room, phone FROM employees WHERE " + searchArgument;

        return query;
    }


    /**
      * This method will establish a db connection and return the connection
      * to the calling method
      *
      * @return connection The connection to the database
      */
    private Connection makeConnection() {

        Connection connection = null;

        try {

            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

        return connection;
    }
}