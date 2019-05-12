package com.jacobsiau.studentapp.models;

/**
 * An entity class to represent Admin entries in the Admins table. 
 */
public class Admin {

    private Long id;
    private String rnumber;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;

    public Admin() {
        super();
    }

    public Admin(Long id, String rnumber, String firstname, String lastname, String username, String email, String password) {
        super();
        this.id = id;
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.lastname = lastname; 
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Admin(String rnumber, String firstname, String lastname, String username, String email, String password) {
        super();
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.lastname = lastname; 
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
            "Admin: [" +
            "R# = %s, " +
            "First Name = %s, " +
            "Last Name = %s, " + 
            "Username = %s, " +
            "Email = %s, " + 
            "Password = %s]",
            id, rnumber, firstname, lastname, username, email, password
        );
    }

}
