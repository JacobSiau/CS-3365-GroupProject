package com.jacobsiau.studentapp.repositories;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import com.jacobsiau.studentapp.mappers.AdminMapper;
import com.jacobsiau.studentapp.models.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The repository class to call database entry mapping methods via {@link com.jacobsiau.studentapp.mappers.AdminMapper}.
 */
@Repository
public class AdminRepository {

    // Logging
    private Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private AdminMapper _adminMapper;

    // Constructor
    public AdminRepository(AdminMapper _adminMapper) {
        this._adminMapper = _adminMapper;
    }

    /**
     * Retrieves all Admin entries from the Admins table. 
     * @return The list of Admin entries. 
     */
    public List<Admin> getAllAdmins() {
        LOGGER.debug("getAllAdmins called.");
        List<Admin> res = new ArrayList<>();
        res = _adminMapper.getAllAdmins();
        return res;
    }

    /**
     * Finds an Admin entry in the Admins table by the rnumber field.
     * @param rnumber The rnumber to find by. 
     * @return The single-item list containing the Admin matching the rnumber. 
     */
    public List<Admin> getAdminByRnumber(String rnumber) {
        LOGGER.debug("getAdminByRnumber called with rnumber: " + rnumber);
        List<Admin> res = new ArrayList<>();
        res = _adminMapper.getAdminByRnumber(rnumber);
        return res;
    }

    /**
     * Inserts an Admin entry into the Admins table. 
     * @param admin The Admin info to insert into the Admins table. 
     */
    public void insertAdmin(Admin admin) {
        LOGGER.debug("insertAdmin called with admin info: " + admin.toString());
        _adminMapper.insertAdmin(admin);
    }

    /**
     * Restarts numbering in the Admins table. 
     */
    public void updateAdminsNumbering() {
        LOGGER.debug("updateAdminsNumbering called.");
        _adminMapper.updateAdminsNumbering();
    }

    /**
     * Deletes an Admin entry in the Admins table by the rnumber column. 
     * @param rnumber The rnumber to delete by. 
     */
    public void deleteAdminByRnumber(String rnumber) {
        LOGGER.debug("deleteAdminByRnumber called with rnumber: " + rnumber);
        _adminMapper.deleteAdminByRnumber(rnumber);
    }

    /**
     * Deletes all Admins from the Admins table.
     */
    public void deleteAllAdmins() {
        LOGGER.debug("deleteAllAdmins called.");
        _adminMapper.deleteAllAdmins();
    }

}
