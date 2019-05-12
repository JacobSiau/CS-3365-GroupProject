package com.jacobsiau.studentapp.mappers;

import java.util.List;

import com.jacobsiau.studentapp.models.Admin;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The mapping interface to export SQL statements to interface with the Admins table.
 */
@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM ADMINS")
    public List<Admin> getAllAdmins();

    @Select("SELECT * FROM ADMINS WHERE rnumber = #{rnumber}")
    public List<Admin> getAdminByRnumber(@Param("rnumber") String rnumber);
    
    @Insert("INSERT INTO ADMINS (rnumber, firstname, lastname, username, email, pass)" +
            "VALUES (#{admin.rnumber}, #{admin.firstname}, #{admin.lastname}, " +
            "#{admin.username}, #{admin.email}, #{admin.password})")
            public void insertAdmin(@Param("admin") Admin admin);
            
    @Update("ALTER TABLE ADMINS ALTER COLUMN ID RESTART WITH 1")
    public void updateAdminsNumbering();

    @Delete("DELETE FROM ADMINS WHERE rnumber = #{rnumber}")
    public void deleteAdminByRnumber(@Param("rnumber") String rnumber);

    @Delete("DELETE FROM ADMINS")
    public void deleteAllAdmins();

}
