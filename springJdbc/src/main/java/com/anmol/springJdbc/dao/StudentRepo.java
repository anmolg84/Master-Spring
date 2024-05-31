package com.anmol.springJdbc.dao;

import com.anmol.springJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {
    // JDBC Template
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s) {
        String query = "insert into student(rollno,name,marks) values(?,?,?)";
        // Update Used for Updating, Inserting and deleting
        int rows = jdbcTemplate.update(query,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows + " affected");
    }

    public List<Student> findAll() {
        String query = "Select * from student";
        // Row Mapper
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s=new Student();
                s.setRollNo(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMarks(rs.getInt(3));
                return s;
            }
        };
        return jdbcTemplate.query(query,mapper);
    }
}
