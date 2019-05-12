package com.jacobsiau.studentapp.models;

/**
 * An entity class to represent Student entries in the Students table. 
 */
public class Student {

    private Long id;
    private String rnumber;
    private String firstname;
    private String lastname;
    private String graddate;
    private String department;
    private String major;
    private String minor;
    private String username;
    private String email;
    private String password;

    public Student() {
        super();
    }

    public Student(Long id, String rnumber, String firstname, String lastname, String graddate, String department, String major, String minor, String username, String email, String password) {
        super();
        this.id = id;
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.graddate = graddate;
        this.department = department;
        this.major = major;
        this.minor = minor;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Student(String rnumber, String firstname, String lastname, String graddate, String department, String major, String minor, String username, String email, String password) {
        super();
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.graddate = graddate;
        this.department = department;
        this.major = major;
        this.minor = minor;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the rnumber
     */
    public String getRnumber() {
        return rnumber;
    }
    
    /**
     * @param rnumber the rnumber to set
     */
    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the graddate
     */
    public String getGraddate() {
        return graddate;
    }

    /**
     * @param graddate the graddate to set
     */
    public void setGraddate(String graddate) {
        this.graddate = graddate;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the minor
     */
    public String getMinor() {
        return minor;
    }

    /**
     * @param minor the minor to set
     */
    public void setMinor(String minor) {
        this.minor = minor;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
            "Student: [" +
            "ID = %s, " +
            "R# = %s, " +
            "First Name = %s, " +
            "Last Name = %s, " + 
            "Grad Date = %s, " + 
            "Department = %s, " +
            "Major = %s, " +
            "Minor = %s, " +
            "Username = %s, " +
            "Email = %s, " + 
            "Password = %s]",
            id, rnumber, firstname, lastname, graddate, department, major, minor, username, email, password
        );
    }

}
