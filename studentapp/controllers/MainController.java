package com.jacobsiau.studentapp.controllers;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import com.jacobsiau.studentapp.models.Student;
import com.jacobsiau.studentapp.models.Admin;
import com.jacobsiau.studentapp.repositories.AdminRepository;
import com.jacobsiau.studentapp.repositories.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The main controller of this API.
 */
@Controller
@CrossOrigin(origins = "http://localhost:4200/")
public class MainController {

    // Logging
    private Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Autowired
    private AdminRepository _adminRepository;

    @Autowired
    private StudentRepository _studentRepository;

    /**
     * Retrieves all Student entries from the Students table.
     * @return The list of Student entries.
     */
    @ResponseBody
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        LOGGER.debug("/students requested.");
        return _studentRepository.getAllStudents();
    }

    /**
     * Finds a Student entry in the Students table by the rnumber column. 
     * @param rnumber The rnumber to find by.
     * @return A single item list of the Student that matches the rnumber.
     */
    @ResponseBody
    @GetMapping("/findstudent")
    public List<Student> getStudentByRnumber(@RequestParam(name = "rnumber") String rnumber) {
        LOGGER.debug("/findstudent requested with rnumber: " + rnumber);
        return _studentRepository.getStudentByRnumber(rnumber);
    }

    /**
     * Inserts a Student entry into the Students table. 
     * @param student The Student info to insert. 
     * @return HTTP OK if successful, HTTP CONFLICT otherwise. 
     */
    @ResponseBody
    @RequestMapping(value = "/insertstudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertStudent(@RequestBody Student student) {
        LOGGER.debug("/insertstudent requested.");
        try {
            _studentRepository.insertStudent(student);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            LOGGER.error("[ERROR] Exception caught when /insertstudent was requested.");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * Validates an Admin's login info from the front-end request. 
     * @param admin The Admin info to validate. 
     * @return HTTP OK if successfull, HTTP UNAUTHORIZED otherwise. 
     */
    @ResponseBody
    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> adminLogin(@RequestBody Admin admin) {
        LOGGER.debug("/adminlogin requested with admin: " + admin.toString());
        List<Admin> admins = _adminRepository.getAllAdmins();
        try {
            for(Admin a : admins) {
                if (a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
                    LOGGER.debug("/adminlogin successful.");
                    return ResponseEntity.ok(admin);
                }
            }
            LOGGER.debug("[ERROR] Admin login unsuccessful.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            LOGGER.error("[ERROR] Exception caught when /adminlogin was requested.");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



}
