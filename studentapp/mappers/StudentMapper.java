package com.jacobsiau.studentapp.mappers;

import java.util.List;

import com.jacobsiau.studentapp.models.Student;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The mapping interface to export SQL statements to interface with the Students table.
 */
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM STUDENTS")
    public List<Student> getAllStudents();

    @Select("SELECT * FROM STUDENTS WHERE rnumber = #{rnumber}")
    public List<Student> getStudentByRnumber(@Param("rnumber") String rnumber);
                               
    @Insert("INSERT INTO STUDENTS (rnumber, firstname, lastname, graddate, department, major, minor, username, email, password) " +
            "VALUES (#{student.rnumber}, #{student.firstname}, #{student.lastname}, #{student.graddate}, #{student.department}, " +
            "#{student.major}, #{student.minor}, #{student.username}, #{student.email}, #{student.password})")
            public void insertStudent(@Param("student") Student student);

    @Update("ALTER TABLE STUDENTS ALTER COLUMN ID RESTART WITH 1")
    public void updateStudentsNumbering();

    @Delete("DELETE FROM STUDENTS WHERE rnumber = #{rnumber}")
    public void deleteStudentByRnumber(@Param("rnumber") String rnumber);

    @Delete("DELETE FROM STUDENTS")
    public void deleteAllStudents();

}
