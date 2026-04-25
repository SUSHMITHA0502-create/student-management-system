package com.scms.dao;

import com.scms.db.DBConnection;
import com.scms.model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    
    public void addStudent(Student student) throws Exception {
        String sql = "CALL add_student_sp(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setDate(3, student.getDob());
            ps.executeUpdate();
        }
    }


    public List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("dob")
                );
                students.add(s);
            }
        }
        return students;
    }

   
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE students SET name=?, email=?, dob=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setDate(3, student.getDob());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        }
    }

    
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public void batchInsertStudents(List<Student> students) throws Exception {
        String sql = "INSERT INTO students(name, email, dob) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (Student s : students) {
                ps.setString(1, s.getName());
                ps.setString(2, s.getEmail());
                ps.setDate(3, s.getDob());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

}
