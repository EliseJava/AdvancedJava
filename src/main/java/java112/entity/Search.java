package java112.entity;

import java.util.*;

/**
 * This class will be used to store database query results which will be
 * stored as Employee objects in an ArrayList
 *
 * @author Elise Strauss
 * class Search
 */
public class Search {

    private String    searchType;
    private String    searchTerm;
    private ArrayList<Employee> queryResults;
    private boolean   employeeFound;


    /**
     * Constructor for Search
     */
    public Search() {
        queryResults = new ArrayList<Employee>();
    }


    /**
     * Returns the value of searchType.
     * @return searchType
     */
    public String getSearchType() {
        return searchType;
    }


    /**
     * Sets the value of searchType.
     * @param searchType The value to assign searchType.
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


    /**
     * Returns the value of searchTerm.
     * @return searchTerm
     */
    public String getSearchTerm() {
        return searchTerm;
    }


    /**
     * Sets the value of searchTerm.
     * @param searchTerm The value to assign searchTerm.
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    /**
     * Returns the value of queryResults.
     * @return queryResults
     */
    public ArrayList getQueryResults() {
        return queryResults;
    }

    /**
     * Sets the value of queryResults.
     * @param queryResults The value to assign queryResults.
     */
    public void setQueryResults(ArrayList queryResults) {
        this.queryResults = queryResults;
    }


    /**
     * Returns the value of employeeFound.
     * @return employeeFound
     */
    public boolean getEmployeeFound() {
        return employeeFound;
    }


    /**
     * Sets the value of employeeFound.
     * @param employeeFound The value to assign employeeFound.
     */
    public void setEmployeeFound(boolean employeeFound) {
        this.employeeFound = employeeFound;
    }

    /**
     * This method will add the employee object to the List of Found Employee
     * objects the ArrayList
     *
     * @param employee Add the employee object to the array of employees
     */
    public void addFoundEmployee(Employee employee) {

        employeeFound = true;
        queryResults.add(employee);
    }
}

