package com.jacobsiau.studentapp.repositories;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import com.jacobsiau.studentapp.mappers.StudentMapper;
import com.jacobsiau.studentapp.models.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The repository class to call database entry mapping methods via {@link com.jacobsiau.studentapp.mappers.StudentMapper}.
 */
@Repository
public class StudentRepository {

    // Logging 
    private Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Hooking up the mapping interface
    @Autowired
    private StudentMapper _studentMapper;

    // Constructor 
    public StudentRepository(StudentMapper _studentMapper){
        this._studentMapper = _studentMapper;
    }

    /**
     * Retrieves all Student entries from the Students table.
     * @return The list of Students.
     */
    public List<Student> getAllStudents() {
        LOGGER.debug("getAllStudents called.");
        List<Student> res = new ArrayList<>();
        res = _studentMapper.getAllStudents();
        return res;
    }

    /**
     * Retrieves a Student entry from the Students table based on the rnumber column.
     * @param rnumber The rnumber to retrieve by.
     * @return The single-item list of Students with the specified rnumber.
     */
    public List<Student> getStudentByRnumber(String rnumber) {
        LOGGER.debug("getStudentByRnumber called with rnumber: " + rnumber);
        List<Student> res = new ArrayList<>();
        res = _studentMapper.getStudentByRnumber(rnumber);
        return res;
    }

    /**
     * Inserts a Student entry into the Students table.
     * @param student The Student info to insert.
     */
    public void insertStudent(Student student) {
        LOGGER.debug("insertStudent called with student info: " + student.toString());
        _studentMapper.insertStudent(student);
    }

    /**
     * Restarts the numbering in the Students table.
     */
    public void updateStudentsNumbering() {
        LOGGER.debug("updateStudentsNumbering called.");
        _studentMapper.updateStudentsNumbering();
    }

    /**
     * Deletes a Student entry in the Students table by the rnumber column.
     * @param rnumber The rnumber to delete by.
     */
    public void deleteStudentByRnumber(String rnumber) {
        LOGGER.debug("deleteStudentByRnumber called with rnumber: " + rnumber);
        _studentMapper.deleteStudentByRnumber(rnumber);
    }

    /**
     * Deletes all Student entries in the Student table.
     */
    public void deleteAllStudents() {
        LOGGER.debug("deleteAllStudents called.");
        _studentMapper.deleteAllStudents();
    }

}
